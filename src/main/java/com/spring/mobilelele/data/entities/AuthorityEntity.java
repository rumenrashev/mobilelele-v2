package com.spring.mobilelele.data.entities;

import com.spring.mobilelele.data.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthorityEntity extends BaseEntity {

    private String authority;

    public AuthorityEntity() {
    }

    public String getAuthority() {
        return authority;
    }

    public AuthorityEntity setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
       return super.hashCode();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthorityEntity{");
        sb.append(super.toString());
        sb.append("authority='").append(authority).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
