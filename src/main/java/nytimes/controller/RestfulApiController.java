package nytimes.controller;

import nytimes.model.request.RestfulApiAddObjectRequest;
import nytimes.model.response.ReadBookResponse;
import nytimes.model.response.ReadRestfulApiAddObjectResponse;
import nytimes.service.NytimesApiService;
import nytimes.service.RestfulApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restful-api")
public class RestfulApiController {
    private final RestfulApiService restfulApiService;

    @Autowired
    public RestfulApiController(RestfulApiService restfulApiService) {
        this.restfulApiService = restfulApiService;
    }

    @PostMapping("/add-object")
    public ResponseEntity<ReadRestfulApiAddObjectResponse> RestfulApiAddObject(@RequestBody RestfulApiAddObjectRequest body)
    {
        var addObjectResponse = restfulApiService.restfulApiAddObject(body);
        return ResponseEntity.ok(addObjectResponse);
    }
}
