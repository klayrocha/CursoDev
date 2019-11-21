package com.klayrocha.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.klayrocha.core.model.ApplicationUser;
import com.klayrocha.core.property.JwtConfiguration;
import com.klayrocha.core.repository.ApplicationUserRepository;

@SpringBootApplication
@EntityScan({"com.klayrocha.core.model"})
@EnableJpaRepositories({"com.klayrocha.core.repository"})
@EnableEurekaClient
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("com.klayrocha")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(applicationUserRepository, passwordEncoder);
        };

    }
    
	private void initUsers(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
		ApplicationUser admin = new ApplicationUser();
        admin.setUsername("klayrocha");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRole("ADMIN");

        ApplicationUser find = applicationUserRepository.findByUsername("klayrocha");
        if (find == null) {
        	applicationUserRepository.save(admin);
        }
    }

}
