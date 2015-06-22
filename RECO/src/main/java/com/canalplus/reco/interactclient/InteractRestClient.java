package com.canalplus.reco.interactclient;

/**
 # *******************************************************************************
 #  Licensed Materials - Property of IBM
 #  Unica Interact
 #  (c) Copyright IBM Corporation 2001, 2013.
 #  US Government Users Restricted Rights - Use, duplication or disclosure
 #  restricted by GSA ADP Schedule Contract with IBM Corp.
 # *******************************************************************************
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.json.JSONException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.canalplus.reco.model.Parametre;
import com.canalplus.reco.model.Parametres;
import com.unicacorp.interact.api.BatchResponse;
import com.unicacorp.interact.api.Command;
import com.unicacorp.interact.api.CommandImpl;
import com.unicacorp.interact.api.NameValuePair;
import com.unicacorp.interact.api.NameValuePairImpl;
import com.unicacorp.interact.api.rest.RestClientConnector;

/**
 * classe permettant de se connecter a une instance d'interact via une interface
 * REST. Le connexion consite a encoyer un batch a interact en inculant les
 * commandes suivantes: startsession, getOffers, getprofile, endSession.
 * l'audiance cible par defaut est customer, le nombre d'offre est demand� (par
 * defaut a 5).
 *
 * pour se connecter les informations suivantes sont a fournir: l'url
 * d'interact, l'ID de session, le nom du canal interactif cible, le nom du
 * point d'interaction et l'ID customer.
 *
 * @author faagni
 *
 */

public class InteractRestClient {

	public static final Logger logger = LogManager
			.getLogger(InteractRestClient.class);

	/**
	 * permet de fermer la session.
	 *
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createEndSessionCommand() throws JSONException {
		logger.debug("interact : fin de session");
		final CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_ENDSESSION);
		return cmd;
	}

	/**
	 * Recupere les offres.
	 *
	 * @param ipName
	 *            nom du point d'interaction
	 * @param numberRequested
	 *            nombre de requete d'offre
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createGetOffersCommand(final String ipName,
			final int numberRequested) throws JSONException {
		final CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_GETOFFERS);
		cmd.setInteractionPoint(ipName);
		cmd.setNumberRequested(numberRequested);
		return cmd;
	}

	/**
	 * permet de recuperer un profil.
	 *
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createGetProfileCommand() throws JSONException {
		final CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_GETPROFILE);
		return cmd;
	}

	/**
	 * /** permet d'ouvrir une session avec des parametres pr�defini.
	 *
	 * @param audienceLevel
	 *
	 * @param icName
	 * @return cmd commande
	 * @throws JSONException
	 */
	private static Command createStartSessionCommand(Parametres parametres,
			String audienceLevel) throws JSONException {
		final CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_STARTSESSION);
		if (parametres != null) {
			// donnees du context => EventParameters
			if (!CollectionUtils.isEmpty(parametres.getContext())) {
				final List<NameValuePairImpl> contextData = new ArrayList<NameValuePairImpl>();
				for (final Parametre parametre : parametres.getContext()) {
					NameValuePairImpl contextParametre;
					if ("string".equals(parametre.getDataType())) {
						contextParametre = new NameValuePairImpl(
								parametre.getName(),
								NameValuePair.DATA_TYPE_STRING,
								parametre.getValue());
					} else if ("numeric".equals(parametre.getDataType())) {
						contextParametre = new NameValuePairImpl(
								parametre.getName(),
								NameValuePair.DATA_TYPE_NUMERIC,
								Double.valueOf(parametre.getValue()));
					} else {
						contextParametre = new NameValuePairImpl(
								parametre.getName(),
								NameValuePair.DATA_TYPE_DATETIME,
								parametre.getValue());
					}
					contextData.add(contextParametre);
				}
				final NameValuePairImpl[] eventParameters = new NameValuePairImpl[contextData
				                                                                  .size()];
				contextData.toArray(eventParameters);
				cmd.setEventParameters(eventParameters);
			}
			// donnees du profil
			// InteractiveChannel => uaciinteractivechannelname
			// AudienceId => customerid
			// AudianceLevel
			if (!CollectionUtils.isEmpty(parametres.getProfil())) {
				for (final Parametre parametre : parametres.getProfil()) {
					if ("customerid".equals(parametre.getName())) {
						cmd.setAudienceID(new NameValuePairImpl[] { new NameValuePairImpl(
								parametre.getName(),
								NameValuePair.DATA_TYPE_NUMERIC, Double
								.valueOf(parametre.getValue())) });
					}
					if ("uaciinteractivechannelname"
							.equals(parametre.getName())) {
						cmd.setInteractiveChannel(parametre.getValue());
					}
				}
				cmd.setAudienceLevel(audienceLevel);
			}
		}
		// permet de reetiliser la session avec l'id session
		// si la seesion n'existe pas, elle est cree
		cmd.setRelyOnExistingSession(false);
		cmd.setDebug(true);
		return cmd;
	}

	@Autowired
	private final InteractProperties inetractProp = new InteractProperties();

	/**
	 * retourne le batch reponse qui contient les offres.
	 *
	 * @return batch reponse d'interact.
	 * @throws JSONException
	 * @throws IOException
	 */
	public BatchResponse getResponse(Parametres parametres)
			throws JSONException, IOException {
		String url = "http://frrnseureka.fr.capgemini.com:7000/interact";
		url += "/servlet/RestServlet";
		final String sessionId = String.valueOf(System.currentTimeMillis());
		final String audianceLevel = "Customer";
		final String ipName = "pi_1";
		final int numberRequested = 5;
		// final String urrl = this.inetractProp.getUrl();
		final List<Command> cmds = new ArrayList<Command>();
		cmds.add(0, createStartSessionCommand(parametres, audianceLevel));
		cmds.add(1, createGetOffersCommand(ipName, numberRequested));
		cmds.add(2, createGetProfileCommand());
		cmds.add(3, createEndSessionCommand());

		RestClientConnector.initialize();
		final RestClientConnector connector = new RestClientConnector(url);

		final BatchResponse response = connector.executeBatch(sessionId,
				cmds.toArray(new Command[0]), null, null);
		return response;
	}
}