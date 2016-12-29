package com.hellokoding.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.account.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
