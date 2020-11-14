package com.loring.spring.aop_new;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@Component
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
