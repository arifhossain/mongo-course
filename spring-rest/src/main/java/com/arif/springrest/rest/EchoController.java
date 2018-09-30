package com.arif.springrest.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping("/")
    public String echo() {
        return "Hello spring boot";
    }
}
