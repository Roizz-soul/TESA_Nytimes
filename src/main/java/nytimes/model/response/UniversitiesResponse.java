package nytimes.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class UniversitiesResponse {
    public String alpha_two_code;
    @JsonProperty("state-province")
    public Object state_province;
    public String country;
    public ArrayList<String> web_pages;
    public ArrayList<String> domains;
    public String name;
}