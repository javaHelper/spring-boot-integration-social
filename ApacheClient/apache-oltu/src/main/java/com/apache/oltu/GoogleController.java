package com.apache.oltu;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/google")
public class GoogleController {
	private static final Logger logger = LoggerFactory.getLogger(GoogleController.class);

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String authenticate() throws OAuthSystemException {
		OAuthClientRequest request = OAuthClientRequest
				.authorizationLocation("https://accounts.google.com/o/oauth2/auth")
				.setClientId("755676439314-jcumfghnkmcm72hf40beikvoatknstml.apps.googleusercontent.com")
				.setRedirectURI("http://localhost:8080/apache-oltu/google/redirect")
				.setResponseType("code")
				.setScope("https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read https://www.googleapis.com/auth/plus.me")
				//.setScope("openId profile email")
				.buildQueryMessage();

		//https://www.google.com/m8/feeds, https://www.googleapis.com/auth/userinfo.email, https://www.googleapis.com/auth/userinfo.profile

		System.out.println("REDIRECT TO: "+request.getLocationUri());
		return "redirect:" + request.getLocationUri();
	}


	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public HttpEntity<String> redirect(
			@RequestParam(value = "code", required = false) String code) 
					throws OAuthSystemException, OAuthProblemException {
		String value = "UNKNOWN";

		if (code != null && code.length() > 0) {
			System.out.println("Received CODE: "+code);
			String details = getAccessToken(code);
			value = details;
		}

		return new ResponseEntity<String>(value,HttpStatus.OK);
	}

	private String getAccessToken(String authorizationCode) throws OAuthSystemException, OAuthProblemException {
		OAuthClientRequest request = OAuthClientRequest
				.tokenLocation("https://accounts.google.com/o/oauth2/token")
				//.tokenProvider(OAuthProviderType.GOOGLE)
				.setGrantType(GrantType.AUTHORIZATION_CODE)
				.setClientId("755676439314-jcumfghnkmcm72hf40beikvoatknstml.apps.googleusercontent.com")
				.setClientSecret("9kT21H5EO3DHRUdlkzzt5eVo")
				.setRedirectURI("http://localhost:8080/apache-oltu/google/redirect")
				.setCode(authorizationCode)
				.buildBodyMessage();

		//create OAuth client that uses custom http client under the hood
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());


		OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request, "POST");                       
		//GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);
		//String accessToken = oAuthResponse.getAccessToken();

		System.out.println("POSTING: "+request.getBody());	            
		System.out.println("Received ACCESS_TOKEN: [ "+oAuthResponse.getAccessToken() + "]");
		System.out.println("Received EXPIRES_IN: [ "+oAuthResponse.getExpiresIn() + "]");
		System.out.println("REFRESH_TOKEN : [" + oAuthResponse.getRefreshToken() + "]");

		System.out.println(oAuthResponse.getBody());

		//https://www.googleapis.com/plus/v1/people/me
		//https://www.googleapis.com/auth/userinfo.profile
		// TODO: https://developers.google.com/accounts/docs/OAuth2ForDevices
		request= new OAuthBearerClientRequest("https://www.googleapis.com/plus/v1/people/me").
				setAccessToken(oAuthResponse.getAccessToken()).
				buildQueryMessage();
		OAuthClient client = new OAuthClient(new URLConnectionClient());
		OAuthResourceResponse resourceResponse= client.resource(request, "GET", OAuthResourceResponse.class);

		if (resourceResponse.getResponseCode()==200){			
			System.out.println("HTTP OK");
			System.out.println(resourceResponse.getBody());
			return resourceResponse.getBody();
		}
		else{
			System.out.println("Could not access resource: " + resourceResponse.getResponseCode() 
					+ " " + resourceResponse.getBody());
			return null;
		}
	}   
}
