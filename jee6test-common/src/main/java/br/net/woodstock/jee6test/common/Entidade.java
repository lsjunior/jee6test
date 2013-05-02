package br.net.woodstock.jee6test.common;

import java.io.Serializable;

public interface Entidade<T> extends Serializable {

	T getId();

	void setId(T id);

}
