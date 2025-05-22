package livia.TrabalhoIndividual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import livia.TrabalhoIndividual.domain.Funcionario;
import livia.TrabalhoIndividual.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> pesquisarid(@PathVariable Long id) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        if (!funcionarioOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionarioOpt.get());
    }
    
    @PostMapping
    public ResponseEntity<Funcionario> inserir(@RequestBody @Valid Funcionario funcionario) {
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    
    @PostMapping("/lista")
    public ResponseEntity<List<Funcionario>> inserir(@RequestBody @Valid List<Funcionario> funcionarios) {
        List<Funcionario> salvos = funcionarioRepository.saveAll(funcionarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        if (funcionarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(atualizado);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
