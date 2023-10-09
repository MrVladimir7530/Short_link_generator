package com.example.shortlinkgenerator.repository;

import com.example.shortlinkgenerator.model.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
    LinkEntity findByShortLink(String shortUrl);
    LinkEntity findByLongLink(String longUrl);
}
