package com.formacionntt.microservicios.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionntt.microservicios.app.examenes.models.entity.Examen;
import com.formacionntt.microservicios.app.examenes.models.entity.Pregunta;
import com.formacionntt.microservicios.app.examenes.services.ExamenService;
import com.formacionntt.microservicios.commons.controllers.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDB = o.get();
		examenDB.setName(examen.getName());
		
		List<Pregunta> eliminadas = new ArrayList<>();//se guardaran las preguntas que ya no van a existir
		
		examenDB.getPreguntas().forEach( pdb -> {
			if (!examen.getPreguntas().contains(pdb)) {//si la pregunta no existe en las preguntas que nos estan enviando
				eliminadas.add(pdb);//se agrega a eliminadas			
			}
			
		});
		
		eliminadas.forEach(p -> {
			examenDB.removePregunta(p);
		});
		
		examenDB.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
	}
}
