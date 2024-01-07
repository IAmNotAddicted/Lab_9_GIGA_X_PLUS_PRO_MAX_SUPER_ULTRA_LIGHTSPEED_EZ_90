package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ProductFetcher {

    private static final String API_URL = "https://fakestoreapi.com/products";

    public List<Product> getAllProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product[] productsArray = objectMapper.readValue(new URL(API_URL), Product[].class);
        return Arrays.asList(productsArray);
    }
}

