package com.nouhoun.springboot.jwt.integration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by nydiarra on 06/05/17.
 */
@Configuration
@Import({SecurityConfig.class})
public class MainConfig {
}
