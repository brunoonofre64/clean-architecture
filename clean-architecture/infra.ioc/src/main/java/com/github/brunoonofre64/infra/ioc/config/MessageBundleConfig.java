package com.github.brunoonofre64.infra.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageBundleConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setDefaultEncoding("UTF-8");
        bundle.setBasenames("classpath:app-exception","classpath:domain-exception","classpath:infradata-exception");
        return bundle;
    }
}
