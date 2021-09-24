package com.hsbc.microservice.services;

import com.hsbc.microservice.repository.UserRepository;
import com.hsbc.microservice.model.User;
import com.hsbc.microservice.handlers.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        if (user.getId() == null) {
            user = userRepository.save(user);
            return user;
        } else {
            Optional<User> employeeOptional = userRepository.findById(user.getId());

            if (employeeOptional.isPresent()) {
                User newEntity = employeeOptional.get();

                newEntity.setFirstName(user.getFirstName());
                newEntity.setLastName(user.getLastName());

                newEntity = userRepository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("No user record exist for given id");
            }
        }
    }

    public List<User> findAll() {
        final List<User> result = (List<User>) userRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public void deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public User readById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new RecordNotFoundException("No user record exist for given id"));
    }

    void deleteAll() {
        userRepository.deleteAll();
    }
}
