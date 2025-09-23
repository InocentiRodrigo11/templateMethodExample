package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ocr-client", url = "localhost:8080")
public interface OcrClient {

    @PostMapping("ocr/evaluate")
    void evaluate(@RequestBody String request);

}


