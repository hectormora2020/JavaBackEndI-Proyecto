package com.bedu.radiologia.controller;

import com.bedu.radiologia.dto.PacienteDTO;
import com.bedu.radiologia.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    private IPacienteService servicio;

    @Autowired
    public PacienteController( IPacienteService servicio ){
        this.servicio = servicio;
    }


    @GetMapping("/pacientes")
    public List<PacienteDTO> getAll() {
        return this.servicio.findAll();
    }

    @PostMapping("/pacientes")
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDTO save(@RequestBody PacienteDTO data) {
        return servicio.save(data);
    }

    @PutMapping( "/pacientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody PacienteDTO data) throws  Exception {
        servicio.update(id, data);
    }

    @DeleteMapping("/pacientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        servicio.delete(id);
    }
}
