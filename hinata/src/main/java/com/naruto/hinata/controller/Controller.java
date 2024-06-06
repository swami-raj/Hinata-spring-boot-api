package com.naruto.hinata.controller;

import com.naruto.hinata.dto.SignupDto;
import com.naruto.hinata.dto.UserDto;
import com.naruto.hinata.services.UserService;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    UserService userservice;
    @PostMapping("/logins")
    public String login(@RequestBody UserDto userdto){

        return userservice.login(userdto);
    }


//    @PostMapping("/signup")
//    public String signup(@RequestBody SignupDto signupdto){
//        return userservice.signup(signupdto);
//    }

    @PostMapping("/signup")
    public String signup(@RequestBody List<SignupDto> signupdtos) {
        return userservice.signup(signupdtos);
    }

    @GetMapping("/getsign")
    public List<SignupDto> getall(){
        return userservice.getall();
    }
    @GetMapping("/getbyid/{id}")
    public SignupDto getbyid(@PathVariable  Long id){
        return userservice.getUser(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUs(@PathVariable Long id){
        userservice.delete(id);
    }

    @PutMapping("/update/{id}")
    public SignupDto update(@RequestBody SignupDto signupdto, @PathVariable Long id){
        return userservice.updateDetail(signupdto, id);
    }

}
