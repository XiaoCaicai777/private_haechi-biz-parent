package com.it.biz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "DICTIONARY-SERVICE")
@RequestMapping("/diccionario")
public interface DicServiceFeign {

    @GetMapping("/getDicName")
    String getDicName(@RequestParam("type") String type, @RequestParam("code") String code);
}
