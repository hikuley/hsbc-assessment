package com.hsbc.microservice.controllers;

import com.hsbc.microservice.model.User;
import com.hsbc.microservice.services.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRestController.class)
public class StandaloneControllerTests {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        User user = new User("Lokesh", "Gupta");
        List<User> users = Arrays.asList(user);

        Mockito.when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/user/read"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    }

}
