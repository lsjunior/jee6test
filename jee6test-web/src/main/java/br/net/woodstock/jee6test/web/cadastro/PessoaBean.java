package br.net.woodstock.jee6test.web.cadastro;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.net.woodstock.jee6test.api.cadastro.PessoaServico;
import br.net.woodstock.jee6test.orm.User;
import br.net.woodstock.jee6test.orm.UserType;
import br.net.woodstock.jee6test.web.AbstractBean;
import br.net.woodstock.jee6test.web.util.ConfigBean;
import br.net.woodstock.jee6test.web.util.Constants;
import br.net.woodstock.rockframework.domain.persistence.Page;
import br.net.woodstock.rockframework.domain.persistence.orm.ORMResult;
import br.net.woodstock.rockframework.web.faces.EntityRepository;
import br.net.woodstock.rockframework.web.faces.primefaces.EntityDataModel;
import br.net.woodstock.rockframework.web.faces.security.Logon;
import br.net.woodstock.rockframework.web.faces.security.Role;
import br.net.woodstock.rockframework.web.faces.util.ExceptionHandler;
import br.net.woodstock.rockframework.web.faces.util.Log;
import br.net.woodstock.rockframework.web.faces.utils.FacesContexts;

@Named("userBean")
@ConversationScoped
@Log
@ExceptionHandler
@Logon
@Role(Constants.ADMINISTRATOR_ROLE)
public class PessoaBean extends AbstractBean {

	private static final long		serialVersionUID	= 365982448995745841L;

	private static final String		LIST_VIEW			= "/access/user-list.xhtml";

	private static final String		SAVE_VIEW			= "/access/user-save.xhtml";

	private Integer					id;

	private String					login;

	private String					name;

	private String					email;

	private String					password;

	private String					type;

	private String					view;

	private String					filter;

	private EntityDataModel<User>	users;

	@EJB
	private PessoaServico				userService;

	@Inject
	private Conversation			conversation;

	public PessoaBean() {
		super();
		this.view = PessoaBean.LIST_VIEW;
	}

	public String newUser() {
		this.id = null;
		this.login = null;
		this.name = null;
		this.email = null;
		this.password = null;
		this.type = null;
		this.view = PessoaBean.SAVE_VIEW;
		return null;
	}

	public String list() {
		EntityRepository repository = new EntityRepository() {

			private static final long	serialVersionUID	= -7098011024917168622L;

			@Override
			public ORMResult getResult(final Page page) {
				return PessoaBean.this.getUserService().listByName(PessoaBean.this.getFilter(), page);
			}

			@Override
			public Object getEntity(final Object id) {
				return PessoaBean.this.getUserService().getById((Integer) id);
			}

		};

		this.users = new EntityDataModel<User>(ConfigBean.PAGE_SIZE, repository);
		return null;
	}

	public String edit() {
		User user = this.userService.getById(this.id);
		this.id = user.getId();
		this.login = user.getLogin();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.type = user.getType().name();
		this.view = PessoaBean.SAVE_VIEW;
		return null;
	}

	public String save() {
		User user = new User();
		user.setLogin(this.login);
		user.setName(this.name);
		user.setEmail(this.email);
		user.setPassword(this.password);
		user.setType(UserType.valueOf(this.type));

		if (this.isValidId(this.id)) {
			user.setId(this.id);
			this.userService.update(user);
		} else {
			this.userService.save(user);
			this.id = null;
			this.login = null;
			this.name = null;
			this.email = null;
			this.password = null;
			this.type = null;
		}

		this.addMessage(this.getMessageOperationOK());

		return null;
	}

	public String cancel() {
		this.view = PessoaBean.LIST_VIEW;
		if (this.users != null) {
			this.list();
		}
		return null;
	}

	// Getters and Setters
	@Override
	public Conversation getConversation() {
		return this.conversation;
	}

	public PessoaServico getUserService() {
		return this.userService;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getView() {
		return this.view;
	}

	public void setView(final String view) {
		this.view = view;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(final String filter) {
		this.filter = filter;
	}

	public EntityDataModel<User> getUsers() {
		return this.users;
	}

	public void setUsers(final EntityDataModel<User> users) {
		this.users = users;
	}

	// Aux
	public List<SelectItem> getUserTypes() {
		return FacesContexts.getItemsFromEnum(UserType.class);
	}
}
