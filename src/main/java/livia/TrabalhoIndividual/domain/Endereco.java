package livia.TrabalhoIndividual.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

	String rua;
	String cidade;
	String estado;
	String cep;
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
