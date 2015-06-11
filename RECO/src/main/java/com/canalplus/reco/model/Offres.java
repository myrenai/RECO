package com.canalplus.reco.model;

import java.util.ArrayList;
import java.util.List;

/**
 * model liste d'offres.
 * 
 * @author faagni
 *
 */
public class Offres {

	private List<Offre> offre;

	/**
	 * constructeur de la classe Offres permet d'initialiser la liste des offres
	 */
	public Offres() {
		super();
		offre = new ArrayList<Offre>();
	}

	/**
	 * @return the offre
	 */
	public List<Offre> getOffre() {
		return offre;
	}

	/**
	 * @param offre
	 *            the offre to set
	 */
	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}

}
