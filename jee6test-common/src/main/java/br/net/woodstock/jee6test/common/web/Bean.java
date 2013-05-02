package br.net.woodstock.jee6test.common.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Bean implements Serializable {

	private static final long	serialVersionUID	= -7440699325046593029L;

	// Faces
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected void addMessage(final String message) {
		FacesContext context = this.getFacesContext();
		context.addMessage(null, new FacesMessage(message));
	}

	protected void addErrorMessage(final String message) {
		FacesContext context = this.getFacesContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}

	// Http
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) this.getFacesContext().getExternalContext().getRequest();
	}

	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) this.getFacesContext().getExternalContext().getResponse();
	}

	protected HttpSession getSession() {
		return ((HttpServletRequest) this.getFacesContext().getExternalContext().getRequest()).getSession();
	}
}
