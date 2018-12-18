package com.arif.polly;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

public class NewPostHandler implements RequestStreamHandler {

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
        LambdaLogger logger = context.getLogger();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Map<String, Object> eventMap = JsonUtil.fromJson(reader, Map.class);
        eventMap.entrySet().stream()
                .forEach(entry -> logger.log(entry.getKey() +" -> " + entry.getValue() + "\n"));

        String voice = (String) eventMap.get("voice");
        String text = (String) eventMap.get("text");
        String uuid = UUID.randomUUID().toString();

        //Store in dynamo
        PostRepository repository = new PostRepository();
        String putResult = repository.putPost(uuid, text, voice);
        logger.log("put result: " + putResult);

        //publish in sns
        AmazonSNS snsClient = AmazonSNSClientBuilder
                .defaultClient();
        snsClient.publish("arn:aws:sns:us-east-2:395305622959:arif-sns-polly", uuid);

        
    }

}
