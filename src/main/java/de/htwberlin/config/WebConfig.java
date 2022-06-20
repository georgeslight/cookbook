package de.htwberlin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("*")
                .allowedMethods("*")
                .allowedOrigins(
                        "https://localhost:3000",
                        "https://webtech-cookbook-frontend.herokuapp.com"
                );
    }

}