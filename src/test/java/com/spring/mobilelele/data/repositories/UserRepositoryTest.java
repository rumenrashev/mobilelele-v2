package com.spring.mobilelele.data.repositories;

import com.spring.mobilelele.data.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.HashSet;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    private final UserRepository userRepository;
    private static final String existingUsername;
    private static final UserEntity existingUserEntity;
    private static final String fakeUsername;

    static {
        existingUsername = "username";
        existingUserEntity = new UserEntity();
        existingUserEntity
                .setUsername(existingUsername)
                .setActive(true)
                .setFirstName("first")
                .setLastName("last")
                .setPassword("password")
                .setAuthorities(new HashSet<>())
                .setImageUrl("userImageUrl")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        fakeUsername = "fakeUsername";
    }



    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
