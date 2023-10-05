package com.my_company.eapp.controller;

import com.my_company.eapp.model.Usuario;
import com.my_company.eapp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/createUsuario")
    public int createUsuario(@RequestBody Usuario usuario) {
        System.out.println("Ingresa al metodo createUsuario");
        return usuarioService.createUsuario(usuario);
    }

    @PutMapping("/{id}")
    public int updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public int deleteUsuario(@PathVariable Integer id) {
        return usuarioService.deleteUsuario(id);
    }
    /*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        System.out.println("");
        // Implementa la lógica de autenticación aquí
        // Verifica si el usuario y la contraseña son válidos utilizando usuarioService

        if (usuarioService.validarCredenciales(usuario.getNombreUsuario(), usuario.getContrasenha())) {
            // Si las credenciales son válidas, genera un token JWT
            String token = generateJwtToken(usuario.getNombreUsuario());
            return ResponseEntity.ok(token);
        } else {
            // Si las credenciales no son válidas, devuelve un mensaje de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    
    private String generateJwtToken(String nombreUsuario) {
        // Define una clave secreta (debes protegerla adecuadamente en un entorno real)
        String secretKey = "TuClaveSecreta";

        // Genera el token JWT con una firma HMAC
        String token = Jwts.builder()
                .setSubject(nombreUsuario)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }
    */
}

