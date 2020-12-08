package com.example.resilience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ResillienceServiceImpl implements ResillienceService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String callHysterical() {

        URI uri = URI.create("http://localhost:8081");
        return restTemplate.getForObject(uri, String.class);
    }
}
