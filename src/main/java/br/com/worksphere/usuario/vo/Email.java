package br.com.worksphere.usuario.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public class Email {

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String valor;

    protected Email() {
        // construtor protegido para JPA
    }

    public Email(String valor) {
        if (valor == null || !valor.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
