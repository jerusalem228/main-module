package com.sagroup.userservice.controller;

import com.sagroup.userservice.entity.User;
import com.sagroup.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/view")
    public List<User> viewAll(){

        return userService.viewAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable long id,@RequestBody User user){
        userService.update(id, user);
    }
    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id){
        userService.removeById(id);
    }
}
