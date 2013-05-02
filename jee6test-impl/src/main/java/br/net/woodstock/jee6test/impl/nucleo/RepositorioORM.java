package br.net.woodstock.jee6test.impl.nucleo;

import java.util.Map;

import br.net.woodstock.jee6test.common.Entidade;
import br.net.woodstock.jee6test.common.Pagina;
import br.net.woodstock.jee6test.common.Repositorio;
import br.net.woodstock.jee6test.common.ResultadoPaginado;

@SuppressWarnings("rawtypes")
public interface RepositorioORM extends Repositorio {

	<T> T recuperar(Class<T> clazz, Object id);

	void salvar(Entidade entidade);

	void atualizar(Entidade entidade);

	void excluir(Entidade entidade);

	ResultadoPaginado pesquisar(String jpql, String countJpql, Pagina pagina, Map<String, Object> parametros);

}
