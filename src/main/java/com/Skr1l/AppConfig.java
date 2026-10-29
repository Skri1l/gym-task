package com.Skr1l;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.Skr1l")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
