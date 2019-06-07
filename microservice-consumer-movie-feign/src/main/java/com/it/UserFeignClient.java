package com.it;

import com.config.FeignConfig;
import com.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="microservice-provider-user",decode404 = true,configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id);
}
