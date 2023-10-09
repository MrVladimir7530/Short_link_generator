package com.example.shortlinkgenerator.service;

import com.example.shortlinkgenerator.model.LinkEntity;
import com.example.shortlinkgenerator.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@EnableScheduling
public class RemovingLink {

    @Autowired
    LinkRepository linkRepository;
    @Scheduled(cron = "0 0 0 * * *")
    private void checkAndDeleteOldLink() {
        List<LinkEntity> listByData = linkRepository.getListByData();
        for (LinkEntity linkEntity : listByData) {
            linkRepository.delete(linkEntity);

        }
        log.info("Checked for old dates");
    }
}
