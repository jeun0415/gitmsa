package org.cew.conf;

import org.cew.components.AA;
import org.cew.components.BB;
import org.cew.components.CC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean
    public AA aa(){
        return new AA();
    }

    @Bean
    public BB bb(){
        return new BB();
    }

    @Bean
    public CC cc(){
        return new CC();
    }
}
