package com.iau.vrau;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RecursosEntidades {

	//PESSOA
	
	@Autowired
	private RepositorioPessoa repositorioPessoa;
	
	//exibir Pessoa
	@GetMapping("/pessoa")
	public List<Pessoa> exibirPessoa() {
		return repositorioPessoa.findAll();
	}
	
	//deletar Pessoa
	@DeleteMapping("/pessoa/{id}")
	public void deletarPessoa(@PathVariable long id) {
		repositorioPessoa.deleteById(id);
	}
	
	//adicionar Pessoa
	@PostMapping("/pessoa")
	public ResponseEntity<Object> adicionarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa savedPessoa = repositorioPessoa.save(pessoa);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPessoa.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	//editar Pessoa
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Object> atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable long id) {

		Optional<Pessoa> studentOptional = repositorioPessoa.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		pessoa.setId(id);
		
		repositorioPessoa.save(pessoa);

		return ResponseEntity.noContent().build();
	}
	
	//LIVRO
	
	@Autowired
	private RepositorioLivro repositorioLivro;
	
	//exibir Livro
	@GetMapping("/livro")
	public List<Livro> exibirLivros() {
		return repositorioLivro.findAll();
	}
	
	//deletar Livro
	@DeleteMapping("/livro/{id}")
	public void deletarLivros(@PathVariable long id) {
		repositorioLivro.deleteById(id);
	}
	
	//adicionar livro
	@PostMapping("/livro")
	public ResponseEntity<Object> adicionarLivros(@RequestBody Livro livro) {
		Livro savedLivro = repositorioLivro.save(livro);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLivro.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	//editar livro
	@PutMapping("/livro/{id}")
	public ResponseEntity<Object> atualizarLivros(@RequestBody Livro livro, @PathVariable long id) {

		Optional<Livro> livroOptional = repositorioLivro.findById(id);

		if (!livroOptional.isPresent())
			return ResponseEntity.notFound().build();

		livro.setId(id);
		
		repositorioLivro.save(livro);

		return ResponseEntity.noContent().build();
	}
	
	
	//FILMEEEEEEEEEEEEEE
	
	@Autowired
	private RepositorioFilme repositorioFilme;

	//exibir Filme
	@GetMapping("/filme")
	public List<Filme> exibirFilme() {
		return repositorioFilme.findAll();
	}
	
	//deletar Filme
	@DeleteMapping("/filme/{id}")
	public void deletarFilme(@PathVariable long id) {
			repositorioFilme.deleteById(id);
		}

	//adicionar Filme
	@PostMapping("/filme")
	public ResponseEntity<Object> adicionarFilme(@RequestBody Filme filme) {
			Filme savedFilme = repositorioFilme.save(filme);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedFilme.getId()).toUri();

			return ResponseEntity.created(location).build();

		}

	//editar Filme
	@PutMapping("/filme/{id}")
	public ResponseEntity<Object> atualizarFilme(@RequestBody Filme filme, @PathVariable long id) {

		Optional<Filme> filmeOptional = repositorioFilme.findById(id);

		if (!filmeOptional.isPresent())
			return ResponseEntity.notFound().build();

		filme.setId(id);
		
		repositorioFilme.save(filme);

		return ResponseEntity.noContent().build();
	}
}

