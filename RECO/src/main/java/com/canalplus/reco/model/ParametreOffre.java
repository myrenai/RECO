package com.canalplus.reco.model;

import java.io.Serializable;

public class ParametreOffre implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;

	/**
	 *
	 */
	public ParametreOffre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * @param name
	 * @param value
	 */
	public ParametreOffre(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
