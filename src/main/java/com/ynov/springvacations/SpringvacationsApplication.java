package com.ynov.springvacations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringvacationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringvacationsApplication.class, args);
	}

}
