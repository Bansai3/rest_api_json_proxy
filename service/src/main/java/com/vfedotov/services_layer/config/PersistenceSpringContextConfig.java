package com.vfedotov.services_layer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.vfedotov.dao_layer.dao")
@EnableJpaRepositories("com.vfedotov.dao_layer.dao")
public class PersistenceSpringContextConfig {
}