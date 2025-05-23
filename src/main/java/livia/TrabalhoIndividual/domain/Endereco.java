package livia.TrabalhoIndividual.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class Endereco {
	@NotBlank(message="Por favor, preencha o campo 'rua'.")
	private String rua;
	
	@NotBlank(message="Por favor, preencha o campo 'cidade'.")
	private String cidade;
	
	@NotBlank(message="Por favor, preencha o campo 'estado'.")
	@Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres. Ex: RJ")
	private String estado;
	
	@NotBlank(message="Por favor, preencha o campo 'cep'.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 12345-678")
	private String cep;
	
 public Endereco() {
	 
 }
	public Endereco( String rua,String cidade,String estado,String cep) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
