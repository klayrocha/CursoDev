package com.klayrocha.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.klayrocha.core.property.JwtConfiguration;

@SpringBootApplication
@EntityScan({"com.klayrocha.core.model"})
@EnableJpaRepositories({"com.klayrocha.core.repository"})
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("com.klayrocha")
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
