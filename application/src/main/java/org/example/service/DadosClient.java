package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dados-client", url = "localhost:8082")
public interface DadosClient {

    @PostMapping("dados/evaluate")
    void evaluate(@RequestBody String request);

}

