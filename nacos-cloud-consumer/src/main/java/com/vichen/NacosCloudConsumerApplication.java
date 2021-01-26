package com.vichen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenyu
 * @date 2021/1/25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NacosCloudConsumerApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
