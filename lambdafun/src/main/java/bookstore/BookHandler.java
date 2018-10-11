package bookstore;

import bookstore.entity.Book;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import bookstore.entity.BookRepository;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookHandler implements RequestStreamHandler {

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Map<String, Object> event = JsonUtil.fromJson(reader, Map.class);
        event.entrySet().stream()
                .forEach(entry -> logger.log(entry.getKey() +" -> " + entry.getValue() + "\n"));

        Map pathParams = (Map) event.get("pathParameters");
        String bookId = (String) pathParams.get("bookid");
        logger.log("Book ID: " + bookId +"\n");

        BookRepository repository = new BookRepository();
        List<Book> bookList = repository.getBookList();

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 200);

        String bookListJson = JsonUtil.toJson(bookList);
        response.put("body", bookListJson);


        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write(JsonUtil.toJson(response));
        writer.close();
    }

    private void log(LambdaLogger logger, String logMsg) {
        logger.log(logMsg + "\n");
    }

//    public static void main(String[] args) throws IOException {
//        BookHandler handler = new BookHandler();
//        handler.handleRequest(null, System.out, null);
//    }

}
