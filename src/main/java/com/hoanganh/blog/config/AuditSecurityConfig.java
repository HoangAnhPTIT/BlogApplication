package com.hoanganh.blog.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class AuditSecurityConfig {
	@Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
