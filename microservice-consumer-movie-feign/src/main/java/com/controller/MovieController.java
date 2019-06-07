package com.controller;

import com.it.UserFeignClient;
import com.model.User;
import feign.Feign;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.FeignUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    Logger log = Logger.getLogger(MovieController.class);

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return this.userFeignClient.findById(id);
    }

//    public User findById(@PathVariable Long id){
//        String url = "http://localhost:8000/"+id;
//        User user =null ;
//        try{
//            log.info("in");
//            user = this.restTemplate.getForObject(url,User.class);
//        }
//        catch(Exception e){
//            log.error("FAIL",e);
//        }
//        return user;
//    }
}
