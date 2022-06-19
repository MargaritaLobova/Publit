package com.publit;

import com.publit.config.aws.AwsConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AwsConfigProperties.class)
public class PublitApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublitApplication.class, args);
    }

}
