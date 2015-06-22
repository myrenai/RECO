package com.canalplus.reco.model;

public class Resultat {

	private boolean reponse;

	/**
	 * @param reponse
	 */
	public Resultat(final boolean reponse) {
		super();
		this.reponse = reponse;
	}

	/**
	 * @return the reponse
	 */
	public boolean isReponse() {
		return this.reponse;
	}

	/**
	 * @param reponse
	 *            the reponse to set
	 */
	public void setReponse(final boolean reponse) {
		this.reponse = reponse;
	}

}
