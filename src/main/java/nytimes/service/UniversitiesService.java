package nytimes.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nytimes.model.request.RestfulApiAddObjectRequest;
import nytimes.model.response.*;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversitiesService {
    public ReadUniversitiesResponse universitiesList(String country) {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var endpoint = "http://universities.hipolabs.com/search";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("name", "");
        urlBuilder.addQueryParameter("country", country);
        System.out.println(urlBuilder.toString());

        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                Type listType = new TypeToken<ArrayList<UniversitiesResponse>>() {}.getType();
                ArrayList<UniversitiesResponse> universitiesList = gson.fromJson(responseBody, listType);


                return new ReadUniversitiesResponse("00", "completed", universitiesList);
            }

            return new ReadUniversitiesResponse("106", apiResponse.message(), new ArrayList<>(List.of(new UniversitiesResponse())));
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadUniversitiesResponse("106", ex.getMessage(), new ArrayList<>(List.of(new UniversitiesResponse())));

        }


    }
}
