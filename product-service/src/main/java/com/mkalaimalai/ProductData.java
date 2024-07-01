package com.mkalaimalai;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mkalaimalai.product_service.domain.ProductCategory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class ProductData {

//    public static void main(String[] args) throws Exception{
//        AsyncHttpClient client = new DefaultAsyncHttpClient();
//        client.prepare("GET", "https://apidojo-forever21-v1.p.rapidapi.com/products/v2/list?pageSize=48&pageNumber=1&sortby=0&filterColor=BLACK&filterSize=XS%2FS&category=women_new_arrivals_clothing")
//                .setHeader("x-rapidapi-key", "617f1902b3mshb2294ab0c504c77p166810jsn715017189e7b")
//                .setHeader("x-rapidapi-host", "apidojo-forever21-v1.p.rapidapi.com")
//                .execute()
//                .toCompletableFuture()
//                .thenAccept(System.out::println)
//                .join();
//
//        client.close();
//    }


    public static void main(String[] args) throws Exception {
        // API URL for hourly weather forecast
        String url = "https://apidojo-forever21-v1.p.rapidapi.com/products/v2/list?pageSize=48&pageNumber=1&sortby=0&filterColor=BLACK&filterSize=XS%2FS&category=women_new_arrivals_clothing";
        String rapidApiKey = "617f1902b3mshb2294ab0c504c77p166810jsn715017189e7b";
        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", "apidojo-forever21-v1.p.rapidapi.com");

        // Create HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send GET request to the API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        Gson gson = new GsonBuilder().create();

        ProductCategory ProductCategory = gson.fromJson(String.valueOf(response), new TypeToken<ProductCategory>() {

        }.getType());


        // Return response body
        System.out.println(ProductCategory);
        System.out.println(response.getBody());
    }
}
