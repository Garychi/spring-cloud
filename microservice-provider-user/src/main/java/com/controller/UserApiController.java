package com.controller;

import com.dao.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.UserApi;
import com.model.User;
import io.swagger.annotations.ApiParam;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserApiController implements UserApi {
    Logger log = Logger.getLogger(UserApiController.class);
    private final HttpServletRequest request;

    private final ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<User> getUserById(@ApiParam(value = "ID of user to return",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        User user = null;
        try {
            log.info("server in");

            List<User> list = this.userRepository.findAll();
            user = this.userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("FAIL", e);
        }

        HttpStatus status = HttpStatus.OK;
        if(user == null)
            status = HttpStatus.NO_CONTENT;

        return new ResponseEntity(user,status);
    }
}
