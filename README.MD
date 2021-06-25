# Getting Started

### grpc 框架使用说明
#### 启动服务端
```java
@SpringBootApplication
@EnableGrpcServer
public class RpcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcServerApplication.class, args);
    }
}

@RemoteService
public class OrderServiceImpl implements IOrderService {

    @Override
    public String queryOrderList() {
        return "query method";
    }

    @Override
    public String orderById(String id) {
        return "order method";
    }
}
```
* 通过 @EnableGrpcServer 注解启动rpc服务
* 通过 @RemoteService 注解将实现接口 IOrderService 的 OrderServiceImpl 注册为服务
* 在配置文件中通过 gp.server_port=11313 定义服务启动的端口号

#### 启动客户端
```java
@SpringBootApplication
@EnableGrpcClient
public class RpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }
}

@RestController
public class TestController {
    @Reference
    private IOrderService orderService;
}
```

* 通过 @EnableGrpcClient 注解启动rpc客户端
* 通过 @Reference 注解将服务代理注入 orderService，调用 orderService 的方法时，
  会直接通过代理调用 rpc 服务端提供的实现。
* 在配置文件中通过 gp.host=localhost gp.port=11313 定义代理服务的地址和端口号


说明：因该rpc框架的服务端和客户端都是依赖 spring 的 bean 注入实现的，故客户端 rpc
代理需在 bean 内完成，服务端 rpc 服务的实现必定会被加载为 bean。




