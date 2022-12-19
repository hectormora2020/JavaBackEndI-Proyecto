package com.bedu.radiologia.mapper;

import com.bedu.radiologia.dto.PacienteDTO;
import com.bedu.radiologia.entity.Paciente;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IPacienteMapper {
    PacienteDTO toDTO(Paciente data);
    Paciente toEntity(PacienteDTO data);
}
