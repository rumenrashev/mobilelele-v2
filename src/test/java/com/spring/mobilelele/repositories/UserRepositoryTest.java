package com.spring.mobilelele.repositories;

import com.spring.mobilelele.models.entities.UserEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    private final UserRepository userRepository;
    private static final String existingEmail;
    private static final UserEntity existingUserEntity;
    private static final String fakeEmail;

    static {
        existingEmail = "email@email.com";
        existingUserEntity = new UserEntity();
        existingUserEntity
                .setEmail(existingEmail)
                .setActive(true)
                .setFirstName("first")
                .setLastName("last")
                .setPassword("password")
                .setAuthorities(new HashSet<>())
                .setImageUrl("userImageUrl")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        fakeEmail = "fakeUsername";
    }



    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp(){
        this.userRepository.saveAndFlush(existingUserEntity);
    }

    @Test
    public void findByEmailShouldReturnCorrectEntity(){
        Optional<UserEntity> optionalUserEntity =
                this.userRepository.findByEmail(existingEmail);
        Assert.assertTrue(optionalUserEntity.isPresent());
        Assert.assertEquals(existingEmail,optionalUserEntity.get().getEmail());
    }

    @Test
    public void findByEmailShouldReturnEmptyOptional(){
        Optional<UserEntity> optionalUserEntity =
                this.userRepository.findByEmail(fakeEmail);
        Assert.assertTrue(optionalUserEntity.isEmpty());
    }

}
