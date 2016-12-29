package com.hellokoding.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.account.model.Nota;
import com.hellokoding.account.repository.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService {
	@Autowired
	private NotaRepository notaRepository;

	@Override
	public void save(Nota nota) {
		notaRepository.save(nota);

	}

	@Override
	public List<Nota> getAll() {

		return notaRepository.findAll();
	}

	@Override
	public void update(Nota nota) {
		Nota notaEncontrada = notaRepository.findOne(nota.getId());

		notaRepository.save(notaEncontrada);

	}

	@Override
	public void delete(long id) {
		notaRepository.delete(id);

	}

	@Override
	public Nota getById(long id) {
		Nota nota = notaRepository.findOne(id);
		return nota;
	}

}
