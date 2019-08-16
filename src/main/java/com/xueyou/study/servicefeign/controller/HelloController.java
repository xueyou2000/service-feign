package com.xueyou.study.servicefeign.controller;

import com.xueyou.study.serviceApi.models.dto.User;
import com.xueyou.study.servicefeign.feign.ClientFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建 by xueyo on 2019/7/24
 */
@Api(value = "feign消费", tags = "feign")
@RestController
public class HelloController {

    private final ClientFeign clientFeign;

    public HelloController(ClientFeign clientFeign) {
        this.clientFeign = clientFeign;
    }

    @ApiOperation(value = "feign-consumer", notes = "测试feign消费", httpMethod = "GET", produces = "application/json")
    @GetMapping("/feign-consumer")
    public String consumer() {
        User user = new User();
        user.setName("LiuDeHua");
        user.setAge(15);

        StringBuilder sb = new StringBuilder();
        sb.append(clientFeign.hello("XueYou 学友")).append("\n");
        sb.append(clientFeign.hello("Zilong", 99)).append("\n");
        sb.append(clientFeign.hello(user)).append("\n");

        return sb.toString();
    }

    @ApiOperation(value = "test-load-balance", notes = "测试负载均衡", httpMethod = "GET", produces = "application/json")
    @GetMapping("/test-load-balance")
    public String testLoadBalance() {
        return clientFeign.loadBalanced();
    }

}
