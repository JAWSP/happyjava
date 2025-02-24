package com.example.rest.service;

import com.example.rest.repository.ExUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class ExUserService {
    private final ExUserRepository exUserRepository;
//
//    public showExUser() {
//
//    }
}
