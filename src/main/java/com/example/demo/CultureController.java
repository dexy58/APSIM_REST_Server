package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CultureController {

    @PostMapping("/getPrediction")
    public String register(@RequestBody Culture culture) {
        System.out.println(culture.toString());

        return culture.toString();
    }
}
