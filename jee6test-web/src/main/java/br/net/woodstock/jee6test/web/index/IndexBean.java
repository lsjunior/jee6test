package br.net.woodstock.jee6test.web.index;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.net.woodstock.jee6test.web.AbstractBean;

@Named("indexBean")
@ApplicationScoped
public class IndexBean extends AbstractBean {

	private static final long	serialVersionUID	= 2606439107175456914L;

	public IndexBean() {
		super();
	}

	public String index() {
		return null;
	}

}
