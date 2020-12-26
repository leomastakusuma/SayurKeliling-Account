package com.example.ESayur.controller;
import com.example.ESayur.model.User;
import com.example.ESayur.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation("View List User")
    @GetMapping("/")
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @ApiOperation("Create User Pembeli")
    @PostMapping("/pembeli")
    public User createUser(@Valid @RequestBody User user) {
        User userdata = userRepository.findByPhone(user.getPhoneNumber());
        if(userdata !=null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Data Exist");
        }else{
            user.setLevel("pembeli");
            return userRepository.save(user);
        }
    }

    @ApiOperation("Create Tukang Sayur")
    @PostMapping("/grobak")
    public User createUserGrobak(@Valid @RequestBody User user) {
        User userdata = userRepository.findByPhone(user.getPhoneNumber());
        if(userdata !=null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Data Exist");
        }else{
            user.setLevel("grobak");
            return userRepository.save(user);
        }
    }

    @ApiOperation("Login By Phone")
    @GetMapping("/{phoneNo}")
    public User getUserByPhone(@PathVariable(value = "phoneNo") String phoneNo) {
        User user = userRepository.findByPhone(phoneNo);
        if(user ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return user;
        }
    }
    @ApiOperation("Update User By ID")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long idUser, @Valid @RequestBody User user) {
        User userdata = userRepository.findById(idUser).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userdata.setFullName((user.getFullName()));
        userdata.setLevel(user.getLevel());
        return userRepository.save(userdata);
    }

    @ApiOperation("List Grobak Sayur")
    @GetMapping("/grobak")
    public List<User> listGrobak() {
        List user = userRepository.listGrobakSayur();
        if(user ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return user;
        }
    }

}

