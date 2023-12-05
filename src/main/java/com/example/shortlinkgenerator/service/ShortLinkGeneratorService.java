package com.example.shortlinkgenerator.service;

import com.example.shortlinkgenerator.model.LinkEntity;
import com.example.shortlinkgenerator.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ShortLinkGeneratorService {
    private String shortLink = "";
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    RandomGeneratorLink randomGeneratorLink;
    private int lengthUrl = 6;

    public String getShortLink(String longUrl) {
        if (checkLongUrl(longUrl)) {
            log.info("this URL has already been added");
            return linkRepository.findByLongLink(longUrl).getShortLink();
        }
        boolean empty = true;
        while (empty) {
            shortLink = String.valueOf(randomGeneratorLink.randomGeneratorLink(longUrl, lengthUrl));
            LinkEntity byShortLink = getLongUrl(shortLink);
            empty = byShortLink != null;
        }
        shortLink = String.valueOf(randomGeneratorLink.randomGeneratorLink(longUrl, lengthUrl));
        if (saveUrl(longUrl, shortLink)) {
            return shortLink;
        }
        return longUrl;
    }

    private boolean saveUrl(String longUrl, String shortUrl) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLongLink(longUrl);
        linkEntity.setShortLink(shortUrl);
        linkEntity.setRegisteredAt(LocalDateTime.now());

        try {
            linkRepository.save(linkEntity);
            log.info("save: {},", linkEntity);
            return true;
        } catch (Exception e) {
            log.error("error at saving url: " + e.getMessage());
        }
        return false;
    }

    public LinkEntity getLongUrl(String shortUrl) {
        return linkRepository.findByShortLink(shortUrl);
    }

    public boolean checkLongUrl(String longUrl) {
        LinkEntity byLongLink = linkRepository.findByLongLink(longUrl);
        return byLongLink != null;
    }
}
