package com.krishnaedu.edu_identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EduIdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduIdentityApplication.class, args);
	}

}
