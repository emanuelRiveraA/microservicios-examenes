package com.formacionntt.microservicios.app.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionntt.microservicios.app.examenes.models.entity.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long>{

}
