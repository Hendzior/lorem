package com.marcin.lorem.configuration;

import com.marcin.lorem.service.Lorem;
import com.marcin.lorem.service.LoremIpsum;
import com.marcin.lorem.service.LoremIpsumExternal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class LoremConfig {

    @Profile("MyLorem")
    @Bean
    public Lorem loremIpsum() {
        return new LoremIpsum();
    }

    @Profile("External")
    @Bean
    public Lorem loremIpsumExternal() {
        return new LoremIpsumExternal();
    }
}
