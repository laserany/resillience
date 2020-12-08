package com.example.resilience;

import org.springframework.stereotype.Service;

@FunctionalInterface
public interface ResillienceService {
    String callHysterical();
}
