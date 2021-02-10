package com.spring.mobilelele.init;

import com.spring.mobilelele.constant.enums.AuthorityEnum;
import com.spring.mobilelele.constant.enums.CategoryEnum;
import com.spring.mobilelele.constant.enums.EngineEnum;
import com.spring.mobilelele.constant.enums.TransmissionEnum;
import com.spring.mobilelele.data.entities.*;
import com.spring.mobilelele.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;

    @Autowired
    public DataInitializer(AuthorityRepository authorityRepository, UserRepository userRepository,
                           BrandRepository brandRepository, ModelRepository modelRepository,
                           OfferRepository offerRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<AuthorityEntity> authorities = this.seedAllAuthoritiesFromAuthorityEnum();
        AuthorityEntity userAuthority = authorities.get(1);
        UserEntity admin = this.createUser(
                "admin@email.com",
                "Asen",
                "Asenov",
                "adminPassword",
                authorities,
                "adminImageUrl");
        UserEntity user = this.createUser(
                "user@email.com",
                "Boris",
                "Borisov",
                "userPassword",
                List.of(userAuthority),
                "userImageUrl");
        BrandEntity brand = this.createBrand("Mercedes-Benz");
        ModelEntity model = this.createModel(
                brand,
                "E-class",
                CategoryEnum.Car,
                1970,
                null,
                "modelPictureUrl"
        );

        OfferEntity offer = this.createOffer(
                "description",
                10000,
                new BigDecimal(20000),
                TransmissionEnum.AUTOMATIC,
                EngineEnum.DIESEL,
                2000,
                user,
                model,
                "offerImageUrl"
        );

    }

    private List<AuthorityEntity> seedAllAuthoritiesFromAuthorityEnum() {
        EnumSet.allOf(AuthorityEnum.class)
                .stream()
                .map(Enum::name)
                .forEach(
                        a -> {
                            if (this.authorityRepository.findByAuthority(a).isEmpty()) {
                                AuthorityEntity authorityEntity = new AuthorityEntity();
                                authorityEntity
                                        .setAuthority(a)
                                        .setCreated(Instant.now())
                                        .setModified(Instant.now());
                                this.authorityRepository.saveAndFlush(authorityEntity);
                            }
                        }
                );
        return this.authorityRepository.findAll();
    }

    private UserEntity createUser(String email, String firstName,
                                  String lastName, String password,
                                  List<AuthorityEntity> authorities,
                                  String imageUrl) {

        Optional<UserEntity> optionalUser = this.userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        UserEntity user = new UserEntity();
        user
                .setEmail(email)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAuthorities(new HashSet<>(authorities))
                .setActive(true)
                .setImageUrl(imageUrl)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.userRepository.saveAndFlush(user);
    }

    private BrandEntity createBrand(String name){
        Optional<BrandEntity> optionalBrand = this.brandRepository.findByName(name);
        if (optionalBrand.isPresent()){
            return optionalBrand.get();
        }
        BrandEntity brand = new BrandEntity();
        brand
                .setName(name)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.brandRepository.saveAndFlush(brand);
    }

    private ModelEntity createModel(BrandEntity brandEntity,String name, CategoryEnum category, Integer startYear,
                                    Integer endYear,String imageUrl){
        Optional<ModelEntity> optionalModel = this.modelRepository.findByName(name);
        if (optionalModel.isPresent()){
            return optionalModel.get();
        }
        ModelEntity model = new ModelEntity();
        model
                .setBrand(brandEntity)
                .setName(name)
                .setCategory(category)
                .setStartYear(startYear)
                .setEndYear(endYear)
                .setImageUrl(imageUrl)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.modelRepository.saveAndFlush(model);
    }

    private OfferEntity createOffer(String description,Integer mileage, BigDecimal price,
                                    TransmissionEnum transmission, EngineEnum engine,
                                    Integer year,
                                    UserEntity seller, ModelEntity model,
                                    String imageUrl){
        if (offerRepository.count() > 0){
            return null;
        }

        OfferEntity offer = new OfferEntity();
        offer
                .setDescription(description)
                .setEngine(engine)
                .setPrice(price)
                .setYear(year)
                .setMileage(mileage)
                .setTransmission(transmission)
                .setSeller(seller)
                .setModel(model)
                .setImageUrl(imageUrl)
                .setCreated(Instant.now())
                .setModified(Instant.now());
        return this.offerRepository.saveAndFlush(offer);
    }
}
