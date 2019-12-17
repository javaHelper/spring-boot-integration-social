package com.apache.oltu;

public class App {

	public String removeDecimals(String value){
		StringBuffer sb = new StringBuffer(value);

		int index = value.indexOf(".");
		if(index == -1){
			sb.append("00");
		}
		else{
			sb.append("00");
			String preDecimalValue = value.substring(0, index);
			String postDecimalValue = value.substring(index+1, index+3);

			sb = new StringBuffer(preDecimalValue);
			sb.append(postDecimalValue);
		}
		return sb.toString();
	}

	public String AddDecimals(String value){
		long valuenum = Long.parseLong(value);

		//Get the divisor
		int divisor = 1;
		int srcDecimalLen = 2;
		int dstDecimalLen = 2;
		for (int i = 0; i < srcDecimalLen; i++){
			divisor = divisor * 10;
		}

		int whole = (int) (valuenum / divisor);
		long rounded = whole * divisor;
		int part = (int) (valuenum - rounded);

		String wholearr = String.format("%d", whole);
		String partarr = String.format("%d", part);

		StringBuffer partstr = new StringBuffer();
		for (int i = 0; i < (srcDecimalLen - partarr.length()); i++) {
			partstr.append("0");
		}

		partstr.append(partarr);
		partstr.append("000000000");

		StringBuilder wholestr = new StringBuilder(wholearr);
		if (dstDecimalLen > 0) {
			wholestr.append(".");
			wholestr.append(partstr.substring(0,dstDecimalLen));
		}
		return wholestr.toString();
	}

	public static void main( String[] args ){
		App app = new App();
		System.out.println(app.removeDecimals("10.00"));
		System.out.println(app.AddDecimals("1000"));
	}
}

