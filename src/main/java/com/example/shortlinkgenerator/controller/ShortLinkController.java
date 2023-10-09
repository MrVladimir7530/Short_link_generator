package com.example.shortlinkgenerator.controller;

import com.example.shortlinkgenerator.model.LinkEntity;
import com.example.shortlinkgenerator.service.ShortLinkGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortLinkController {
    @Autowired
    ShortLinkGeneratorService shortLinkGeneratorService;

    @GetMapping("/{link}")
    public RedirectView followShortLink(@PathVariable String link) {
        LinkEntity longUrl = shortLinkGeneratorService.getLongUrl(link);
        return new RedirectView(longUrl.getLongLink());
    }

}
