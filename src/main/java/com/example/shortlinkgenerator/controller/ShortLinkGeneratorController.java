package com.example.shortlinkgenerator.controller;

import com.example.shortlinkgenerator.model.ReqWithLongUrl;
import com.example.shortlinkgenerator.service.ShortLinkGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("url")
@RestController
public class ShortLinkGeneratorController {

    @Autowired
    private ShortLinkGeneratorService shortLinkGeneratorService;

    @PostMapping("shortUrl")
    public ResponseEntity<String> getShortLink(@RequestBody ReqWithLongUrl reqWithLongUrl) {
        String shortLink = shortLinkGeneratorService.getShortLink(reqWithLongUrl.getLongUrl());
        return ResponseEntity.ok("http://localhost:8080?link=" + shortLink);
    }
}
