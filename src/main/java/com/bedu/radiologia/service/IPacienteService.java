package com.bedu.radiologia.service;
import com.bedu.radiologia.dto.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<PacienteDTO> findAll();

    Optional<PacienteDTO> findById(long id);

    PacienteDTO save(PacienteDTO data);

    void update(long id, PacienteDTO data) throws  Exception;

    void delete(long id);
} // ./PacienteService()
