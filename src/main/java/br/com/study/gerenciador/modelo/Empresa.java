package br.com.study.gerenciador.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
}
