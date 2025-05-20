package com.proyecto_byp.cl.proyecto_byp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto_byp.cl.proyecto_byp.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//**@Query("SELECT a FROM Usuario a WHERE a.esMatch = 'Y'")
//**List<Object[]> findMatchByUsuarioId(Long usuarioId);

@Query("SELECT COUNT(a) FROM Animal a WHERE a.usuario.id = :usuarioId")
Long contarMascotasPorUsuario(@Param("usuarioId") Long usuarioId);

}
