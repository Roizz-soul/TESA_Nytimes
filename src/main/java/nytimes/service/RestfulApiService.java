package nytimes.service;

import com.google.gson.Gson;
import nytimes.model.request.RestfulApiAddObjectRequest;
import nytimes.model.response.BookResponse;
import nytimes.model.response.ReadBookResponse;
import nytimes.model.response.ReadRestfulApiAddObjectResponse;
import nytimes.model.response.RestfulApiAddObjectResponse;
import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class RestfulApiService {
    public ReadRestfulApiAddObjectResponse restfulApiAddObject(RestfulApiAddObjectRequest restfulApiAddObjectRequest) {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var endpoint = "https://api.restful-api.dev/objects";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();
        var builtUrl = urlBuilder.build();

        // Convert request class to JSON
        String jsonBody = gson.toJson(restfulApiAddObjectRequest);

        // Create request body
        var body = RequestBody.create(
                jsonBody,
                MediaType.parse("application/json; charset=utf-8")
        );

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .post(body)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                var apiCreatePostResponse = gson.fromJson(responseBody, RestfulApiAddObjectResponse.class);

                return new ReadRestfulApiAddObjectResponse("00", "completed", apiCreatePostResponse);
            }

            return new ReadRestfulApiAddObjectResponse("106", apiResponse.message(), new RestfulApiAddObjectResponse());
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadRestfulApiAddObjectResponse("106", ex.getMessage(), new RestfulApiAddObjectResponse());

        }


    }
}
