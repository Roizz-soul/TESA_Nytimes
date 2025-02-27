package nytimes.model.response;

import java.util.ArrayList;

public class ReadUniversitiesResponse {
    public String responseCode;
    public String responseMessage;
    public mainData data;

    public ReadUniversitiesResponse(String responseCode, String responseMessage, ArrayList<UniversitiesResponse> universitiesResponse)
    {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = new mainData(universitiesResponse);
    }
}

class mainData {
    public ArrayList<UniversitiesResponse> universities;

    public mainData(ArrayList<UniversitiesResponse> universities) {
        this.universities = universities;
    }
}




