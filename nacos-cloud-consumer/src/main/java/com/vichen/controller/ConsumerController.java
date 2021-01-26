package com.vichen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenyu
 * @date 2021/1/26
 */
@RestController
@RequestMapping("/consumer/")
public class ConsumerController {

  private final RestTemplate restTemplate;

  public ConsumerController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping(value = "/test")
  public String test() {
    return restTemplate.getForObject("http://cloud-provider/provider/test", String.class);
  }
}
