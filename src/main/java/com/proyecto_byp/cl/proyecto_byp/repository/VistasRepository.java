package com.proyecto_byp.cl.proyecto_byp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto_byp.cl.proyecto_byp.model.Vistas;

@Repository
public interface VistasRepository extends JpaRepository<Vistas, Long> {
    @Query("SELECT v FROM Vistas v WHERE v.animal.usuario.id = :usuarioId AND v.esMatch = 'Y'")
    List<Vistas> findMatchesByUsuarioId(@Param("usuarioId") Long usuarioId);
}
