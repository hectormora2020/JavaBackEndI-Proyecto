package com.bedu.radiologia.controller;

import com.bedu.radiologia.dto.EstudioDTO;
import com.bedu.radiologia.service.IEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudiosController {

    private IEstudioService servicio;

    @Autowired
    public EstudiosController( IEstudioService servicio ){
        this.servicio = servicio;
    }

    @GetMapping("/estudios")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EstudioDTO> getAll() {
        return this.servicio.findAll();
    }

    @PostMapping("/estudios")
    @ResponseStatus(HttpStatus.CREATED)
    public EstudioDTO save(@RequestBody EstudioDTO data) {
        return servicio.save(data);
    }

    @PutMapping( "/estudios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody EstudioDTO data) throws Exception {
        servicio.update(id, data);
    }

    @DeleteMapping("/estudios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        servicio.delete(id);
    }
}
