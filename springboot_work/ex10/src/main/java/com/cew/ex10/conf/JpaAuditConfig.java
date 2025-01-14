package com.cew.ex10.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class JpaAuditConfig {

    @Bean
    public AuditorAware<String> auditorAware(){

        AuditorAware<String> auditorAware =
                () -> Optional.of("고길동");

        return auditorAware;
    }
}
