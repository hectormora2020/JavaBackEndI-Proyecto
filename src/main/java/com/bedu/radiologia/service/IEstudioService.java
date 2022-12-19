package com.bedu.radiologia.service;
import com.bedu.radiologia.dto.EstudioDTO;

import java.util.List;
import java.util.Optional;

public interface IEstudioService {

    List<EstudioDTO> findAll();

    Optional<EstudioDTO> findById(long id);

    EstudioDTO save(EstudioDTO data);

    void update(long id, EstudioDTO data) throws Exception;

    void delete(long id) throws Exception;
} // ./EstudioService()
