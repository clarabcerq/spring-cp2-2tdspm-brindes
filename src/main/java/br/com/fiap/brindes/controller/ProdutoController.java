package br.com.fiap.brindes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.brindes.dto.request.ProdutoRequest;
import br.com.fiap.brindes.entity.Categoria;
import br.com.fiap.brindes.entity.Produto;
import br.com.fiap.brindes.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public Produto criarProduto(@RequestBody ProdutoRequest produtoRequest) {
		
		Categoria categoria = new Categoria();
		categoria.setId(produtoRequest.categoria().id());
		
		Produto produto = new Produto();
		produto.setNome(produtoRequest.nome());
		produto.setPreco(produtoRequest.preco());
		produto.setCategoria(categoria);
		return produtoService.save(produto);
	}
	
	@GetMapping("/{id}")
	public Produto buscarProduto(@PathVariable Long id) {
		return produtoService.findById(id);
	}
}
