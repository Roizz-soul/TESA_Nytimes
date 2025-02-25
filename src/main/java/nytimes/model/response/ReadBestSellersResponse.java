package nytimes.model.response;

public class ReadBestSellersResponse {
    public String responseCode;
    public String responseMessage;
    public BestSellersResponse data;

    public ReadBestSellersResponse(String responseCode, String responseMessage, BestSellersResponse bestSellersResponse)
    {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = bestSellersResponse;
    }
}
