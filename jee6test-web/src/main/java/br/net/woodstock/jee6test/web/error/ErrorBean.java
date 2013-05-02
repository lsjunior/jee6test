package br.net.woodstock.jee6test.web.error;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.net.woodstock.jee6test.web.AbstractBean;

@Named("errorBean")
@RequestScoped
public class ErrorBean extends AbstractBean {

	private static final long	serialVersionUID	= -2903910914783927112L;

	public ErrorBean() {
		super();
	}

	@PostConstruct
	public void start() {
		// Get Exception
	}

}
