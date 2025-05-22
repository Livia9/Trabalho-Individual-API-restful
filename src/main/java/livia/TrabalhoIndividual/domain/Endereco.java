package livia.TrabalhoIndividual.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
	@NotBlank(message="Por favor, preencha o campo 'rua'.")
	private String rua;
	
	@NotBlank(message="Por favor, preencha o campo 'cidade'.")
	private String cidade;
	
	@NotBlank(message="Por favor, preencha o campo 'estado'.")
	private String estado;
	
	@NotBlank(message="Por favor, preencha o campo 'cep'.")
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
