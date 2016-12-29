package com.hellokoding.account.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellokoding.account.model.Nota;
import com.hellokoding.account.service.NotaService;

@Controller
public class NotaController {
	@Autowired
	private NotaService notaService;

	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	public String registration(Model model) {

		List<Nota> notas = notaService.getAll();
		return "registration";
	}
}
