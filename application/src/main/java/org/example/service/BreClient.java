package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bre-client", url = "localhost:8081")
public interface BreClient {
    @PostMapping("bre/evaluate")
    void evaluate(@RequestBody String request);

}
