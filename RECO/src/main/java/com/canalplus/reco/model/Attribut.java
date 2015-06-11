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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the dateEffective
	 */
	public Date getDateEffective() {
		return dateEffective;
	}

	/**
	 * @param dateEffective
	 *            the dateEffective to set
	 */
	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * @param dateExpiration
	 *            the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the dureeExpiration
	 */
	public Double getDureeExpiration() {
		return dureeExpiration;
	}

	/**
	 * @param dureeExpiration
	 *            the dureeExpiration to set
	 */
	public void setDureeExpiration(Double dureeExpiration) {
		this.dureeExpiration = dureeExpiration;
	}

	/**
	 * @return the methodeRTSelection
	 */
	public Double getMethodeRTSelection() {
		return methodeRTSelection;
	}

	/**
	 * @param methodeRTSelection
	 *            the methodeRTSelection to set
	 */
	public void setMethodeRTSelection(Double methodeRTSelection) {
		this.methodeRTSelection = methodeRTSelection;
	}

	/**
	 * @return the labelCom
	 */
	public String getLabelCom() {
		return labelCom;
	}

	/**
	 * @param labelCom
	 *            the labelCom to set
	 */
	public void setLabelCom(String labelCom) {
		this.labelCom = labelCom;
	}

	/**
	 * @return the labelSpecial
	 */
	public String getLabelSpecial() {
		return labelSpecial;
	}

	/**
	 * @param labelSpecial
	 *            the labelSpecial to set
	 */
	public void setLabelSpecial(String labelSpecial) {
		this.labelSpecial = labelSpecial;
	}

	/**
	 * @return the periodeLabelvalide
	 */
	public String getPeriodeLabelvalide() {
		return periodeLabelvalide;
	}

	/**
	 * @param periodeLabelvalide
	 *            the periodeLabelvalide to set
	 */
	public void setPeriodeLabelvalide(String periodeLabelvalide) {
		this.periodeLabelvalide = periodeLabelvalide;
	}

}
