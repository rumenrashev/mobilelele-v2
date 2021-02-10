package com.spring.mobilelele.web.models.bindings;

import com.spring.mobilelele.service.validations.anotations.FieldMatch;
import com.spring.mobilelele.service.validations.anotations.UniqueEmail;
import com.spring.mobilelele.service.validations.anotations.ValidName;
import com.spring.mobilelele.service.validations.anotations.ValidPassword;

import javax.validation.constraints.Email;
import java.util.Objects;

@FieldMatch.List({
        @FieldMatch(first = "email",second = "confirmEmail"),
        @FieldMatch(first = "password",second = "confirmPassword")})
public class RegisterBindingModel {

    @Email
    @UniqueEmail
    private String email;

    private String confirmEmail;

    @ValidPassword
    private String password;

    private String confirmPassword;

    @ValidName()
    private String firstName;

    @ValidName()
    private String lastName;

    public RegisterBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public RegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public RegisterBindingModel setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterBindingModel that = (RegisterBindingModel) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthenticationRegisterBindingModel{");
        sb.append("email='").append(email).append('\'');
        sb.append("confirmEmail='").append(confirmEmail).append('\'');
        sb.append(", password='").append("*******").append('\'');
        sb.append(", confirmPassword='").append("*******").append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
