package com.arif.aws.s3fun;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Tryouts {

    public static void main(String[] args) {
        AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

        s3.listBuckets().stream()
                .forEach(bucket -> System.out.println(bucket.getName()));
    }
}
