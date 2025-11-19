package br.com.worksphere.usuario.dto;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String perfil
) {
}
