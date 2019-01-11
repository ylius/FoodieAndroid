package com.example.chihuo;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YelpApiv3 {
    private static final String API_HOST = "api.yelp.com";
    private static final String SEARCH_PATH = "/v3/businesses/search";

    private static final String API_KEY = "API_KEY";

    private final OkHttpClient client;

    public YelpApiv3() {
        this.client = new OkHttpClient();
    }

    public String searchForBusinessesByLocation(String term, String location, int searchLimit) throws IOException {
        Request request = new Request.Builder()
                .url("https://" + API_HOST + SEARCH_PATH
                        + "?term=" + term
                        + "&location=" + location
                        + "&limit=" + String.valueOf(searchLimit))
                .addHeader("Authorization", "Bearer" + " " + API_KEY)
                .build();
        Response response = client.newCall(request).execute();
        String responseBodyString = response.body().string(); // The response body can be consumed only once
        response.close();
        Log.i("message", responseBodyString);
        return responseBodyString;
    }
}
