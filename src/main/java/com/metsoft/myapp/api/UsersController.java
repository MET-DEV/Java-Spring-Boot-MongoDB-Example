package com.metsoft.myapp.api;

import com.metsoft.myapp.dto.RegisterUserDto;
import com.metsoft.myapp.model.User;
import com.metsoft.myapp.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;
    private  final ModelMapper modelMapper;

    @Autowired
    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@Valid @RequestBody RegisterUserDto userDto){
        return new ResponseEntity<>(userService.saveUser(modelMapper.map(userDto,User.class)), HttpStatus.OK);
    }
}
