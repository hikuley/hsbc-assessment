package com.hsbc.microservice.controllers;

import com.hsbc.microservice.model.User;
import com.hsbc.microservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/user")
public class UserRestController {

    final UserService userService;

    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/read")
    Iterable<User> read() {
        return userService.findAll();
    }

    @GetMapping("/read{id}")
    User readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @PutMapping("/update")
    User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/wrong")
    User somethingIsWrong() {
        throw new ValidationException("Something is wrong");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException e) {
        return e.getMessage();
    }

}
