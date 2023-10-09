package com.example.shortlinkgenerator.controller;

import com.example.shortlinkgenerator.model.LinkEntity;
import com.example.shortlinkgenerator.service.ShortLinkGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;
import java.util.Map;

@RestController
public class FollowShortLinkController {
    @Autowired
    ShortLinkGeneratorService shortLinkGeneratorService;

    @GetMapping()
    public RedirectView followShortLink(@RequestParam String link) {
        LinkEntity longUrl = shortLinkGeneratorService.getLongUrl(link);
        return new RedirectView(longUrl.getLongLink());
    }

//    @PostMapping(value = "/redirect")
//    public ResponseEntity<Void> redirect(@RequestParam Map<String, String> input) {
//        return ResponseEntity.status(HttpStatus.FOUND).location()
//    }
}
