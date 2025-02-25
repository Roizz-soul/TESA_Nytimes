package nytimes.controller;

import nytimes.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nytimes.service.NytimesApiService;

@RestController
@RequestMapping("/")
public class NyTimesApiController {
    private final NytimesApiService nytimesapiService;

    @Autowired
    public NyTimesApiController(NytimesApiService nytimesapiService) {
        this.nytimesapiService = nytimesapiService;
    }

    @GetMapping("/ny-times-list-books")
    public ResponseEntity<ReadBookResponse> nyTimesReadBooks()
    {
        var bookResponse = nytimesapiService.nyTimesReadBooks();
        return ResponseEntity.ok(bookResponse);
    }
    @GetMapping("/ny-times-list-best-sellers")
    public ResponseEntity<ReadBestSellersResponse> nyTimesBestSellers()
    {
        var bestSellersResponse = nytimesapiService.nyTimesBestSellers();
        return ResponseEntity.ok(bestSellersResponse);
    }
    @GetMapping("/ny-times-list-names-best-sellers")
    public ResponseEntity<ReadBestSellersListNamesResponse> nyTimesBestSellersListNames()
    {
        var bestSellersListNamesResponse = nytimesapiService.nyTimesBestSellersListNames();
        return ResponseEntity.ok(bestSellersListNamesResponse);
    }
    @GetMapping("/ny-times-list-full-overview")
    public ResponseEntity<ReadFullOverviewResponse> nyTimesFullOverview()
    {
        var fullOverviewResponse = nytimesapiService.nyTimesFullOverview();
        return ResponseEntity.ok(fullOverviewResponse);
    }
    @GetMapping("/ny-times-list-best-sellers-by-data/{date}/{list}")
    public ResponseEntity<ReadBestSellersListByDateResponse> nyTimesBestSellersByDate(@PathVariable String date, @PathVariable String list)
    {
        var bestSellersByDateResponse = nytimesapiService.nyTimesBestSellersListByDate(date, list);
        return ResponseEntity.ok(bestSellersByDateResponse);
    }
}