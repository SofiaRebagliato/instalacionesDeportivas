package com.example.instalacionesDeportivas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//import org.springframework.security.access.SecurityConfig;

@Configuration
//@Import({SecurityConfig.class})
@SpringBootApplication
public class InstalacionesDeportivasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstalacionesDeportivasApplication.class, args);
		
	} 

}
