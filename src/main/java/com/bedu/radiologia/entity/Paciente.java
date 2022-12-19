package com.bedu.radiologia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="fecha_nacimiento", nullable=false)
    private String fechaNacimiento;

    @Column(name="telefono")
    private String telefono;

    @Column(name="correo")
    private String correo;

} // Class Paciente
