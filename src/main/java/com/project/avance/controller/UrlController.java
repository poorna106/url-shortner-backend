package com.project.avance.controller;

import com.project.avance.entity.Url;
import com.project.avance.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

    @Autowired
    UrlService service;

    @GetMapping("/getAllUrl")
    public List<Url> getAllUrl(){
         return service.getAllUrl();
    }
    @PostMapping("/createUrl")
    public String createUrl(@RequestBody Map<String, String> requestBody) {
        String inUrl = requestBody.get("inUrl");
        String temp= service.filterUrl(inUrl);
        return service.createUrl(temp, inUrl);
    }
}
