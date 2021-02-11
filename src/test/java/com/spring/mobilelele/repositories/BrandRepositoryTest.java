package com.spring.mobilelele.repositories;

import com.spring.mobilelele.models.entities.BrandEntity;
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
class BrandRepositoryTest {

    private final BrandRepository brandRepository;
    public static final String existingBrandName;
    public static final BrandEntity existingBrandEntity;
    public static final String notExistingBrandName;

    static {
        existingBrandName = "Mercedes-Benz";
        existingBrandEntity = new BrandEntity();
        existingBrandEntity
                .setName(existingBrandName)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        notExistingBrandName = "Fake";
    }


    @Autowired
    BrandRepositoryTest(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @BeforeEach
    void setUp() {
        this.brandRepository.saveAndFlush(existingBrandEntity);
    }

    @Test
    public void findByNameShouldReturnCorrectBrandEntity() {
        Optional<BrandEntity> optionalBrand = this.brandRepository
                .findByName(existingBrandName);
        Assert.assertTrue(optionalBrand.isPresent());
        Assert.assertEquals(existingBrandName, optionalBrand.get().getName());
    }

    @Test
    public void findByNameShouldReturnEmptyOptional() {
        Optional<BrandEntity> resultOptional = this.brandRepository.findByName(notExistingBrandName);
        Assert.assertTrue(resultOptional.isEmpty());
    }
}
