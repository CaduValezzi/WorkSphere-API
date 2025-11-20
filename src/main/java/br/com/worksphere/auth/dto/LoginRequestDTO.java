package br.com.worksphere.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public final class LoginRequestDTO {
    @Email
    @NotBlank
    private final String email;
    @NotBlank
    private final String senha;

    public LoginRequestDTO(
            @NotBlank @Email String email,
            @NotBlank String senha
    ) {
        this.email = email;
        this.senha = senha;
    }

    @Email
    @NotBlank
    public String email() {
        return email;
    }

    @NotBlank
    public String senha() {
        return senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        LoginRequestDTO that = (LoginRequestDTO) obj;
        return Objects.equals(this.email, that.email) &&
                Objects.equals(this.senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha);
    }

    @Override
    public String toString() {
        return "LoginRequestDTO[" +
                "email=" + email + ", " +
                "senha=" + senha + ']';
    }

}
