package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Trung Nam", "nam", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Truong Tuyen", "tuyen", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ky Luong", "luong", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kiet Tuong", "tuong", "1234", new ArrayList<>()));

			userService.addRoleToUser("nam", "ROLE_USER");
			userService.addRoleToUser("nam", "ROLE_ADMIN");
			userService.addRoleToUser("tuyen", "ROLE_USER");
			userService.addRoleToUser("luong", "ROLE_USER");
			userService.addRoleToUser("luong", "ROLE_MANAGER");
			userService.addRoleToUser("tuong", "ROLE_SUPER_ADMIN");
		};
	}

}
