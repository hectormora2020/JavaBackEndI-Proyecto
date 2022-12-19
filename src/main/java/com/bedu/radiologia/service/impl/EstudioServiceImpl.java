package com.bedu.radiologia.service.impl;

import com.bedu.radiologia.dto.EstudioDTO;
import com.bedu.radiologia.entity.Estudio;
import com.bedu.radiologia.mapper.IEstudioMapper;
import com.bedu.radiologia.repository.IEstudioRepository;
import com.bedu.radiologia.service.IEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioServiceImpl implements IEstudioService {

    private IEstudioRepository repository;
    private IEstudioMapper mapper;

    @Autowired
    public EstudioServiceImpl( IEstudioRepository repository, IEstudioMapper mapper ){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<EstudioDTO> findAll() {
        List<Estudio> estudios = repository.findAll();
        return estudios.stream().map( mapper::toDTO).toList();
    }

    @Override
    public Optional<EstudioDTO> findById(long id) {
        Optional<Estudio> est = repository.findById(id);
        Optional<EstudioDTO> estDTO = Optional.of(  mapper.toDTO( est.get() ) );
        return  estDTO;
    }

    @Override
    public EstudioDTO save(EstudioDTO data) {
        repository.save( mapper.toEntity(data) );
        return data;
    }

    @Override
    public void update(long id, EstudioDTO data) throws Exception {
        Optional<Estudio> estudio = repository.findById(id);
        if( estudio.isEmpty() ) {
            throw new Exception("No existe estudio");
        }

        estudio.get().setNombre( data.getNombre() );
        estudio.get().setPrecio( data.getPrecio() );
        repository.save( estudio.get() );
    }

    @Override
    public void delete(long id) throws Exception {

        Optional<Estudio> estudio = repository.findById(id);

        if( estudio.isEmpty() ) {
            throw new Exception("No existe estudio");
        }

        repository.deleteById(id);
    }
}
