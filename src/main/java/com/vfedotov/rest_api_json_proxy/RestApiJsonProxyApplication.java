package com.vfedotov.rest_api_json_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
scanBasePackages = {
		"com.vfedotov.dao_layer",
		"com.vfedotov.controllers",
		"com.vfedotov.services_layer",
		})
public class RestApiJsonProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiJsonProxyApplication.class, args);
	}

}
