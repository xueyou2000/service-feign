package com.xueyou.study.servicefeign.feign;

import com.xueyou.study.serviceApi.service.UserService;
import com.xueyou.study.servicefeign.feign.fallback.ClientFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 创建 by xueyo on 2019/7/24
 */
@FeignClient(value = "client", fallback = ClientFeignFallback.class)
public interface ClientFeign extends UserService {

}
