package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.GeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneralRepository extends JpaRepository<GeneralInfo, Long> {

    GeneralInfo findFirstByName(String name);
}
