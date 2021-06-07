package com.lessons.home.springsecurity.services;

import com.lessons.home.springsecurity.repositories.GeneralRepository;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {

    private final GeneralRepository generalRepository;

    public GeneralService(GeneralRepository generalRepository) {
        this.generalRepository = generalRepository;
    }

    public String getInfoByName(String name) {
        return generalRepository.findByName(name).getInfo();
    }
}
