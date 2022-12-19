package com.bedu.radiologia.mapper;

import com.bedu.radiologia.dto.EstudioDTO;
import com.bedu.radiologia.entity.Estudio;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IEstudioMapper {
    EstudioDTO toDTO(Estudio data);
    Estudio toEntity(EstudioDTO data);
}
