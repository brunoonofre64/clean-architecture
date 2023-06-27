package com.github.brunoonofre64.infra.ioc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageBundleConfig {
    private static final String DEFAULT_ENCODING = "UTF-8";

    @Bean
    @Qualifier("domainException")
    public ReloadableResourceBundleMessageSource domainExceptionMessageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setDefaultEncoding(DEFAULT_ENCODING);
        bundle.setBasename("classpath:domain-exception");
        return bundle;
    }

    @Bean
    @Qualifier("apiException")
    public ReloadableResourceBundleMessageSource apiExceptionMessageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setDefaultEncoding(DEFAULT_ENCODING);
        bundle.setBasename("classpath:api-exception");
        return bundle;
    }

    @Bean
    @Qualifier("infraDataException")
    public ReloadableResourceBundleMessageSource infraDataExceptionMessageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setDefaultEncoding(DEFAULT_ENCODING);
        bundle.setBasename("classpath:infradata-exception");
        return bundle;
    }
}
