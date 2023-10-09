package com.example.shortlinkgenerator.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGeneratorLink {
    private final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public StringBuilder randomGeneratorLink(String longLink, int length) {
        StringBuilder randomLink = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomLink.append(getRandomChar());
        }
        return randomLink;
    }

    private char getRandomChar() {
        Random random = new Random();
        int getRandomIndex = random.nextInt(62);
        return BASE62.charAt(getRandomIndex);
    }
}
