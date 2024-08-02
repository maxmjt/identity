package com.example.identity.client;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Max.Jimenez
 */
@Configuration
@ComponentScan("com.example.identity.client")
@Import({
        com.example.identity.persistence.Config.class
})
@EntityScan(basePackages = {"com.example.identity.persistence"})
@EnableJpaRepositories(basePackages = {"com.example.identity.persistence"})
public class Config {
}
