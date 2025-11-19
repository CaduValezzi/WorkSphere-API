package br.com.worksphere.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres") String senha,
        @NotBlank String perfil
) {
}
