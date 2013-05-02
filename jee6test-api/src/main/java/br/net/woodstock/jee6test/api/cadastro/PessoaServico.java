package br.net.woodstock.jee6test.api.cadastro;

import javax.ejb.Stateless;

import br.net.woodstock.jee6test.common.Pagina;
import br.net.woodstock.jee6test.common.ResultadoPaginado;
import br.net.woodstock.jee6test.common.Servico;
import br.net.woodstock.jee6test.orm.Pessoa;

@Stateless
public interface PessoaServico extends Servico {

	Pessoa recuperarPorId(Integer id);

	void salvar(Pessoa pessoa);

	void atualizar(Pessoa pessoa);

	void excluir(Integer id);

	ResultadoPaginado pesquisarPorNome(String nome, Pagina pagina);

}
