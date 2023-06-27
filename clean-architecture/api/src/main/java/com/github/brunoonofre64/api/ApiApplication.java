package com.github.brunoonofre64.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.github.brunoonofre64.infra", "com.github.brunoonofre64.app", "com.github.brunoonofre64.api"})
@EnableJpaRepositories({"com.github.brunoonofre64.infra.data.repositories", "com.github.brunoonofre64.infra.data.adapters"})
@EntityScan("com.github.brunoonofre64.infra.data.entities")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
