package br.net.woodstock.jee6test.common;

import java.io.Serializable;

public class Pagina implements Serializable {

	private static final long	serialVersionUID	= -1420405768588077569L;

	private int					numero;

	private int					tamanho;

	public Pagina() {
		super();
	}

	public Pagina(final int numero, final int tamanho) {
		super();
		this.numero = numero;
		this.tamanho = tamanho;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
