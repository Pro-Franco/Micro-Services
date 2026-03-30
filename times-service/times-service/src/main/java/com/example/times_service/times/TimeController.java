package com.example.times_service.times;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    @Autowired
    private TimeRepository repository;

    @GetMapping
    public List<Time> getAllTimes() {
        return repository.findAll();
    }

    @PostMapping
    public Time createTime(@RequestBody Time time) {
        return repository.save(time);
    }
}
