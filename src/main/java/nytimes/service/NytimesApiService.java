package nytimes.service;

import nytimes.model.response.*;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

@Service
public class NytimesApiService {
    public ReadBookResponse nyTimesReadBooks()
    {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var defaultListValue = "hardcover-fiction";
        var apiKey = "GgSLXffX5Qp5Gw5p6AbWdHNdRistdrWL";
        var endpoint = "https://api.nytimes.com/svc/books/v3/lists.json";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("api-key", apiKey);
        urlBuilder.addQueryParameter("list",defaultListValue);


        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try
        {
            var apiResponse = client.newCall(request).execute();
            if(apiResponse.isSuccessful())
            {
                String responseBody = apiResponse.body().string();
                var bookResponse = gson.fromJson(responseBody, BookResponse.class);

                return new ReadBookResponse("00","completed",bookResponse);
            }

            return new ReadBookResponse("106",apiResponse.message(),new BookResponse());
        }
        catch(Exception ex)
        {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadBookResponse("106",ex.getMessage(),new BookResponse());

        }







    }

    public ReadBestSellersResponse nyTimesBestSellers() {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var apiKey = "GgSLXffX5Qp5Gw5p6AbWdHNdRistdrWL";
        var endpoint = "https://api.nytimes.com/svc/books/v3/lists/best-sellers/history.json";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("api-key", apiKey);
//        urlBuilder.addQueryParameter("list",defaultListValue);


        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                var bestSellersResponse = gson.fromJson(responseBody, BestSellersResponse.class);

                return new ReadBestSellersResponse("00", "completed", bestSellersResponse);
            }

            return new ReadBestSellersResponse("106", apiResponse.message(), new BestSellersResponse());
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadBestSellersResponse("106", ex.getMessage(), new BestSellersResponse());

        }
    }

    public ReadBestSellersListNamesResponse nyTimesBestSellersListNames() {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var apiKey = "GgSLXffX5Qp5Gw5p6AbWdHNdRistdrWL";
        var endpoint = "https://api.nytimes.com/svc/books/v3/lists/names.json";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("api-key", apiKey);
//        urlBuilder.addQueryParameter("list",defaultListValue);


        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                var bestSellersListNamesResponse = gson.fromJson(responseBody, BestSellersListNamesResponse.class);

                return new ReadBestSellersListNamesResponse("00", "completed", bestSellersListNamesResponse);
            }

            return new ReadBestSellersListNamesResponse("106", apiResponse.message(), new BestSellersListNamesResponse());
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadBestSellersListNamesResponse("106", ex.getMessage(), new BestSellersListNamesResponse());

        }
    }

    public ReadFullOverviewResponse nyTimesFullOverview() {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var apiKey = "GgSLXffX5Qp5Gw5p6AbWdHNdRistdrWL";
        var endpoint = "https://api.nytimes.com/svc/books/v3/lists/full-overview.json";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("api-key", apiKey);
//        urlBuilder.addQueryParameter("list",defaultListValue);


        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                var fullOverviewResponse = gson.fromJson(responseBody, FullOverviewResponse.class);

                return new ReadFullOverviewResponse("00", "completed", fullOverviewResponse);
            }

            return new ReadFullOverviewResponse("106", apiResponse.message(), new FullOverviewResponse());
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadFullOverviewResponse("106", ex.getMessage(), new FullOverviewResponse());

        }
    }

    public ReadBestSellersListByDateResponse nyTimesBestSellersListByDate(String date, String list) {
        //step 1: initialise http client
        //get http client
        var client = new OkHttpClient();

        //for converting gson
        var gson = new Gson();

        //hard code list
        var apiKey = "GgSLXffX5Qp5Gw5p6AbWdHNdRistdrWL";
        var endpoint = "https://api.nytimes.com/svc/books/v3/lists/" + date+ "/" + list + ".json";

        // Build URL with query parameters
        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();

        urlBuilder.addQueryParameter("api-key", apiKey);
//        urlBuilder.addQueryParameter("list",defaultListValue);


        var builtUrl = urlBuilder.build();

        // Create request
        var request = new Request.Builder()
                .url(builtUrl)
                .build();

        try {
            var apiResponse = client.newCall(request).execute();
            if (apiResponse.isSuccessful()) {
                String responseBody = apiResponse.body().string();
                var bestSellersListByDateResponse = gson.fromJson(responseBody, BestSellersListByDateResponse.class);

                return new ReadBestSellersListByDateResponse("00", "completed", bestSellersListByDateResponse);
            }

            return new ReadBestSellersListByDateResponse("106", apiResponse.message(), new BestSellersListByDateResponse());
        } catch (Exception ex) {

            System.out.println(">> EXCEPTION ");
            System.out.println(ex.getMessage());

            return new ReadBestSellersListByDateResponse("106", ex.getMessage(), new BestSellersListByDateResponse());

        }
    }
}
