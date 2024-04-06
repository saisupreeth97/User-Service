package com.supreeth.usermicroservice.resource;

import com.supreeth.usermicroservice.dto.UserDto;
import com.supreeth.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUsers()
    {
        return new ResponseEntity(userService.getUsers(),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity(userService.addUser(userDto),HttpStatus.CREATED);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity getUserByEmail(@PathVariable String emailId)
    {
        return new ResponseEntity(userService.getUserByEmail(emailId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.updateUser(userDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity deleteUser(@PathVariable String emailId)
    {
        return new ResponseEntity<>(userService.deleteUser(emailId),HttpStatus.OK);
    }
}
