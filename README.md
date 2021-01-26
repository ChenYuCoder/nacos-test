## Nacos 安装

* 下载安装包
  > https://github.com/alibaba/nacos/releases
* 解压

```shell
unzip nacos-server-$version.zip 
或者 
tar -xvf nacos-server-$version.tar.gz
```

* 单列模式启动

```shell
cd nacos/bin
sh startup.sh -m standalone
```

## 模块描述

### nacos-boot-config

> SpringBoot+Nacos全局配置

* 启动类增加注解，指定dataId和是否监听变化

```
@NacosPropertySource(dataId = "example", autoRefreshed = true)
```

* 属性上增加注解，指定属性key:默认值，是否监听变化

```
@NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
```

* 使用命令更新配置

```shell
curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true"
```

### nacos-boot-discovery

> SpringBoot+Nacos服务注册

* 编写本地接口项目，访问API注册服务

```shell
curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080'
```

* 使用namingService，在服务启动时注册

```
  @NacosInjected
  private NamingService namingService;
  
  @Override
  public void run(String... args) throws Exception {
    namingService.registerInstance("boot-discovery", "192.168.19.168", 8081);
  }
```

### nacos-cloud-config

> SpringCloud+Nacos全局配置

* 类上增加注解，表示监听配置变化

```
  @RefreshScope
```

* 属性上增加注解，属性key:默认值

```
  @Value("${useLocalCache:false}")
  private boolean useLocalCache;
```

### nacos-cloud-consumer

> SpringCloud+Nacos服务消费

* 启动类上增加注解，表示注册节点

```
@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudConsumerApplication 

```

* 启动类通过@LoadBalanced注解注入restTemplate bean

```
@LoadBalanced
@Bean
public RestTemplate restTemplate() {
  return new RestTemplate();
}
```

* 使用restTemplate访问服务，getForObject(地址,返回值类型)

```
  private final RestTemplate restTemplate;
  restTemplate.getForObject("http://cloud-provider/provider/test", String.class)
```


### nacos-cloud-provider

> SpringCloud+Nacos服务注册

* 启动类上增加注解，表示注册节点

```
@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudProviderApplication 

```

#### 备注

* SpringCloud配置无法被读取

> 将application.properties 改为bootstrap.properties文件

* SpringCloud+Nacos默认dataId为spring.application.name配置项
