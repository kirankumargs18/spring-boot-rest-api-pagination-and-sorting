package com.kirangs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Course API", version = "3", description = "Documentation Course API v1.0", contact = @Contact(name = "Kiran Kumar G S", email = "kiran@gmail.com", url = "kirangs.com")))
public class SpringBootRestApiPaginationAndSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiPaginationAndSortingApplication.class, args);
	}

}
