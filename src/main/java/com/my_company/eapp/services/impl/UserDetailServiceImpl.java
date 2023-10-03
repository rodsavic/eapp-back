package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.UsuarioMapper;
import com.my_company.eapp.jwt.conf.UserDetailsImpl;
import com.my_company.eapp.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Ingresa a loadUserByUsername - UserDetailsServiceImpl");
        Usuario usuario = this.usuarioMapper.selectUsuarioByNombreUsuario(username);
        System.out.println("Usuario" + usuario.getNombreUsuario());
        if(usuario == null){
            System.out.println("Ingresa al if usuario == null");
            throw new UsernameNotFoundException("UserDetailsServiceImpl - Usuario no encontrado");
        }
        System.out.println("Procede a retornar el usuario");
        return new UserDetailsImpl(usuario);
    }
}
