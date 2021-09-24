package com.hsbc.microservice.repository;


import com.hsbc.microservice.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateReadDelete() {
        User user = new User("Lokesh", "Gupta");

        userRepository.save(user);

        Iterable<User> employees = userRepository.findAll();
        Assertions.assertThat(employees).extracting(User::getFirstName).containsOnly("Lokesh");

        userRepository.deleteAll();
        Assertions.assertThat(userRepository.findAll()).isEmpty();
    }
}
