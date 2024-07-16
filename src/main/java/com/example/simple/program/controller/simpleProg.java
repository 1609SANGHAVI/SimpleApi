package com.example.simple.program.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class simpleProg {
    private Map<Long, String> dataStore = new HashMap<>();

    @PostMapping("/store")
    public String store(@RequestBody Map<String, String> request) {
        Long id = Long.parseLong(request.get("id"));
        String value = request.get("value");
        dataStore.put(id, value);
        return "Stored!";
    }

    @GetMapping("/retrieve/{id}")
    public String retrieve(@PathVariable Long id) {
        return dataStore.getOrDefault(id, "Not found");
    }
}
