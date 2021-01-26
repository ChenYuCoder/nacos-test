package com.vichen;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenyu
 * @date 2021/1/25
 */
@SpringBootApplication

public class NacosDiscoveryApplication implements CommandLineRunner {

  @NacosInjected
  private NamingService namingService;

  public static void main(String[] args) {
    SpringApplication.run(NacosDiscoveryApplication.class, args);
  }

  /**
   * 实例注册
   *
   * @param args
   * @throws Exception
   */
  @Override
  public void run(String... args) throws Exception {
    namingService.registerInstance("boot-discovery", "192.168.19.168", 8081);
  }
}
