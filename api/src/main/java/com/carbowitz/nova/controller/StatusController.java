package com.carbowitz.nova.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carbowitz.nova.utilities.ResponseMessages;

@RestController
public class StatusController {
    @GetMapping("/")
    public String getStatus() {
        return ResponseMessages.statusIsOk;
    }
}
