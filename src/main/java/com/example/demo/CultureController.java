package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CultureController {

    @PostMapping("/getPrediction")
    public JSONObject register(@RequestBody Culture culture) {
        System.out.println(culture.toString());

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "corn");
        requestParams.put("startDate", "25-mar");
        requestParams.put("endDate", "8-apr");

        return requestParams;
    }
}
