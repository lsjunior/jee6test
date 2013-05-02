package br.net.woodstock.jee6test.common;

import java.io.Serializable;
import java.util.Collection;

public class ResultadoPaginado implements Serializable {

	private int					total;

	private Collection<Object>	items;

	private Pagina				pagina;

	public ResultadoPaginado(final int total, final Collection<Object> items, final Pagina pagina) {
		super();
		this.total = total;
		this.items = items;
		this.pagina = pagina;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Collection<Object> getItems() {
		return this.items;
	}

	public void setItems(Collection<Object> items) {
		this.items = items;
	}

	public Pagina getPagina() {
		return this.pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	// Aux
	public Pagina getPrimeiraPagina() {
		if (this.total > 0) {
			if (this.pagina.getNumero() == 1) {
				return this.pagina;
			}
			return new Pagina(1, this.getPagina().getTamanho());
		}
		return null;
	}

	public Pagina getPaginaAnterior() {
		if (this.total > 0) {
			if (this.pagina.getNumero() > 1) {
				return new Pagina(this.pagina.getNumero() - 1, this.getPagina().getTamanho());
			}
		}
		return null;
	}

	public Pagina getProximaPagina() {
		if (this.total > 0) {
			int nextResult = (this.pagina.getNumero() * this.pagina.getTamanho()) + 1;
			if (nextResult < this.total) {
				return new Pagina(this.pagina.getNumero() + 1, this.getPagina().getTamanho());
			}
		}
		return null;
	}

	public Pagina getUltimaPagina() {
		if (this.total > 0) {
			int lastPage = this.total / this.pagina.getTamanho();
			int mod = this.total % this.pagina.getTamanho();

			if (mod > 0) {
				lastPage++;
			}

			if (this.pagina.getNumero() == lastPage) {
				return this.pagina;
			}

			return new Pagina(lastPage, this.getPagina().getTamanho());
		}
		return null;
	}

}
