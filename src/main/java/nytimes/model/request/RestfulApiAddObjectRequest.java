package nytimes.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestfulApiAddObjectRequest {
    public String name;
    public Data data;
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Data{
    public int year;
    public double price;
    @JsonProperty("CPU model")
    public String cPUModel;
    @JsonProperty("Hard disk size")
    public String hardDiskSize;
}

