package com.canalplus.reco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parametres implements Serializable{

	private List<IdProfil> profil;
	private List<Context> context;
//	private String token;
	
	
	
	/**
	 * @return the profil
	 */
	public List<IdProfil> getProfil() {
		return profil;
	}
	/**
	 * 
	 */
	public Parametres() {
		super();
		this.profil = new ArrayList<IdProfil>();
		this.context = new ArrayList<Context>();
	}
	/**
	 * @param profil the profil to set
	 */
	public void setProfil(List<IdProfil> profil) {
		this.profil = profil;
	}
	/**
	 * @return the context
	 */
	public List<Context> getContext() {
		return context;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(List<Context> context) {
		this.context = context;
	}
}
