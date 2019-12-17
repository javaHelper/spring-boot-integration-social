package com.howtodoinjava.redis;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.howtodoinjava.redis.model.Category;
import com.howtodoinjava.redis.model.User;
import com.howtodoinjava.redis.repository.CategoryRepository;
import com.howtodoinjava.redis.repository.UserRepository;

@SpringBootApplication
public class SpringBootRedisRelationshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisRelationshipApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		saveData();
	}

	private void saveData() {
		Category c1 = Category.builder().categoryId("c1").name("Cinema").type("Movies").build();
		Category c2 = Category.builder().categoryId("c2").name("Sports").type("Sports").build();
		Category c3 = Category.builder().categoryId("c3").name("Music").type("Music").build();
		Category c4 = Category.builder().categoryId("c4").name("Nature").type("Nature").build();
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));

		User u1 = User.builder().userId("u1").firstName("Chris").emailId("chris.rogers@gmail.com").categories(Arrays.asList(c1, c2)).build(); //1
		User u2 = User.builder().userId("u2").firstName("John").emailId("john.doe@gmail.com").categories(Arrays.asList(c2, c3)).build();  //2
		User u3 = User.builder().userId("u3").firstName("Julia").emailId("julia.cox@gmail.com").categories(Arrays.asList(c3, c4)).build(); //3
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}
}
