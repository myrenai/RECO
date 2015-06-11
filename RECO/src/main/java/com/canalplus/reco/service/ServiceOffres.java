package com.canalplus.reco.service;

import java.io.IOException;

import org.apache.commons.json.JSONException;

import com.canalplus.reco.model.Offre;
import com.canalplus.reco.model.Offres;
import com.unicacorp.interact.api.BatchResponse;
import com.unicacorp.interact.api.Offer;
import com.unicacorp.interact.api.OfferList;
import com.unicacorp.interact.api.Response;

public class ServiceOffres {

	/**
	 * Pemret de recupere la liste des offres.
	 * @param interactRestResponse
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public Offres getOffres(BatchResponse interactRestResponse)
			throws JSONException, IOException {
		Offre reponse = null;
		Offres listFinalOffre = new Offres();
		Response[] listReponses = interactRestResponse.getResponses();
		if (listReponses != null && listReponses.length != 0) {
			for (Response offrereponse : listReponses) {
				OfferList[] listeOffresResponse = offrereponse
						.getAllOfferLists();
				if (listeOffresResponse != null
						&& listeOffresResponse.length != 0) {
					for (OfferList offreReponse : listeOffresResponse) {
						Offer[] exempleOffre = offreReponse
								.getRecommendedOffers();
						if (exempleOffre != null && exempleOffre.length != 0) {
							for (Offer offreType : exempleOffre) {
								StringBuilder builder = new StringBuilder();
								for(String s : offreType.getOfferCode()) {
								    builder.append(s);
								}
								reponse = new Offre(builder.toString(), offreType.getOfferName(),
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
