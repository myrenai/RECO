package com.canalplus.reco.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.json.JSONException;
import org.apache.log4j.Logger;
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

@RestController
@RequestMapping("/V1/Offers")
public class OffresController {

	private static final Logger logger = Logger
			.getLogger(OffresController.class);

	/**
	 * recuperation des offres avec ou sans pr�-calcul. Profil et context au
	 * format JSON + Token d'authentification.
	 *
	 * @param context
	 * @param token
	 * @return offres
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "/next", method = RequestMethod.POST)
	public @ResponseBody List<Offre> getOffres(
			@RequestBody Parametres parametres) {
		logger.debug("pre-calcul offres");
		List<Offre> offre = new ArrayList<Offre>();
		final InteractRestClient interactRestClient = new InteractRestClient();
		final ServiceOffres serviceoffres = new ServiceOffres();
		try {
			offre = serviceoffres.getListeOffres(interactRestClient
					.getResponse(parametres));
		} catch (final JSONException je) {
			logger.debug("erreur json", je);
		} catch (final IOException ie) {
			logger.debug("erreur", ie);
		}
		return offre;
	}

	/**
	 * Modification de l'�tat d'une offre. Offres avec nouvel �tat au format
	 * JSON + Token d'authentification.
	 *
	 * @param offres
	 * @param token
	 * @return offre
	 * @throws JSONException
	 * @throws IOException
	 */
	// @RequestMapping(value = "/results", method = RequestMethod.POST)
	// public Offres getResults(@RequestBody final Context context)
	// throws JSONException, IOException {
	// final InteractRestClient interactRestClient = new InteractRestClient();
	// final ServiceOffres serviceoffres = new ServiceOffres();
	// final Offres offre = serviceoffres.getOffres(interactRestClient
	// .getResponse());
	// return offre;
	// }

	/**
	 * Pr�-calcul des offres. Profil et context au format JSON + Token
	 * d'authentification.
	 *
	 * @param context
	 * @param token
	 * @return resultat boolean
	 */
	@RequestMapping(value = "/context", method = RequestMethod.POST)
	public Resultat precalculOffre
	// (@RequestParam(value="context")Context context,
	// @RequestParam(value="token") String token)
	(@RequestBody final Parametres entry) {
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