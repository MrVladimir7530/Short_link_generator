package com.example.shortlinkgenerator.repository;

import com.example.shortlinkgenerator.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
