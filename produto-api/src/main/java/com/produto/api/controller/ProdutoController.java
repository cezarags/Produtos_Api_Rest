package com.produto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.model.Produto;
import com.produto.api.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value = "API RET Produtos")
@CrossOrigin(origins = "*")             // liberar todos dominios para acesso a api

public class ProdutoController {
	
	
	@Autowired
	ProdutoRepository prepository;     // injeção de depedencias
	
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){    
		return prepository.findAll();	
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "método para fazer busca pelo Id no bd")
	public Produto listarUnicoProduto(@PathVariable(value = "id") long id){ 
		return prepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "método para salvar um produto no banco")
	public Produto salvaProduto(@RequestBody Produto produto) {    
		return prepository.save(produto);		
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "método para deletar um produto no banco")
	public void deletaProduto(@RequestBody Produto produto) {
		prepository.delete(produto);
		
}

	@PutMapping("/produto")
	@ApiOperation(value = "método para atualizar um registro de um produto ")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return prepository.save(produto);
		
		
	}
}