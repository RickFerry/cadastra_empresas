package br.com.study.gerenciador.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	private static final long serialVersionUID = -815734287598094422L;

	private String login;
	private String senha;

	public Boolean ehIgual(String login, String senha) {
		return this.login.equals(login) && this.senha.equals(senha);
	}
}
