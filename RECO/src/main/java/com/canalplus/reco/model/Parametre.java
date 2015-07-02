/**
 *
 */
package com.canalplus.reco.model;

/**
 * @author faagni
 *
 */
public class Parametre extends AttributOffre {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
		this.dataType = dataType;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return this.dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}

}
