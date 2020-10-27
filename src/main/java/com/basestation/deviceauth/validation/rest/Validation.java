package com.basestation.deviceauth.validation.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("auth")

public class Validation {
    @PostMapping("/device_login")
    public JsonNode validationDevice(@RequestBody JsonNode jsonNode){
        System.out.println("Received JSON:"+jsonNode.toString());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<JsonNode> request = new HttpEntity<>(jsonNode);

        String url = "https://safe-basin-01006.herokuapp.com/api/device_valid";
        ResponseEntity<JsonNode> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        request,
                        JsonNode.class);
        JsonNode responsePayload = response.getBody();
        return responsePayload;


    }
}
