package br.com.study.gerenciador.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

	private Long id;
	private String nome;
	private Date dataAbertura;
}
