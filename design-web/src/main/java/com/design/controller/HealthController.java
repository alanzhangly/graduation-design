package com.design.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ke Zhang on 2018/3/21.
 */
@RestController
@RequestMapping("/test")
public class HealthController {

    @RequestMapping("/health")
    public String toString() {
        return "health";
    }
}
