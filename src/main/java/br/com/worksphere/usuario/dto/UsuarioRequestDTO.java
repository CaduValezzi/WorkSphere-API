package br.com.worksphere.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public final class UsuarioRequestDTO {
    @NotBlank
    private final String nome;
    @Email
    @NotBlank
    private final String email;
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    @NotBlank
    private final String senha;
    @NotBlank
    private final String perfil;

    public UsuarioRequestDTO(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres") String senha,
            @NotBlank String perfil
    ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    @NotBlank
    public String nome() {
        return nome;
    }

    @Email
    @NotBlank
    public String email() {
        return email;
    }

    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    @NotBlank
    public String senha() {
        return senha;
    }

    @NotBlank
    public String perfil() {
        return perfil;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        UsuarioRequestDTO that = (UsuarioRequestDTO) obj;
        return Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.senha, that.senha) &&
                Objects.equals(this.perfil, that.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha, perfil);
    }

    @Override
    public String toString() {
        return "UsuarioRequestDTO[" +
                "nome=" + nome + ", " +
                "email=" + email + ", " +
                "senha=" + senha + ", " +
                "perfil=" + perfil + ']';
    }

}
