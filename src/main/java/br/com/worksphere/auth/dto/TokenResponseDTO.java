package br.com.worksphere.auth.dto;

public record TokenResponseDTO(
        String accessToken,
        String tokenType
) {
}
