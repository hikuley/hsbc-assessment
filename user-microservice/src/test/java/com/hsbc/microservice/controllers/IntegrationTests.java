package com.hsbc.microservice.controllers;

import com.hsbc.microservice.model.User;
import com.hsbc.microservice.handlers.RecordNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    UserRestController userRestController;

    @Test
    public void testCreateReadDelete() {
        User user = new User("Lokesh", "Gupta");

        User userResult = userRestController.create(user);

        User savedUser = userRestController.readById(userResult.getId());
        assertThat(savedUser).hasFieldOrPropertyWithValue("firstName", "Lokesh");

        userRestController.delete(userResult.getId());
        assertThatExceptionOfType(RecordNotFoundException.class).isThrownBy(() -> userRestController.readById(userResult.getId()));
    }

    @Test
    public void errorHandlingValidationExceptionThrown() {
        assertThatExceptionOfType(ValidationException.class).isThrownBy(() -> userRestController.somethingIsWrong());
    }
}
