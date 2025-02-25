package nytimes.model.response;

import java.util.ArrayList;

public class BestSellersListNamesResponse {
    public String status;
    public String copyright;
    public int num_results;
    public ArrayList<Result3> results;
}
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Result3{
    public String list_name;
    public String display_name;
    public String list_name_encoded;
    public String oldest_published_date;
    public String newest_published_date;
    public String updated;
}


