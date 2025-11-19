package br.com.worksphere.auth.controller;

import br.com.worksphere.auth.dto.LoginRequestDTO;
import br.com.worksphere.auth.dto.TokenResponseDTO;
import br.com.worksphere.auth.service.AuthService;
import br.com.worksphere.core.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDTO>> login(@RequestBody @Valid LoginRequestDTO dto) {
        TokenResponseDTO token = authService.autenticar(dto);
        return ResponseEntity.ok(ApiResponse.ok("Login realizado com sucesso", token));
    }
}
