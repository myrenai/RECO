package com.canalplus.reco.model;

import java.util.Date;

/**
 * Model attribut addionnels d'une offre.
 *
 * @author faagni
 *
 */
public class Attribut {

	private String url;
	private Date dateEffective;
	private Date dateExpiration;
	private Double dureeExpiration;
	private Double methodeRTSelection;
	private String labelCom;
	private String labelSpecial;
	private String periodeLabelvalide;

	/**
	 * constructeur de la classe Attribut
	 */
	public Attribut() {
		super();
	}

	/**
	 * @return the dateEffective
	 */
	public Date getDateEffective() {
		return this.dateEffective;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	/**
	 * @return the dureeExpiration
	 */
	public Double getDureeExpiration() {
		return this.dureeExpiration;
	}

	/**
	 * @return the labelCom
	 */
	public String getLabelCom() {
		return this.labelCom;
	}

	/**
	 * @return the labelSpecial
	 */
	public String getLabelSpecial() {
		return this.labelSpecial;
	}

	/**
	 * @return the methodeRTSelection
	 */
	public Double getMethodeRTSelection() {
		return this.methodeRTSelection;
	}

	/**
	 * @return the periodeLabelvalide
	 */
	public String getPeriodeLabelvalide() {
		return this.periodeLabelvalide;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param dateEffective
	 *            the dateEffective to set
	 */
	public void setDateEffective(final Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	/**
	 * @param dateExpiration
	 *            the dateExpiration to set
	 */
	public void setDateExpiration(final Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @param dureeExpiration
	 *            the dureeExpiration to set
	 */
	public void setDureeExpiration(final Double dureeExpiration) {
		this.dureeExpiration = dureeExpiration;
	}

	/**
	 * @param labelCom
	 *            the labelCom to set
	 */
	public void setLabelCom(final String labelCom) {
		this.labelCom = labelCom;
	}

	/**
	 * @param labelSpecial
	 *            the labelSpecial to set
	 */
	public void setLabelSpecial(final String labelSpecial) {
		this.labelSpecial = labelSpecial;
	}

	/**
	 * @param methodeRTSelection
	 *            the methodeRTSelection to set
	 */
	public void setMethodeRTSelection(final Double methodeRTSelection) {
		this.methodeRTSelection = methodeRTSelection;
	}

	/**
	 * @param periodeLabelvalide
	 *            the periodeLabelvalide to set
	 */
	public void setPeriodeLabelvalide(final String periodeLabelvalide) {
		this.periodeLabelvalide = periodeLabelvalide;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

}
