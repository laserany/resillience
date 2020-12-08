package com.example.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
public class ResilienceController {

    @Autowired
    CircuitBreaker circuitBreaker;

    @Autowired
    ResillienceService resillienceService;

    @GetMapping("")
    public String hello() {
        System.out.println("I'm cool");
        CircuitBreaker.decorateCheckedSupplier(circuitBreaker, resillienceService::callHysterical);
        try {
            Supplier<String> stringSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, resillienceService::callHysterical);
            return stringSupplier.get();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
