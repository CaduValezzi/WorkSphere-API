package br.com.worksphere.usuario.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    @jakarta.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String valor;

    protected Email() {

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
