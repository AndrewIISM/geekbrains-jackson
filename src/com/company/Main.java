package com.company;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
	// write your code here

        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        simpleSerialization();
    }

    private static void simpleDeserialization() throws IOException {
        URL resource = Main.class.getResource("/category.json");
        Category category = objectMapper.readValue(resource, Category.class);

        System.err.println(category);

    }


    private static void simpleSerialization() throws IOException {
        Category category = new Category();
        category.setId(123);
        category.setName("Фантастика");

        Book book = new Book();
//        book.setCategory(category);

        category.setBooks(List.of(book));

        String categoryJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(category);

        System.err.println(categoryJson);
    }

    private static void pointer() throws IOException {
        URL resource = Main.class.getResource("/simple.json");
        JsonNode jsonNode = objectMapper.readTree(resource);

        JsonNode node = jsonNode.at("/websites/0/description");
        System.err.println(node.asText());
    }

    private static void readArray() throws IOException {
        URL resource = Main.class.getResource("/array.json");
        ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(resource);

        for (JsonNode jsonNode : arrayNode) {
            if (jsonNode instanceof ObjectNode) {

                for (Iterator<String> it = jsonNode.fieldNames(); it.hasNext(); ) {
                    String nameField = it.next();
                }

            } else if (jsonNode instanceof BooleanNode) {

            }
        }
    }

    private static void readTree() throws IOException {
        URL resource = Main.class.getResource("/simple.json");
        JsonNode jsonNode = objectMapper.readTree(resource);
        System.err.println(jsonNode.get("first_name").asText());

        System.err.println(jsonNode.get("websites").get(0).get("description").asText());
    }
}
