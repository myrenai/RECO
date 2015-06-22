package com.canalplus.reco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faagni
 *
 */
public class Parametres implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private List<Parametre> profil;
	private List<Parametre> context;

	public Parametres() {
		super();
		this.profil = new ArrayList<Parametre>();
		this.context = new ArrayList<Parametre>();
	}

	/**
	 * @return the context
	 */
	public List<Parametre> getContext() {
		return this.context;
	}

	/**
	 * @return the profil
	 */
	public List<Parametre> getProfil() {
		return this.profil;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(List<Parametre> context) {
		this.context = context;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
	public void setProfil(List<Parametre> profil) {
		this.profil = profil;
	}

}
