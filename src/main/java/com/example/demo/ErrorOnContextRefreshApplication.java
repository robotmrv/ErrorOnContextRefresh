package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ErrorOnContextRefreshApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ErrorOnContextRefreshApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
		springApplication.run(args);
	}

}

@RestController
class Ctrl {

	@GetMapping
	Mono<Void> test() {
		return Mono.empty();
	}

}
