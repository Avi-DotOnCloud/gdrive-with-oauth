package com.gdrive.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class OauthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
}
