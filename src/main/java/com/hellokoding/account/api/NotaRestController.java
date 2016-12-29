package com.hellokoding.account.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hellokoding.account.model.Nota;
import com.hellokoding.account.service.NotaService;

@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/notas")
public class NotaRestController {
	@Autowired
	NotaService notaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Nota>> getAll() {
		List<Nota> notas = notaService.getAll();
		ResponseEntity<List<Nota>> respuesta = null;
		if (notas.isEmpty()) {
			respuesta = new ResponseEntity<List<Nota>>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<List<Nota>>(notas, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nota> getById(@PathVariable("id") int id) {
		Nota nota = notaService.getById(id);
		ResponseEntity<Nota> respuesta = null;
		if (nota.equals(null)) {
			respuesta = new ResponseEntity<Nota>(HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<Nota>(nota, HttpStatus.OK);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Nota nota) {
		ResponseEntity<Void> respuesta = null;
		notaService.save(nota);
		if (nota.getId() < 0) {
			respuesta = new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return respuesta;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ResponseEntity<Void> respuesta = null;
		if (notaService.getById(id) != null) {
			notaService.delete(id);
			respuesta = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}

		return respuesta;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Nota> update(@PathVariable("id") long id, @RequestBody Nota nota) {
		ResponseEntity<Nota> respuesta = null;
		if (notaService.getById(id) != null || nota.getId() > 0) {
			nota.setId(id);
			notaService.update(nota);
			respuesta = new ResponseEntity<Nota>(nota, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Nota>(HttpStatus.NOT_FOUND);
		}

		return respuesta;
	}
}
