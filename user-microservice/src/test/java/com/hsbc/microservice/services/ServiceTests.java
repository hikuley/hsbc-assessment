package com.hsbc.microservice.services;

import com.hsbc.microservice.repository.UserRepository;
import com.hsbc.microservice.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {
    @InjectMocks
    UserService service;

    @Mock
    UserRepository dao;

    @Test
    public void testFindAllUsers() {
        List<User> list = new ArrayList<>();
        User empOne = new User("John", "John");
        User empTwo = new User("Alex", "kolenchiski");
        User empThree = new User("Steve", "Waugh");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<User> empList = service.findAll();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveUser() {
        User user = new User("Lokesh", "Gupta");

        service.save(user);

        verify(dao, times(1)).save(user);
    }
}
