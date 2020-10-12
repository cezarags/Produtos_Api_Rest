package com.produto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produto.api.model.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Long> { // extende os metodos prontos de jpa repository
	
	Produto findById(long id);   // metodo personalizado, procura um produto atraves do Id
	

	
	

}
