package com.SpringBootWebpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebpageApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebpageApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebpageApplication.class);
    }

}
