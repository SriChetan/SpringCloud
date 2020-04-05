package com.chetan.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientApplication {

	@Autowired
	private Config config;

	@Value("${user.company}")
	private String company;



	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@GetMapping("/config")
	public String getConfig(){
		return "From Bean =" + config.getCompany() + "\n" + "from @value =" + company;
	}


}
