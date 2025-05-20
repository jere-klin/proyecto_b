package com.proyecto_byp.cl.proyecto_byp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_byp.cl.proyecto_byp.model.Usuario;
import com.proyecto_byp.cl.proyecto_byp.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById (Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Long cantidadMascotas(Long usuarioId) {
    return usuarioRepository.contarMascotasPorUsuario(usuarioId);
}
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario actualizar(Long id, Usuario usuario) {
    Usuario us = usuarioRepository.findById(id).orElse(null);
    if (us != null) {
        us.setNombre(usuario.getNombre());
        us.setCorreo(usuario.getCorreo());
        us.setClave(usuario.getClave());
        us.setTelefono(usuario.getTelefono());
        us.setDireccion(usuario.getDireccion());
        us.setTipo(usuario.getTipo());
        us.setFechaRegistro(usuario.getFechaRegistro());
        us.setComuna(usuario.getComuna());
        return usuarioRepository.save(us);
    } else {
        return null;
    }
}

    public Usuario patchUsuario (Long id, Usuario usuarioParcial){
        Optional<Usuario> usuarionOptional = usuarioRepository.findById(id);
        if(usuarionOptional.isPresent()){
            Usuario usuarioToUpdate = usuarionOptional.get();

            if(usuarioParcial.getNombre()!=null){
                usuarioToUpdate.setNombre(usuarioParcial.getNombre());
            }
            if(usuarioParcial.getCorreo()!=null){
                usuarioToUpdate.setCorreo(usuarioParcial.getCorreo());
            }
            if(usuarioParcial.getClave()!=null){
                usuarioToUpdate.setClave(usuarioParcial.getClave());
            }
            if(usuarioParcial.getTelefono()!=null){
                usuarioToUpdate.setTelefono(usuarioParcial.getTelefono());
            }
            if(usuarioParcial.getDireccion()!=null){
                usuarioToUpdate.setDireccion(usuarioParcial.getDireccion());
            }
            if(usuarioParcial.getTipo()!=null){
                usuarioToUpdate.setTipo(usuarioParcial.getTipo());
            }
            if(usuarioParcial.getFechaRegistro()!=null){
                usuarioToUpdate.setFechaRegistro(usuarioParcial.getFechaRegistro());
            }
            if(usuarioParcial.getComuna()!=null){
                usuarioToUpdate.setComuna(usuarioParcial.getComuna());
            }
            return usuarioRepository.save(usuarioToUpdate);
        }else{
            return null;
        }
    }
}