package br.net.woodstock.jee6test.impl.nucleo;

import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.net.woodstock.jee6test.common.Entidade;
import br.net.woodstock.jee6test.common.Pagina;
import br.net.woodstock.jee6test.common.Repositorio;
import br.net.woodstock.jee6test.common.ResultadoPaginado;

@Local(Repositorio.class)
@Stateful(name = "statefulTicketRepository")
public class RepositorioORMImpl implements RepositorioORM {

	private static final long	serialVersionUID	= -2266690989687450510L;

	@PersistenceContext(name = "defaultPU", type = PersistenceContextType.EXTENDED)
	private EntityManager		entityManager;

	public RepositorioORMImpl() {
		super();
	}

	@Override
	public void atualizar(Entidade entidade) {
		this.entityManager.merge(entidade);

	}

	@Override
	public void excluir(Entidade entidade) {
		this.entityManager.remove(entidade);
	}

	@Override
	public ResultadoPaginado pesquisar(String jpql, String countJpql, Pagina pagina, Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T recuperar(Class<T> clazz, Object id) {
		return this.entityManager.find(clazz, id);
	}

	@Override
	public void salvar(Entidade entidade) {
		this.entityManager.persist(entidade);
	}
}
