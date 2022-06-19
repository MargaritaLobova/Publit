package com.publit.data.dao.repos;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.publit.config.aws.S3Credentials;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class S3Repository {

    private final AmazonS3 client;

    private final String bucketName;

    public S3Repository(S3Credentials credentials) {
        client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials.getAwsCredentials()))
                .withRegion(Regions.fromName(credentials.getBucketRegionName()))
                .build();

        bucketName = credentials.getBucketName();
    }

    public void addFile(String name, InputStream contentStream) {
        client.putObject(
                bucketName,
                name,
                contentStream,
                new ObjectMetadata()
        );
    }

    public InputStream getFileStream(String name) {
        return client.getObject(bucketName, name).getObjectContent();
    }
}
