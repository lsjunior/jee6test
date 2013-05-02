package br.net.woodstock.jee6test.orm;

import br.net.woodstock.jee6test.common.Entidade;

public class Pessoa implements Entidade<Integer> {


	private Integer				id;

	private String				cpf;

	private String				nome;

	public Pessoa() {
		super();
	}

	public Pessoa(final Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
