package com.canalplus.reco.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.json.JSONException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.reco.interactclient.InteractRestClient;
import com.canalplus.reco.model.Offre;
import com.canalplus.reco.model.Offres;
import com.canalplus.reco.model.Parametres;
import com.canalplus.reco.model.Resultat;
import com.canalplus.reco.service.ServiceOffres;
import com.wordnik.swagger.annotations.Api;

//swagger annotation
@Api(value = "/V0/Offers", description = "balbalba test")
@RestController
@RequestMapping("/V0/Offers")
public class OffresControllerBouchon {

	private static final Logger logger = Logger
			.getLogger(OffresControllerBouchon.class);
	


	@Value("${reco.interact.url}")
	String url;

	@Value("${reco.inetract.ipName}")
	String ipName;


	@Value("${reco.interact.numberRequested}")
	String numberRequested;

	@Value("reco.interact.debugOption")
	String debugOption;

	/**
	 * Recupere des offres avec ou sans precalcul.
	 *
	 * @param parametres
	 * @return
	 */
	@RequestMapping(value = "/next", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Offre> getOffres(
			@RequestBody Parametres parametres) {
		logger.debug("pre-calcul offres");
		List<Offre> offre = new ArrayList<Offre>();
		final InteractRestClient interactRestClient = new InteractRestClient();
		final ServiceOffres serviceoffres = new ServiceOffres();
		try {
			offre = serviceoffres.getListeOffres(interactRestClient
					.getResponse(parametres, this.url, this.ipName, this.numberRequested,
							Boolean.valueOf(this.debugOption)));
		} catch (final JSONException je) {
			logger.debug("erreur json", je);
		} catch (final IOException ie) {
			logger.debug("erreur", ie);
		}
		return offre;
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
	public List<Offre> getResults(@RequestBody Parametres parametres) {
		List<Offre> offre = new ArrayList<Offre>();
		final InteractRestClient interactRestClient = new InteractRestClient();
		final ServiceOffres serviceoffres = new ServiceOffres();
		try {
			offre = serviceoffres.getListeOffres(interactRestClient
					.getResponse(parametres, this.url, this.ipName, this.numberRequested,
							Boolean.valueOf(this.debugOption)));
		} catch (final JSONException je) {
			logger.debug("erreur json", je);
		} catch (final IOException ie) {
			logger.debug("erreur", ie);
		}
		return offre;
	}

	/**
	 * Pr�-calcul des offres. Profil et context au format JSON + Token
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
	 * Validation. Offres � valider avec informations compl�mentaires utiles aux
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