package nytimes.model.response;

public class ReadRestfulApiAddObjectResponse {
    public String responseCode;
    public String responseMessage;
    public RestfulApiAddObjectResponse data;

    public ReadRestfulApiAddObjectResponse(String responseCode, String responseMessage, RestfulApiAddObjectResponse restfulApiAddObjectResponse)
    {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = restfulApiAddObjectResponse;
    }
}
