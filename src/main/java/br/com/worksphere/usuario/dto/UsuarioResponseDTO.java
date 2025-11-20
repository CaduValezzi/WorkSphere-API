package br.com.worksphere.usuario.dto;

import java.util.Objects;

public final class UsuarioResponseDTO {
    private final Long id;
    private final String nome;
    private final String email;
    private final String perfil;

    public UsuarioResponseDTO(
            Long id,
            String nome,
            String email,
            String perfil
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    public Long id() {
        return id;
    }

    public String nome() {
        return nome;
    }

    public String email() {
        return email;
    }

    public String perfil() {
        return perfil;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        UsuarioResponseDTO that = (UsuarioResponseDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.perfil, that.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, perfil);
    }

    @Override
    public String toString() {
        return "UsuarioResponseDTO[" +
                "id=" + id + ", " +
                "nome=" + nome + ", " +
                "email=" + email + ", " +
                "perfil=" + perfil + ']';
    }

}
