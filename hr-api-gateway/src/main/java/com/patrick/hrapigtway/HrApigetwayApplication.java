package com.patrick.hrapigtway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrApigetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApigetwayApplication.class, args);
	}

}
