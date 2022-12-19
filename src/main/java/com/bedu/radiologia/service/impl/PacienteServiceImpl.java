package com.bedu.radiologia.service.impl;

import com.bedu.radiologia.dto.PacienteDTO;
import com.bedu.radiologia.entity.Paciente;
import com.bedu.radiologia.mapper.IPacienteMapper;
import com.bedu.radiologia.repository.IPacienteRepository;
import com.bedu.radiologia.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    private IPacienteRepository repository;
    private IPacienteMapper mapper;

    @Autowired
    public PacienteServiceImpl( IPacienteRepository repository, IPacienteMapper mapper ){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = repository.findAll();
        return pacientes.stream().map( mapper::toDTO).toList();
    }

    @Override
    public Optional<PacienteDTO> findById(long id) {
        Optional<Paciente> paciente = repository.findById(id);
        Optional<PacienteDTO> pacienteDTO = Optional.of(  mapper.toDTO( paciente.get() ) );
        return  pacienteDTO;
    }

    @Override
    public PacienteDTO save(PacienteDTO data) {
        repository.save( mapper.toEntity(data) );
        return data;
    }

    @Override
    public void update(long id, PacienteDTO data) throws  Exception {
        Optional<Paciente> paciente = repository.findById(id);
        if( paciente.isEmpty() ) {
            throw new Exception("No existe paciente");
        }

        paciente.get().setNombre( data.getNombre() );
        paciente.get().setFechaNacimiento( data.getFechaNacimiento() );
        paciente.get().setCorreo( data.getCorreo() );
        paciente.get().setTelefono( data.getTelefono() );
        repository.save( paciente.get() );
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
