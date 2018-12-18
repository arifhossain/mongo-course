package com.arif.polly;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {

    private AmazonDynamoDB db = AmazonDynamoDBClientBuilder
            .defaultClient();

    public String putPost(String id, String text, String voice) {
        Map<String, AttributeValue> itemMap = new HashMap<>();
        itemMap.put("id", new AttributeValue().withS(id));
        itemMap.put("text", new AttributeValue().withS(text));
        itemMap.put("voice", new AttributeValue().withS(voice));
        itemMap.put("status", new AttributeValue().withS("PROCESSING"));

        PutItemRequest request = new PutItemRequest("posts", itemMap);

        PutItemResult result = db.putItem(request);
        return result.toString();
    }
}
