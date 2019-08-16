package com.xueyou.study.servicefeign.feign.fallback;

import com.xueyou.study.serviceApi.models.dto.User;
import com.xueyou.study.serviceApi.service.UserService;
import com.xueyou.study.servicefeign.feign.ClientFeign;
import org.springframework.stereotype.Component;

/**
 * 创建 by xueyo on 2019/8/14
 */
@Component
public class ClientFeignFallback implements ClientFeign {

    @Override
    public String hello(String name) {
        return "========erro 服务降级=======";
    }

    @Override
    public User hello(String name, Integer age) {
        User user = new User();
        user.setName("未知");
        user.setAge(0);
        return user;
    }

    @Override
    public String hello(User user) {
        return "========erro 服务降级=======";
    }
}
