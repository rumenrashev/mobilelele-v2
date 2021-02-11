package com.spring.mobilelele.service.services.impl;

import com.spring.mobilelele.models.entities.UserEntity;
import com.spring.mobilelele.repositories.UserRepository;
import com.spring.mobilelele.service.models.UserLoginServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public LoginService(UserRepository userRepository,
                        ModelMapper modelMapper) {

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user with this email"));
        UserLoginServiceModel userLoginServiceModel =
                this.modelMapper.map(userEntity, UserLoginServiceModel.class);
        userLoginServiceModel
                .setUsername(username)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true)
                .setEnabled(true);
        return userLoginServiceModel;
    }
}
