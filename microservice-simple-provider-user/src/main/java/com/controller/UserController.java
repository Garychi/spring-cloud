package com.controller;

import com.dao.UserRepository;
import com.model.User;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
//    Logger log = Logger.getLogger(UserController.class);
    Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        User user = null;
        try{
            log.info("server in");

            List<User> list = this.userRepository.findAll();
            user = this.userRepository.findById(id).orElse(null);
        }
        catch (Exception e){
            log.error("FAIL",e);
        }

        return user;
    }
}
