package com.spring.mobilelele.repositories;

import com.spring.mobilelele.constant.enums.CategoryEnum;
import com.spring.mobilelele.models.entities.ModelEntity;
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
class ModelRepositoryTest {

    private final ModelRepository modelRepository;
    private static final String existingModelName;
    private static final ModelEntity existingModelEntity;
    private static final String fakeModelName = "fakeModel";


    static {
        existingModelName = "E-class";
        existingModelEntity = new ModelEntity();
        existingModelEntity
                .setName(existingModelName)
                .setBrand(null)
                .setCategory(CategoryEnum.Car)
                .setStartYear(1990)
                .setEndYear(2000)
                .setImageUrl("modelImageUrl")
                .setCreated(Instant.now())
                .setModified(Instant.now());

    }

    @Autowired
    public ModelRepositoryTest(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @BeforeEach
    void setUp() {
        this.modelRepository.saveAndFlush(existingModelEntity);
    }

    @Test
    public void findByNameShouldReturnCorrectEntity() {
        Optional<ModelEntity> optionalModelEntity =
                this.modelRepository.findByName(existingModelName);
        Assert.assertTrue(optionalModelEntity.isPresent());
        Assert.assertEquals(1, this.modelRepository.count());
        Assert.assertEquals(existingModelName, optionalModelEntity.get().getName());

    }

    @Test
    public void findByNameShouldReturnEmptyOptional() {
        Optional<ModelEntity> optionalModelEntity =
                this.modelRepository.findByName(fakeModelName);
        Assert.assertTrue(optionalModelEntity.isEmpty());
        Assert.assertEquals(1, this.modelRepository.count());

    }


}
