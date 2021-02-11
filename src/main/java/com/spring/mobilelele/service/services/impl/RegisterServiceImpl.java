package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.constant.enums.AuthorityEnum;
import com.spring.mobilelele.models.entities.AuthorityEntity;
import com.spring.mobilelele.models.entities.UserEntity;
import com.spring.mobilelele.repositories.AuthorityRepository;
import com.spring.mobilelele.repositories.UserRepository;
import com.spring.mobilelele.exceptions.AuthorityNotFoundException;
import com.spring.mobilelele.service.models.RegisterServiceModel;
import com.spring.mobilelele.service.services.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;


@Service
public class RegisterServiceImpl implements RegisterService {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(AuthorityRepository authorityRepository,
                               UserRepository userRepository, ModelMapper modelMapper,
                               BCryptPasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterServiceModel registerServiceModel) {
        registerServiceModel
                .setPassword(this.passwordEncoder.encode(registerServiceModel.getPassword()));
        UserEntity userEntity = this.modelMapper.map(registerServiceModel, UserEntity.class);
        userEntity
                .setActive(true)
                .setAuthorities(new HashSet<>())
                .setImageUrl("imageUrl")
                .setCreated(Instant.now())
                .setModified(Instant.now());
        if (userRepository.count() == 0){
            AuthorityEntity adminRole =
                    this.authorityRepository.findByAuthority(AuthorityEnum.ADMIN.name())
                    .orElseThrow(AuthorityNotFoundException::new);
            userEntity.getAuthorities().add(adminRole);
        }
        AuthorityEntity userRole = this.authorityRepository.findByAuthority(AuthorityEnum.USER.name())
                .orElseThrow(AuthorityNotFoundException::new);
        userEntity.getAuthorities().add(userRole);

        this.userRepository.saveAndFlush(userEntity);
    }

}
