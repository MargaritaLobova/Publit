package com.publit.config.aws;

import com.amazonaws.auth.BasicAWSCredentials;

public class S3Credentials {

    private final BasicAWSCredentials awsCredentials;
    private final String bucketName;
    private final String bucketRegionName;

    public S3Credentials(BasicAWSCredentials awsCredentials, String bucketName, String bucketRegionName) {
        this.awsCredentials = awsCredentials;
        this.bucketName = bucketName;
        this.bucketRegionName = bucketRegionName;
    }

    public BasicAWSCredentials getAwsCredentials() {
        return awsCredentials;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getBucketRegionName() {
        return bucketRegionName;
    }
}
