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
import com.unicacorp.interact.api.BatchResponse;
import com.unicacorp.interact.api.Command;
import com.unicacorp.interact.api.CommandImpl;
import com.unicacorp.interact.api.NameValuePair;
import com.unicacorp.interact.api.NameValuePairImpl;
import com.unicacorp.interact.api.rest.RestClientConnector;


/**
 * classe permettant de se connecter a une instance d'interact via une interface REST.
 * Le connexion consite a encoyer un batch a interact en inculant les commandes suivantes: startsession, getOffers, getprofile, endSession.
 * l'audiance cible par defaut est customer, le nombre d'offre est demandé (par defaut a 5).
 * 
 *  pour se connecter les informations suivantes sont a fournir: l'url d'interact, l'ID de session, le nom du canal interactif cible, 
 *  le nom du point d'interaction et l'ID customer.
 * @author faagni
 *
 */
public class InteractRestClient {
	
	/**
	 * retourne le batch reponse qui contient les offres.
	 * @return batch reponse d'interact.
	 * @throws JSONException
	 * @throws IOException
	 */
	public BatchResponse getResponse() throws JSONException, IOException{
		String url = "http://frrnseureka.fr.capgemini.com:7000/interact";
			url += "/servlet/RestServlet";
			String sessionId = String.valueOf(System.currentTimeMillis());
			String icName = "Mobile_app";
			String audianceLevel = "Customer";
			Double audianceNumber = 114.0;
			String ipName = "pi_1";
			int numberRequested = 5;

			List<Command> cmds = new ArrayList<Command>();
			cmds.add(0, createStartSessionCommandComplete(icName, audianceLevel, audianceNumber));
			cmds.add(1, createGetOffersCommand(ipName, numberRequested));
			cmds.add(2, createGetProfileCommand());
			cmds.add(3, createEndSessionCommand());
			
			RestClientConnector.initialize();
			RestClientConnector connector = new RestClientConnector(url);
			
			BatchResponse response = connector.executeBatch(sessionId, cmds.toArray(new Command[0]), null, null);
			return response;
		}
	
	/**

	/**
	 * permet d'ouvrir une session avec des parametres prédefini. 
	 * @param icName 
	 * @return cmd commande
	 * @throws JSONException
	 */
	private static Command createStartSessionCommand(String icName) throws JSONException {
		CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_STARTSESSION);
		cmd.setInteractiveChannel(icName);
		cmd.setAudienceLevel("customer");
		cmd.setAudienceID(new NameValuePairImpl[] {new NameValuePairImpl("customerid", NameValuePair.DATA_TYPE_NUMERIC, Double.valueOf("114"))});
		return cmd;
	}
	
	/**
	 * permet d'ouvrir une session avec des parametres précis.
	 * @param icName nom du canal interactif
	 * @param audianceLevel l'audiance level
	 * @param audianceID l'id de l'audience
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createStartSessionCommandComplete(String icName, String audianceLevel, Double audianceID)throws JSONException{
		CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_STARTSESSION);
		cmd.setInteractiveChannel(icName);
		cmd.setAudienceID(new NameValuePairImpl[] {new NameValuePairImpl("customerid", NameValuePair.DATA_TYPE_NUMERIC, audianceID)});
		cmd.setAudienceLevel(audianceLevel);
		NameValuePairImpl[] eventParameters = {new NameValuePairImpl("LANG_PREF", NameValuePair.DATA_TYPE_STRING, "FR"), new NameValuePairImpl("CTX_PAGE", NameValuePair.DATA_TYPE_STRING, "shop")};
		cmd.setEventParameters(eventParameters);
		cmd.setRelyOnExistingSession(false);
		cmd.setDebug(true);
		return cmd;
	}
	
	/**
	 * Recupere les offres.
	 * @param ipName nom du point d'interaction
	 * @param numberRequested nombre de requete d'offre
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createGetOffersCommand(String ipName, int numberRequested) throws JSONException {
		CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_GETOFFERS);
		cmd.setInteractionPoint(ipName);
		cmd.setNumberRequested(numberRequested);
		return cmd;
	}

	/**
	 * permet de recuperer un profil.
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createGetProfileCommand() throws JSONException {
		CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_GETPROFILE);
		return cmd;
	}
	
	/**
	 * permet de fermer la session.
	 * @return cmd
	 * @throws JSONException
	 */
	private static Command createEndSessionCommand() throws JSONException {
		CommandImpl cmd = new CommandImpl();
		cmd.setMethodIdentifier(Command.COMMAND_ENDSESSION);
		return cmd;
	}
}