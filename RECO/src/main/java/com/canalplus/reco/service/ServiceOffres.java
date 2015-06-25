package com.canalplus.reco.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.json.JSONException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.canalplus.reco.model.Offre;
import com.canalplus.reco.model.ParametreOffre;
import com.unicacorp.interact.api.BatchResponse;
import com.unicacorp.interact.api.NameValuePair;
import com.unicacorp.interact.api.Offer;
import com.unicacorp.interact.api.OfferList;
import com.unicacorp.interact.api.Response;

public class ServiceOffres {

	public static final Logger logger = LogManager
			.getLogger(ServiceOffres.class);

	public static final String ATTRIBUT_OFFRE_CODE = "code";
	public static final String ATTRIBUT_OFFRE_NOM = "nom";
	public static final String ATTRIBUT_OFFRE_DESCRIPTION = "description";
	public static final String ATTRIBUT_OFFRE_SCORE = "score";
	public static final String ATTRIBUT_OFFRE_CODE_TRAITREMENT = "codeTraitement";

	/**
	 * permet de récuperer la liste d'offres d'interact
	 *
	 * @param listeOffresResponse
	 * @return
	 */
	List<Offre> getInteractListOffres(OfferList[] listeOffresResponse) {
		final Offre reponse = new Offre();
		final List<Offre> listeReponse = new ArrayList<Offre>();

		final List<ParametreOffre> listeParametresOffres = new ArrayList<ParametreOffre>();
		if (listeOffresResponse != null && listeOffresResponse.length != 0) {
			for (final OfferList offreReponse : listeOffresResponse) {
				final Offer[] listOffreInteract = offreReponse
						.getRecommendedOffers();
				if (listOffreInteract != null && listOffreInteract.length != 0) {
					for (final Offer offreInteract : listOffreInteract) {
						listeReponse.add(this.getOffre(offreInteract));
					}
				}
				reponse.setOffres(listeParametresOffres);
				listeReponse.add(reponse);
			}
		}
		return listeReponse;
	}

	/**
	 * Pemret de recupere la liste des offres.
	 *
	 * @param interactRestResponse
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public final List<Offre> getListeOffres(
			final BatchResponse interactRestResponse) throws JSONException,
			IOException {
		logger.debug("service offre : calcul des offres");
		final List<Offre> listeReponse = new ArrayList<Offre>();
		final Response[] listReponses = interactRestResponse.getResponses();
		if (listReponses != null && listReponses.length != 0) {
			for (final Response offrereponse : listReponses) {
				final OfferList[] listeOffresResponse = offrereponse
						.getAllOfferLists();
				listeReponse.addAll(this
						.getInteractListOffres(listeOffresResponse));
			}
		}
		return listeReponse;
	}

	/**
	 * permet de recuperer les données d'une offre d'interact
	 *
	 * @param offre
	 * @return
	 */
	final Offre getOffre(final Offer offre) {
		final Offre reponse = new Offre();
		final List<ParametreOffre> listeParametresOffres = new ArrayList<ParametreOffre>();
		final StringBuilder builder = new StringBuilder();
		if (offre != null) {
			for (final String s : offre.getOfferCode()) {
				builder.append(s);
			}
			listeParametresOffres.add(new ParametreOffre(ATTRIBUT_OFFRE_CODE,
					builder.toString()));
			listeParametresOffres.add(new ParametreOffre(ATTRIBUT_OFFRE_NOM,
					offre.getOfferName()));
			listeParametresOffres.add(new ParametreOffre(
					ATTRIBUT_OFFRE_DESCRIPTION, offre.getDescription()));
			listeParametresOffres.add(new ParametreOffre(ATTRIBUT_OFFRE_SCORE,
					Integer.toString(offre.getScore())));
			listeParametresOffres.add(new ParametreOffre(
					ATTRIBUT_OFFRE_CODE_TRAITREMENT, offre.getTreatmentCode()));
			final NameValuePair[] attributs = offre.getAdditionalAttributes();
			if (attributs != null && attributs.length != 0) {
				for (final NameValuePair attribut : attributs) {
					listeParametresOffres.add(new ParametreOffre(attribut
							.getName(), attribut.getValueAsString()));
				}
			}
			reponse.setOffres(listeParametresOffres);
		}
		return reponse;
	}
}
