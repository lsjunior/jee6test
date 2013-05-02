package br.net.woodstock.jee6test.impl.cadastro;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import br.net.woodstock.jee6test.api.cadastro.PessoaServico;
import br.net.woodstock.jee6test.common.Pagina;
import br.net.woodstock.jee6test.common.ResultadoPaginado;
import br.net.woodstock.jee6test.impl.nucleo.RepositorioORM;
import br.net.woodstock.jee6test.impl.nucleo.utils.JPQLHelper;
import br.net.woodstock.jee6test.orm.Pessoa;

@Local(PessoaServico.class)
@Stateful
public class PessoaServicoImpl implements PessoaServico {

	private static final long	serialVersionUID	= -2266690989687450510L;

	@EJB
	private RepositorioORM		repositorioORM;

	public PessoaServicoImpl() {
		super();
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		this.repositorioORM.atualizar(pessoa);
	}

	@Override
	public void excluir(Integer id) {
		Pessoa pessoa = this.repositorioORM.recuperar(Pessoa.class, id);
		if (pessoa != null) {
			this.repositorioORM.excluir(pessoa);
		}

	}

	@Override
	public ResultadoPaginado pesquisarPorNome(String nome, Pagina pagina) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome", JPQLHelper.getLikeValue(nome, false));
		return this.repositorioORM.pesquisar("SELECT p FROM Pessoa AS p WHERE p.nome LIKE :nome ORDER BY p.nome", "SELECT COUNT(*) FROM Pessoa AS p WHERE p.nome LIKE :nome", pagina, parametros);
	}

	@Override
	public Pessoa recuperarPorId(Integer id) {
		return this.repositorioORM.recuperar(Pessoa.class, id);
	}

	@Override
	public void salvar(Pessoa pessoa) {
		this.repositorioORM.salvar(pessoa);
	}
}
