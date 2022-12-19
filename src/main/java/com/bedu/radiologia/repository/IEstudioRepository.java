package com.bedu.radiologia.repository;

import com.bedu.radiologia.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepository extends JpaRepository<Estudio, Long> {
}
