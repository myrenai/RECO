package com.canalplus.reco.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model Offre.
 *
 * @author faagni
 *
 */
public class Offre {

	private String code;
	private String nom;
	private String description;
	private int score;
	private String codeTraitement;
	private List<Attribut> attributAddionnels;

	/**
	 * constructeur de la classe offre.
	 *
	 * @param code
	 *            code de l'offre
	 * @param nom
	 *            nomm de l'offre
	 * @param description
	 *            de l'offre
	 * @param score
	 *            de l'offre
	 * @param codeTraitement
	 *            de l'offre
	 */
	public Offre(final String code, final String nom, final String description,
			final int score, final String codeTraitement) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.score = score;
		this.codeTraitement = codeTraitement;
		this.attributAddionnels = new ArrayList<Attribut>();
	}

	/**
	 * @return the attributAddionnels
	 */
	public List<Attribut> getAttributAddionnels() {
		return this.attributAddionnels;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @return the codeTraitement
	 */
	public String getCodeTraitement() {
		return this.codeTraitement;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * @param attributAddionnels
	 *            the attributAddionnels to set
	 */
	public void setAttributAddionnels(final List<Attribut> attributAddionnels) {
		this.attributAddionnels = attributAddionnels;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * @param codeTraitement
	 *            the codeTraitement to set
	 */
	public void setCodeTraitement(final String codeTraitement) {
		this.codeTraitement = codeTraitement;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(final int score) {
		this.score = score;
	}

}
