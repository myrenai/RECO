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
	public Offre(String code, String nom, String description, int score,
			String codeTraitement) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.score = score;
		this.codeTraitement = codeTraitement;
		this.attributAddionnels = new ArrayList<Attribut>();
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the codeTraitement
	 */
	public String getCodeTraitement() {
		return codeTraitement;
	}

	/**
	 * @param codeTraitement
	 *            the codeTraitement to set
	 */
	public void setCodeTraitement(String codeTraitement) {
		this.codeTraitement = codeTraitement;
	}

	/**
	 * @return the attributAddionnels
	 */
	public List<Attribut> getAttributAddionnels() {
		return attributAddionnels;
	}

	/**
	 * @param attributAddionnels
	 *            the attributAddionnels to set
	 */
	public void setAttributAddionnels(List<Attribut> attributAddionnels) {
		this.attributAddionnels = attributAddionnels;
	}

}
