package com.lessons.home.springsecurity.services.impl;

import com.lessons.home.springsecurity.repositories.GeneralRepository;
import com.lessons.home.springsecurity.services.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements GeneralService {

    private final GeneralRepository generalRepository;

    @Override
    public String getInfoByName(String name) {
        return generalRepository
            .findFirstByName(name)
            .getInfo();
    }
}
