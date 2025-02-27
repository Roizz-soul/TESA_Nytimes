package nytimes.model.response;

public class ReadUniversitiesResponse {
    public String responseCode;
    public String responseMessage;
    public UniversitiesResponse data;

    public ReadUniversitiesResponse(String responseCode, String responseMessage, UniversitiesResponse universitiesResponse)
    {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = universitiesResponse;
    }
}
