package com.bedu.radiologia.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="precio", nullable=false)
    private float precio;
} // ./ class Estudio
