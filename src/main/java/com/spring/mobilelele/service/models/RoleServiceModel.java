package com.spring.mobilelele.service.models;

import org.springframework.security.core.GrantedAuthority;

public class RoleServiceModel implements GrantedAuthority {

    private String authority;

    public RoleServiceModel() {
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public RoleServiceModel setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
