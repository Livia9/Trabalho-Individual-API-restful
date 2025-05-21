package livia.TrabalhoIndividual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import livia.TrabalhoIndividual.repository.FuncionarioRepository;

@RestController
@RequestMapping("{/funcionarios}")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
//	criar crud
//	
//	@GetMapping
//	@GetMapping("/{id}")
//	@PutMapping("/{id}")
//	//id nao pode ser att
//	@PostMapping
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
