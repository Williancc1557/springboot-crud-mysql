package com.api.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {
    @RequestMapping("/")
    String getTest() {
        return "aaacccc";
    }
}
