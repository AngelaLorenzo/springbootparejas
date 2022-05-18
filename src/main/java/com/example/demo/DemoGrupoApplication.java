package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoGrupoApplication {

	@Bean
	public RestTemplate getresttemplate(){
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoGrupoApplication.class, args);
	}

}
