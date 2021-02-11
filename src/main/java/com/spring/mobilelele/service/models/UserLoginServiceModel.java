package com.spring.mobilelele.service.models;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class UserLoginServiceModel implements UserDetails {


    private String username;
    private String password;
    private String firstName;
    private Set<RoleServiceModel> authorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public UserLoginServiceModel() {
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserLoginServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public UserLoginServiceModel setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public UserLoginServiceModel setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }


    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public UserLoginServiceModel setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public UserLoginServiceModel setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public UserLoginServiceModel setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }
}
