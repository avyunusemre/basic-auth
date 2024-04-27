package com.yunuskaya.basicauth;

import com.yunuskaya.basicauth.dto.CreateUserRequest;
import com.yunuskaya.basicauth.model.Role;
import com.yunuskaya.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;


    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Yunus")
				.username("emre")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER))
				.build();

		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("Abdulsamet")
				.username("abd")
				.password("pass2")
				.authorities(Set.of(Role.ROLE_REPORTER))
				.build();

		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("Rumeysa")
				.username("rm")
				.password("pass3")
				.authorities(Set.of(Role.ROLE_ADMIN, Role.ROLE_MOD))
				.build();

		userService.createUser(request3);
	}
}
