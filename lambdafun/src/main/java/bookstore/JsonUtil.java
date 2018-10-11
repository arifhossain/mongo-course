package bookstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static <T>T fromJson(String json, Class<T> klass) {
        return gson.fromJson(json, klass);
    }

    public static <T>T fromJson(Reader reader, Class<T> klass) {
        return gson.fromJson(reader, klass);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
