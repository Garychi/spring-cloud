package com.controller;

import com.model.User;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    Logger log = Logger.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        String url = "http://localhost:8000/"+id;
        User user =null ;
        try{
            log.info("in");
            user = this.restTemplate.getForObject(url,User.class);
        }
        catch(Exception e){
            log.error("FAIL",e);
        }
        return user;
    }
}
