package br.com.future_mob.model.DTO;

public class AutenticacaoDTO {
	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}