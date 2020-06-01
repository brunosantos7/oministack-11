package br.com.omini.bethehero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BetheheroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetheheroApplication.class, args);
	}
	

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/ong").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
