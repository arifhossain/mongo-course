package com.arif.aws.dynamodbfun;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import sun.tools.jconsole.Tab;

public class DynamoTrials {

    private DynamoDB dynamoDB;

    public DynamoTrials() {
        dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder
                .defaultClient());
    }

    public void scanItems() {
        Table table = dynamoDB.getTable("books");

        ScanSpec scan = new ScanSpec()
                .withAttributesToGet("bookname", "author");

        ItemCollection<ScanOutcome> collection = table.scan(scan);
        collection.forEach(outcome ->
                System.out.println(outcome.asMap())
        );
    }

    public void getItem() {
        Table table = dynamoDB.getTable("books");
        Item book = table.getItem("bookid", "3");
        System.out.println(book.asMap());
    }

    public void query() {
        Table table = dynamoDB.getTable("books");

        table.query("bookid", "2").forEach(outcome -> System.out.println(outcome.asMap()));
    }

    public static void main(String[] args) {
        DynamoTrials trials = new DynamoTrials();
        trials.scanItems();

        System.out.println("=============");
        trials.query();
        System.out.println("=============");
        trials.getItem();
    }

}
