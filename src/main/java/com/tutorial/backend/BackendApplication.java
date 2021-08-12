package com.tutorial.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tutorial.backend.dto.UserCreateDTO;
import com.tutorial.backend.service.UserService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	CommandLineRunner createInitialUser(UserService userService) {
		return(args) -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("kerim.aksak");
			user.setFirstName("Kerim");
			user.setLastName("AKSAK");
			userService.createUser(user);
		};
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.tutorial.backend"))                                       
          .build();                                           
    }

}	
