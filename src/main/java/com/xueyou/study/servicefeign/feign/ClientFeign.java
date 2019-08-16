package com.xueyou.study.servicefeign.feign;

import com.xueyou.study.serviceApi.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.xueyou.study.servicefeign.feign.fallback.ClientFeignFallback;

/**
 * 创建 by xueyo on 2019/7/24
 */
@FeignClient(value = "client", fallback = ClientFeignFallback.class)
public interface ClientFeign extends UserService {

}
