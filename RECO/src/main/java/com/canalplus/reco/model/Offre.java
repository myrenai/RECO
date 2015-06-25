package com.canalplus.reco.model;

import java.util.List;

/**
 * Model Offre.
 *
 * @author faagni
 *
 */
public class Offre {

	private List<ParametreOffre> offres;

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the offres
	 */
	public List<ParametreOffre> getOffres() {
		return this.offres;
	}

	/**
	 * @param offres
	 *            the offres to set
	 */
	public void setOffres(List<ParametreOffre> offres) {
		this.offres = offres;
	}

}
