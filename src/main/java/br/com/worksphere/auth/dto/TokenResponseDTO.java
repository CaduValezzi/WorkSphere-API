package br.com.worksphere.auth.dto;

import java.util.Objects;

public final class TokenResponseDTO {
    private final String accessToken;
    private final String tokenType;

    public TokenResponseDTO(
            String accessToken,
            String tokenType
    ) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public String accessToken() {
        return accessToken;
    }

    public String tokenType() {
        return tokenType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        TokenResponseDTO that = (TokenResponseDTO) obj;
        return Objects.equals(this.accessToken, that.accessToken) &&
                Objects.equals(this.tokenType, that.tokenType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType);
    }

    @Override
    public String toString() {
        return "TokenResponseDTO[" +
                "accessToken=" + accessToken + ", " +
                "tokenType=" + tokenType + ']';
    }

}
