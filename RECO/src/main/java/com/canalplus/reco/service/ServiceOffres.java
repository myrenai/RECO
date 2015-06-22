package com.canalplus.reco.service;

import java.io.IOException;

import org.apache.commons.json.JSONException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.canalplus.reco.model.Offre;
import com.canalplus.reco.model.Offres;
import com.unicacorp.interact.api.BatchResponse;
import com.unicacorp.interact.api.Offer;
import com.unicacorp.interact.api.OfferList;
import com.unicacorp.interact.api.Response;

public class ServiceOffres {

	public static final Logger logger = LogManager
			.getLogger(ServiceOffres.class);

	/**
	 * Pemret de recupere la liste des offres.
	 *
	 * @param interactRestResponse
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public Offres getOffres(final BatchResponse interactRestResponse)
			throws JSONException, IOException {
		logger.debug("service offre : calcul des offres");
		Offre reponse = null;
		final Offres listFinalOffre = new Offres();
		final Response[] listReponses = interactRestResponse.getResponses();
		if (listReponses != null && listReponses.length != 0) {
			for (final Response offrereponse : listReponses) {
				final OfferList[] listeOffresResponse = offrereponse
						.getAllOfferLists();
				if (listeOffresResponse != null
						&& listeOffresResponse.length != 0) {
					for (final OfferList offreReponse : listeOffresResponse) {
						final Offer[] exempleOffre = offreReponse
								.getRecommendedOffers();
						if (exempleOffre != null && exempleOffre.length != 0) {
							for (final Offer offreType : exempleOffre) {
								final StringBuilder builder = new StringBuilder();
								for (final String s : offreType.getOfferCode()) {
									builder.append(s);
								}
								reponse = new Offre(builder.toString(),
										offreType.getOfferName(),
										offreType.getDescription(),
										offreType.getScore(),
										offreType.getTreatmentCode());
								listFinalOffre.getOffre().add(reponse);
							}
						}
					}
				}
			}

		}
		return listFinalOffre;
	}

}
