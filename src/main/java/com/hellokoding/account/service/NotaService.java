package com.hellokoding.account.service;

import java.util.List;

import com.hellokoding.account.model.Nota;

public interface NotaService {
	void save(Nota nota);

	List<Nota> getAll();

	void update(Nota nota);

	void delete(long id);

	Nota getById(long id);
}
