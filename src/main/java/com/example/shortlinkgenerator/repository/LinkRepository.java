package com.example.shortlinkgenerator.repository;

import com.example.shortlinkgenerator.model.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
    LinkEntity findByShortLink(String shortUrl);

    LinkEntity findByLongLink(String longUrl);

    @Query("SELECT l FROM links l WHERE (EXTRACT(DAY FROM(CURRENT_DATE - l.registeredAt))) >14")
    List<LinkEntity> getListByData();
}
