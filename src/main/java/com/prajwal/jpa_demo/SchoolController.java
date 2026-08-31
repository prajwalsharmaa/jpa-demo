package com.prajwal.jpa_demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    private final SchoolRepository;
    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){

    }
}
