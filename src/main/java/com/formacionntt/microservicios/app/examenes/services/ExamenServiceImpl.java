package com.formacionntt.microservicios.app.examenes.services;

import org.springframework.stereotype.Service;

import com.formacionntt.microservicios.app.examenes.models.entity.Examen;
import com.formacionntt.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formacionntt.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {



}
