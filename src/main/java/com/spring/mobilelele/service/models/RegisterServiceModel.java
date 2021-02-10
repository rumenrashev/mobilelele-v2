package com.spring.mobilelele.service.models;

import java.util.Objects;

public class RegisterServiceModel {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public RegisterServiceModel() {
    }

    public String getEmail() {
        return email;
    }

    public RegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterServiceModel that = (RegisterServiceModel) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthenticationRegisterModel{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append("********").append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
