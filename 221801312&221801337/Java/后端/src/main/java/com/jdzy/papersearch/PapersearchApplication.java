package com.jdzy.papersearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySource(value="secret.properties")
public class PapersearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapersearchApplication.class, args);
	}

}
