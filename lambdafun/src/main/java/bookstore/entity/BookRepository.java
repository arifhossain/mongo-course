package bookstore.entity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private AmazonDynamoDB db = AmazonDynamoDBClientBuilder
            .defaultClient();

    public List<Book> getBookList() {
        ScanRequest request = new ScanRequest()
                .withTableName("books");

        ScanResult result = db.scan(request);
        List<Book> books = result.getItems().stream()
                .map(entry -> new Book(
                        Integer.parseInt(entry.get("bookid").getS()),
                        entry.get("bookname").getS(),
                        entry.get("author").getS()
                        ))
                .collect(Collectors.toList());

        return books;
    }
}
