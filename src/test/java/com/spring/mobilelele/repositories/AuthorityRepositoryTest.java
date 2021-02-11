package com.spring.mobilelele.repositories;

import com.spring.mobilelele.models.entities.AuthorityEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorityRepositoryTest {

    private final AuthorityRepository authorityRepository;
    public final static String existingAuthorityName;
    public final static AuthorityEntity authorityEntity;
    public final static String fakeAuthorityName;

    static {
        existingAuthorityName = "ADMIN";
        authorityEntity = new AuthorityEntity();
        authorityEntity
                .setAuthority(existingAuthorityName)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        fakeAuthorityName = "Fake";
    }

    @Autowired
    AuthorityRepositoryTest(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @BeforeEach
    void setUp() {
        this.authorityRepository.saveAndFlush(authorityEntity);
    }

    @Test
    public void findByAuthorityShouldReturnCorrectAuthority() {
        Optional<AuthorityEntity> optionalAuthorityEntity =
                this.authorityRepository.findByAuthority(existingAuthorityName);
        Assert.assertEquals(1, authorityRepository.count());
        Assert.assertTrue(optionalAuthorityEntity.isPresent());
        Assert.assertEquals(existingAuthorityName, optionalAuthorityEntity.get().getAuthority());
    }

    @Test
    public void findByAuthorityShouldReturnEmptyOptional() {
        Optional<AuthorityEntity> optionalAuthorityEntity =
                this.authorityRepository.findByAuthority(fakeAuthorityName);
        Assert.assertEquals(1, authorityRepository.count());
        Assert.assertTrue(optionalAuthorityEntity.isEmpty());
    }
}
