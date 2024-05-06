package br.com.fiap.brindes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.brindes.dto.request.LojaRequest;
import br.com.fiap.brindes.entity.Loja;
import br.com.fiap.brindes.service.LojaService;

@RestController
@RequestMapping("lojas")
public class LojaController {

	private LojaService lojaService;
	
	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}
	
	@PostMapping
	public Loja criarLoja(@RequestBody LojaRequest lojaRequest) {
		Loja loja = new Loja();
		loja.setNome(lojaRequest.nome());
		return lojaService.save(loja);
	}
	
	@GetMapping("/{id}")
	public Loja buscarLoja(@PathVariable Long id) {
		return lojaService.findById(id);
	}
	
}
