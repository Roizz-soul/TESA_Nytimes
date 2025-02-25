package nytimes.model.response;

import java.util.ArrayList;

public class BestSellersResponse {
    public String status;
    public String copyright;
    public int num_results;
    public ArrayList<Result2> results;
}
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Isbn2 {
    public String isbn10;
    public String isbn13;
}

class RanksHistory{
    public String primary_isbn10;
    public String primary_isbn13;
    public int rank;
    public String list_name;
    public String display_name;
    public String published_date;
    public String bestsellers_date;
    public int weeks_on_list;
    public Object ranks_last_week;
    public int asterisk;
    public int dagger;
}

class Result2{
    public String title;
    public String description;
    public String contributor;
    public String author;
    public String contributor_note;
    public double price;
    public String age_group;
    public String publisher;
    public ArrayList<Isbn2> isbns;
    public ArrayList<RanksHistory> ranks_history;
    public ArrayList<Review2> reviews;
}

class Review2 {
    public String book_review_link;
    public String first_chapter_link;
    public String sunday_review_link;
    public String article_chapter_link;
}



