package nytimes.controller;

import nytimes.model.request.RestfulApiAddObjectRequest;
import nytimes.model.response.ReadRestfulApiAddObjectResponse;
import nytimes.model.response.ReadUniversitiesResponse;
import nytimes.service.RestfulApiService;
import nytimes.service.UniversitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universities")
public class UniversitiesController {
    private final UniversitiesService universitiesService;

    @Autowired
    public UniversitiesController(UniversitiesService universitiesService) {
        this.universitiesService = universitiesService;
    }

    @GetMapping("/all/{country}")
    public ResponseEntity<ReadUniversitiesResponse> listUniversitiesInCountry(@PathVariable String country)
    {
        var listUniversitiesResponse = universitiesService.universitiesList(country);
        return ResponseEntity.ok(listUniversitiesResponse);
    }
}
