package com.vichen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyu
 * @date 2021/1/26
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

  @Value("${useLocalCache:false}")
  private boolean useLocalCache;

  @RequestMapping("/get")
  public boolean get() {
    return useLocalCache;
  }
}
