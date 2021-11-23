package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.content.GeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneralRepository extends JpaRepository<GeneralInfo, Long> {

    @Query(value = "SELECT c FROM GeneralInfo c WHERE c.name = ?1")
    public GeneralInfo findByName(String name);
}
