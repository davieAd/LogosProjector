package com.example.logosproject;

import com.example.logosproject.models.User;
import com.example.logosproject.repository.UserRepository;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("anya@gmail.com");
        user.setPassword("anyaLazurkevuch");
        user.setFirstName("Anya");
        user.setLastName("Lazurkevuch");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail().equals(user.getEmail()));
    }

    @Test
    public void testFindUserByEmail(){
        String email = "lopero@gmail.com";

        User user = userRepository.findByEmail(email);

        assertThat(user.getEmail()).isEqualTo(email);
    }
}
