package br.com.study.gerenciador.repositorio;

import static br.com.study.gerenciador.modelo.Usuario.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import br.com.study.gerenciador.modelo.Empresa;
import br.com.study.gerenciador.modelo.Usuario;

public class Banco {
	private static Integer chaveSequencial = 1;
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Empresa google = new Empresa();
		google.setId(chaveSequencial++);
		google.setNome("google");

		Empresa amazon = new Empresa();
		amazon.setId(chaveSequencial++);
		amazon.setNome("amazon");

		Empresa facebook = new Empresa();
		facebook.setId(chaveSequencial++);
		facebook.setNome("facebook");

		empresas.add(google);
		empresas.add(amazon);
		empresas.add(facebook);

		Usuario ricardo = builder().login("Ricardo").senha("123456").build();
		Usuario nico = builder().login("Nico").senha("654321").build();
		Usuario tayne = builder().login("Tayne").senha("246810").build();

		usuarios.add(ricardo);
		usuarios.add(nico);
		usuarios.add(tayne);
	}

	private Banco() {
	}

	public static void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public static void remove(Integer id) {
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (Objects.equals(empresa.getId(), id)) {
				it.remove();
			}
		}
	}

	public static Empresa bucaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if (Objects.equals(empresa.getId(), id)) {
				return empresa;
			}
		}
		return null;
	}

	public static Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (Boolean.TRUE.equals(usuario.ehIgual(login, senha))) {
				return usuario;
			}
		}
		return null;
	}
}
