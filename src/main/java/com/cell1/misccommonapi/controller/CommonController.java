package com.cell1.misccommonapi.controller;

import com.cell1.misccommonapi.model.HealthResponse;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @GetMapping("/health")
    public HealthResponse healthCheck() {
        return new HealthResponse("misc-common-api", "UP", Instant.now().toEpochMilli());
    }

    @GetMapping("/ping")
    public Map<String, String> ping(@RequestParam(defaultValue = "pong") String message) {
        Map<String, String> response = new HashMap<>();
        response.put("request", message);
        response.put("response", "pong");
        return response;
    }

    @GetMapping("/info")
    public Map<String, String> serviceInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("name", "misc-common-api");
        info.put("version", "0.0.1-SNAPSHOT");
        info.put("description", "Common reusable APIs for all cells");
        return info;
    }

    @PostMapping("/echo")
    public Map<String, String> echoMessage(@RequestBody Map<String, String> request) {
        String message = request.getOrDefault("message", "No message received");
        Map<String, String> response = new HashMap<>();
        response.put("originalMessage", message);
        response.put("echoMessage", "Echo: " + message);
        response.put("timestamp", String.valueOf(Instant.now().toEpochMilli()));
        return response;
    }
}
