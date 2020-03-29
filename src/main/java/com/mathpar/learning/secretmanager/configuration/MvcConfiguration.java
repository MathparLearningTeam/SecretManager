package com.mathpar.learning.secretmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class MvcConfiguration {
    @Bean
    public HttpMessageConverter<Object> registerJacksone(){
        return new MappingJackson2HttpMessageConverter();
    }
}
