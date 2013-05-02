package br.net.woodstock.jee6test.web.cadastro;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.net.woodstock.jee6test.api.cadastro.PessoaServico;
import br.net.woodstock.jee6test.orm.Pessoa;

@Named("pessoaConverter")
@ApplicationScoped
public class PessoaConverter implements Converter, Serializable {

	private static final long	serialVersionUID	= -3135959435070001362L;

	@EJB
	private PessoaServico		pessoaServico;

	public PessoaConverter() {
		super();
	}

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		if ((value != null) && (!value.trim().isEmpty())) {
			Integer id = Integer.valueOf(value);
			Pessoa pessoa = this.pessoaServico.recuperarPorId(id);
			return pessoa;
		}
		return null;
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		if (value instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId().toString();
		}
		return null;
	}

}
