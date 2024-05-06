package br.com.fiap.brindes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.brindes.dto.request.CategoriaRequest;
import br.com.fiap.brindes.entity.Categoria;
import br.com.fiap.brindes.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@PostMapping
	public Categoria criarCategoria(@RequestBody CategoriaRequest categoriaRequest) {
		Categoria categoria = new Categoria();
		categoria.setNome(categoriaRequest.nome());
		return categoriaService.save(categoria);
	}
	
	@GetMapping("/{id}")
	public Categoria buscarCategoria(@PathVariable Long id) {
		return categoriaService.findById(id);
	}
	
}
