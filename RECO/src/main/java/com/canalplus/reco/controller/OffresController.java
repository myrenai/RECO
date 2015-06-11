package com.canalplus.reco.controller;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.reco.model.Context;
import com.canalplus.reco.model.Offres;
import com.canalplus.reco.model.Parametres;
import com.canalplus.reco.model.Profil;
import com.canalplus.reco.model.Resultat;
import com.canalplus.reco.service.ServiceOffres;
import com.canalplus.reco.interactclient.InteractRestClient;

@RestController
@RequestMapping("/V1/Offers")
public class OffresController {

	/**
	 * Récupération des offres avec ou sans pré-calcul.
	 * Profil et context au format JSON + Token d'authentification.
	 * @param context exemple de bouchon 
	 * {
		"profil": [
		  {"profilID":"0000048"},
		  {"profilID":"0000049"},
		  {"profilID":"0000067"}
		  ],
		"context":[
		 {
		    "name": "name1",
		    "value": "value1",
		    "dataType": "datatype1"
		  },
		  {
		    "name": "name2",
		    "value": "value2",
		    "dataType": "datatype2"
		  },
		  {
		    "name": "name3",
		    "value": "value3",
		    "dataType": "datatype3"
		  },
		   {
		    "name": "name4",
		    "value": "value4",
		    "dataType": "datatype4"}
		  ]
		
	}
	 * @param token
	 * @return offres
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "/next", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Offres getOffres(@RequestBody Parametres parametres)
			throws JSONException, IOException {
		InteractRestClient interactRestClient = new InteractRestClient();
		ServiceOffres serviceoffres = new ServiceOffres();
		Offres offre = serviceoffres.getOffres(interactRestClient.getResponse());
			return offre;
	}

	/**
	 * Pré-calcul des offres.
	 * Profil et context au format JSON + Token d'authentification.
	 * @param context 
	 * {
		"profil": [
		  {"profilID":"0000048"},
		  {"profilID":"0000049"},
		  {"profilID":"0000067"}
		  ],
		"context":[
		 {
		    "name": "name1",
		    "value": "value1",
		    "dataType": "datatype1"
		  },
		  {
		    "name": "name2",
		    "value": "value2",
		    "dataType": "datatype2"
		  },
		  {
		    "name": "name3",
		    "value": "value3",
		    "dataType": "datatype3"
		  },
		   {
		    "name": "name4",
		    "value": "value4",
		    "dataType": "datatype4"}
		  ]
		
	}
	 * @param token
	 * @return resultat boolean
	 */
	@RequestMapping(value ="/context", method = RequestMethod.POST)
	public Resultat precalculOffre
//	(@RequestParam(value="context")Context context, @RequestParam(value="token") String token) 
	(@RequestBody Parametres entry)
	{
		return new Resultat(true);
	}
	
	/**
	 * Modification de l'état d'une offre.
	 * Offres avec nouvel état au format JSON + Token d'authentification. 
	 * @param offres
	 * @param token
	 * @return offre
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value ="/results", method = RequestMethod.POST)
	public Offres getResults(@RequestBody Context context) throws JSONException, IOException{
		InteractRestClient interactRestClient = new InteractRestClient();
		ServiceOffres serviceoffres = new ServiceOffres();
		Offres offre = serviceoffres.getOffres(interactRestClient.getResponse());
			return offre;
	}
	
	/**
	 * Validation.
	 * Offres à valider avec informations complémentaires utiles aux actes de gestion.
	 * @param offres
	 * @return
	 */
	@RequestMapping(value ="/validate", method = RequestMethod.POST)
	public Resultat validateOffre(@RequestBody Offres offres){
		if(offres != null){
			return new Resultat(true);
		}else {
			return new Resultat(false);
		}
	}
	
	
	
	
}