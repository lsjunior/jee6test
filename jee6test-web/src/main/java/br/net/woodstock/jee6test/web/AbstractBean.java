package br.net.woodstock.jee6test.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;

import br.net.woodstock.jee6test.common.web.Bean;
import br.net.woodstock.jee6test.web.util.Paginas;

public abstract class AbstractBean extends Bean {

	private static final long	serialVersionUID	= -4575594819057334506L;

	private Integer				numeroPagina;

	public AbstractBean() {
		super();
	}

	@PostConstruct
	public void defaultPostConstruct() {
		Conversation conversation = this.getConversation();
		if (conversation != null) {
			if (!conversation.isTransient()) {
				conversation.end();
			}
			conversation.begin();
		}
		this.numeroPagina = Integer.valueOf(0);
	}

	protected void reset() {
		//
	}

	public String end() {
		Conversation conversation = this.getConversation();
		if (conversation != null) {
			if (!conversation.isTransient()) {
				conversation.end();
			}
		}
		return Paginas.INDEX;
	}

	protected Conversation getConversation() {
		return null;
	}

	public Integer getNumeroPagina() {
		return this.numeroPagina;
	}

	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

}
