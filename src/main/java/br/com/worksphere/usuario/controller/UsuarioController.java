package br.com.worksphere.usuario.controller;

import br.com.worksphere.core.dto.ApiResponse;
import br.com.worksphere.usuario.dto.AlterarSenhaDTO;
import br.com.worksphere.usuario.dto.UsuarioRequestDTO;
import br.com.worksphere.usuario.dto.UsuarioResponseDTO;
import br.com.worksphere.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> criar(@RequestBody @Valid UsuarioRequestDTO dto) {
        UsuarioResponseDTO criado = usuarioService.criarUsuario(dto);
        return ResponseEntity.ok(ApiResponse.ok("Usuário criado com sucesso", criado));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listar() {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(ApiResponse.ok("Lista de usuários", usuarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorId(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(ApiResponse.ok("Usuário encontrado", usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok(ApiResponse.ok("Usuário excluído com sucesso", null));
    }

    @PutMapping("/me/senha")
    public ResponseEntity<ApiResponse<Void>> alterarSenha(
            Authentication authentication,
            @RequestBody @Valid AlterarSenhaDTO dto
    ) {
        // aqui simplificamos: em um projeto real pegaríamos o ID pelo principal
        // para fins acadêmicos pode ser ajustado depois
        return ResponseEntity.badRequest()
                .body(ApiResponse.error("Endpoint de alteração de senha precisa ser ajustado para obter o ID do usuário logado", null));
    }
}
