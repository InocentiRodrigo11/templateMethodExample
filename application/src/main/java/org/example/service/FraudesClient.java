package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "fraudes-client", url = "localhost:8083")
public interface FraudesClient {

    @PostMapping("fraudes/evaluate")
    void evaluate(@RequestBody String request);

}

