/**
 *
 */
package com.canalplus.reco.model;

import java.io.Serializable;

/**
 * @author faagni
 *
 */
public class Parametre implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private String name;
	private String value;
	private String dataType;

	public Parametre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * @param name
	 * @param value
	 * @param dataType
	 */
	public Parametre(final String name, final String value,
			final String dataType) {
		super();
		this.name = name;
		this.value = value;
		this.dataType = dataType;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return this.dataType;
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
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final String value) {
		this.value = value;
	}

}
