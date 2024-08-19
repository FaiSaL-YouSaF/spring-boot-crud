package com.faisalyousaf777.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the Notes Application!";
    }
}
