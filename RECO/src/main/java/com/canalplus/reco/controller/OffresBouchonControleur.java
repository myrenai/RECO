package com.canalplus.reco.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.json.JSONException;
import org.apache.commons.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.reco.model.Offres;
import com.canalplus.reco.model.Parametres;
import com.canalplus.reco.model.Resultat;
import com.canalplus.utils.Consts;

/**
 *
 * @author faagni
 *
 */
@RestController
@RequestMapping("/V0/Offers")
public class OffresBouchonControleur {

	private static final Logger logger = Logger.getLogger(OffresBouchonControleur.class);

	/**
	 * Recupere des offres avec ou sans precalcul.
	 *
	 * @param parametres
	 * @return
	 */
	@RequestMapping(value = "/next", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody JSONObject getOffres(@RequestBody Parametres parametres) {
		InputStream file = null;
		JSONObject jsonObject = null;
		try {
			file = new FileInputStream(Consts.URL_INTERACT);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			jsonObject = new JSONObject(file);
		} catch (final JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * Modification de l'etat d'une offre. Offres avec nouvel etat au format
	 * JSON.
	 *
	 * @param offres
	 * @param token
	 * @return offre
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "/results", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public JSONObject getResults(@RequestBody Parametres parametres) {
		InputStream file = null;
		JSONObject jsonObject = null;
		try {
			file = new FileInputStream(Consts.URL_INTERACT);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			jsonObject = new JSONObject(file);
		} catch (final JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * Pre-calcul des offres. Profil et context au format JSON + Token
	 * d'authentification.
	 *
	 * @param context
	 * @param token
	 * @return resultat boolean
	 */
	@RequestMapping(value = "/context", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Resultat precalculOffre(@RequestBody final Parametres entry) {
		return new Resultat(true);
	}

	/**
	 * Validation. Offres a valider avec informations complementaires utiles aux
	 * actes de gestion.
	 *
	 * @param offres
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public Resultat validateOffre(@RequestBody final Offres offres) {
		if (offres != null) {
			return new Resultat(true);
		} else {
			return new Resultat(false);
		}
	}
}
