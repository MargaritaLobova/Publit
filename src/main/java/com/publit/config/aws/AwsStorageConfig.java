package com.publit.config.aws;

import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsStorageConfig {

    private final AwsConfigProperties properties;

    public AwsStorageConfig(AwsConfigProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "awsCredentials")
    public S3Credentials credentials() {
        return new S3Credentials(
                new BasicAWSCredentials(
                        properties.getAccessKey(),
                        properties.getPrivateKey()
                ),
                properties.getBucketName(),
                properties.getBucketRegionName()
        );
    }
}
