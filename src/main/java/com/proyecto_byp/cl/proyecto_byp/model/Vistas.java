package com.proyecto_byp.cl.proyecto_byp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vista")
    private Integer id;

    @Column(length = 1, nullable = false)
    private String esMatch;

    @Column(nullable = true)
    private Integer like1;

    @Column(nullable = true)
    private Integer like2;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_ANIMAL_ID", nullable = false)
    private Animal animal;
}
