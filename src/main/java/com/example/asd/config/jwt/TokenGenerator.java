package com.example.asd.config.jwt;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {
    public String generate(String... strings);

}
