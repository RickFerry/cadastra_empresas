package br.com.study.gerenciador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer chaveSequencial = 1;

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
}
