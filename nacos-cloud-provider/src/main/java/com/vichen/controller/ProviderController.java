package com.vichen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyu
 * @date 2021/1/26
 */
@RestController
@RequestMapping("/provider/")
public class ProviderController {

  @GetMapping(value = "test")
  public String test() {
    return "hello world!";
  }

}
