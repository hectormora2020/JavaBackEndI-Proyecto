package com.bedu.radiologia.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {

    private long id;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
}
