package br.com.worksphere.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public final class AlterarSenhaDTO {
    @NotBlank
    private final String senhaAtual;
    @Size(min = 6)
    @NotBlank
    private final String novaSenha;

    public AlterarSenhaDTO(
            @NotBlank String senhaAtual,
            @NotBlank @Size(min = 6) String novaSenha
    ) {
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
    }

    @NotBlank
    public String senhaAtual() {
        return senhaAtual;
    }

    @Size(min = 6)
    @NotBlank
    public String novaSenha() {
        return novaSenha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        AlterarSenhaDTO that = (AlterarSenhaDTO) obj;
        return Objects.equals(this.senhaAtual, that.senhaAtual) &&
                Objects.equals(this.novaSenha, that.novaSenha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senhaAtual, novaSenha);
    }

    @Override
    public String toString() {
        return "AlterarSenhaDTO[" +
                "senhaAtual=" + senhaAtual + ", " +
                "novaSenha=" + novaSenha + ']';
    }

}
