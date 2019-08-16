package com.xueyou.study.servicefeign.controller;

import com.xueyou.study.serviceApi.models.dto.User;
import com.xueyou.study.servicefeign.feign.ClientFeign;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建 by xueyo on 2019/7/24
 */
@RestController
public class HelloController {

    private final ClientFeign clientFeign;

    public HelloController(ClientFeign clientFeign) {
        this.clientFeign = clientFeign;
    }

    @GetMapping("/feign-consumer")
    public String consumer() {
        User user = new User();
        user.setName("LiuDeHua");
        user.setAge(15);

        StringBuilder sb = new StringBuilder();
        sb.append(clientFeign.hello("XueYou")).append("\n");
        sb.append(clientFeign.hello("Zilong", 99)).append("\n");
        sb.append(clientFeign.hello(user)).append("\n");

        return sb.toString();
    }

}
