package com.spring.mobilelele.data.entities;

import com.spring.mobilelele.data.entities.base.BaseEntityWithPicture;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntityWithPicture {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private Boolean isActive;

    @ManyToMany
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )

    private Set<AuthorityEntity> authorities;

    public UserEntity() {
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserEntity setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Set<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public UserEntity setAuthorities(Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
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
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append(super.toString());
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", authorities=").append(authorities);
        sb.append('}');
        return sb.toString();
    }
}
