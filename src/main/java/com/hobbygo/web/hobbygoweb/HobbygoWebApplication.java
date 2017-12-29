package com.hobbygo.web.hobbygoweb;

import com.vaadin.peter.addon.beangrid.EnableBeanGrid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableBeanGrid
public class HobbygoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbygoWebApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
