package br.com.worksphere.usuario.service;

import br.com.worksphere.core.exception.BusinessException;
import br.com.worksphere.usuario.dto.AlterarSenhaDTO;
import br.com.worksphere.usuario.dto.UsuarioRequestDTO;
import br.com.worksphere.usuario.dto.UsuarioResponseDTO;
import br.com.worksphere.usuario.entity.Usuario;
import br.com.worksphere.usuario.enums.PerfilUsuario;
import br.com.worksphere.usuario.repository.UsuarioRepository;
import br.com.worksphere.usuario.vo.Email;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmailValor(dto.email())) {
            throw new BusinessException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(new Email(dto.email()));
        usuario.setPerfil(PerfilUsuario.valueOf(dto.perfil()));
        usuario.setSenhaHash(passwordEncoder.encode(dto.senha()));
        usuario.setAtivo(true);

        Usuario salvo = usuarioRepository.save(usuario);
        return toResponse(salvo);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return toResponse(usuario);
    }

    public void excluir(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public void alterarSenha(Long idUsuario, AlterarSenhaDTO dto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.senhaAtual(), usuario.getSenhaHash())) {
            throw new BusinessException("Senha atual incorreta");
        }

        usuario.setSenhaHash(passwordEncoder.encode(dto.novaSenha()));
        usuarioRepository.save(usuario);
    }

    private UsuarioResponseDTO toResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail().getValor(),
                usuario.getPerfil().name()
        );
    }
}
