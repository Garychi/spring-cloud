package com.it;

import com.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-18T03:11:30.030Z[GMT]")
@Api(value = "user", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "Find user by ID", nickname = "getUserById", notes = "Returns a single user", response = User.class, authorizations = {
            @Authorization(value = "api_key")    }, tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = User.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found") })
    @RequestMapping(value = "/user/{id}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@ApiParam(value = "ID of pet to return",required=true) @PathVariable("id") Long id);

}
