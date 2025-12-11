package com.kh.Calendar.controller;

import com.kh.Calendar.entity.User;
import com.kh.Calendar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> getUsers() {
        List<User> users = userService.getUsers();
        if(users != null) {
            return new ResponseEntity<>("Users", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Users", HttpStatus.NOT_FOUND);
        }
    }
}
