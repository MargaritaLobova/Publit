package com.publit.config.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws")
public class AwsConfigProperties {

    private String accessKey;
    private String privateKey;
    private String bucketName;
    private String bucketRegionName;

    public AwsConfigProperties() {
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketRegionName() {
        return bucketRegionName;
    }

    public void setBucketRegionName(String bucketRegionName) {
        this.bucketRegionName = bucketRegionName;
    }
}
