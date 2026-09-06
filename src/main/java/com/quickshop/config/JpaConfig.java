package com.quickshop.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing // Enables @CreatedDate, @LastModifiedDate, @CreatedBy
@EnableJpaRepositories(basePackages = "com.quickshop.repository")
public class JpaConfig {
    // Spring Boot manages the PostgreSQL DataSource and EntityManagerFactory automatically.
}
