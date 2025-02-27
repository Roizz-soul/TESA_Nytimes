package nytimes.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RestfulApiAddObjectResponse {
    public String id;
    public String name;
    public Data data;
    public Date createdAt;
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Data{
    public int year;
    public double price;
    @JsonProperty("CPU model")
    public String cpuModel;
    @JsonProperty("Hard disk size")
    public String hardDiskSize;
}

