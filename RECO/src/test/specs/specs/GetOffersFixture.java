package specs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.json.JSONArray;
import org.apache.commons.json.JSONException;
import org.apache.commons.json.JSONObject;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class GetOffersFixture {
	private static final String URI = "http://localhost:8080/RECO/";
	private static final String PATH_BOUCHON = "D:/Projets/RECO/workspaces/ReposRECO/RECO/RECO/src/main/resources/bouchons/bouchon_eureka_startsession_client.json";

	/**
	 *
	 * Retourne le nombre d'offres dans la reponse.
	 *
	 * @param _param
	 * @return
	 * @throws HttpException
	 * @throws JSONException
	 * @throws IOException
	 */
	public int getNbAttOffers(final String _param) throws HttpException,
			JSONException, IOException {
		final JSONArray json = new JSONArray(this.getPOSTResult(_param)
				.getResponseBodyAsString());
		int size = 0;
		if (json.size() > 1) {
			// on recupere le nom de l'objet JSON (normalement "offres") mais en
			// recuperant le nom direct on evite d'avoir des erreurs
			final String name = JSONObject.getNames(json.getJSONObject(0))[0];
			size = json.getJSONObject(0).getJSONArray(name).size();
		}
		return size;
	}

	/**
	 *
	 * Retourne le nombre d'offres dans la reponse.
	 *
	 * @param _param
	 * @return
	 * @throws HttpException
	 * @throws JSONException
	 * @throws IOException
	 */
	public int getNbOffers(final String _param) throws HttpException,
			JSONException, IOException {
		final JSONArray json = new JSONArray(this.getPOSTResult(_param)
				.getResponseBodyAsString());
		return json.size();
	}

	/**
	 * retourne la liste contenant les attributs d'offres
	 *
	 * @param _param
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public List<String> getOffersAttributs(final String _param)
			throws JSONException, IOException {

		final JSONArray json = new JSONArray(this.getPOSTResult(_param)
				.getResponseBodyAsString());

		final List<String> listeAttributs = new ArrayList<String>();
		if (json.size() > 1) {
			// on recupere le nom de l'objet JSON (normalement "offres") mais en
			// recuperant le nom direct on evite d'avoir des erreurs
			final String name = JSONObject.getNames(json.getJSONObject(0))[0];
			final JSONArray jsonArray = json.getJSONObject(0)
					.getJSONArray(name);
			for (final Iterator<JSONObject> iterator = jsonArray.iterator(); iterator
					.hasNext();) {
				final JSONObject jsonObj = iterator.next();
				listeAttributs.add(jsonObj.getString("name"));
			}
		} else {

		}
		return listeAttributs;
	}

	/**
	 * retourne la réponse de la requette POST http.
	 *
	 * @param _param
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @throws JSONException
	 */
	public PostMethod getPOSTResult(final String _param) throws HttpException,
			IOException, JSONException {
		final HttpClient client = new HttpClient();

		final PostMethod methode = new PostMethod(URI + _param);
		methode.addRequestHeader("Content-Type", "application/json");

		// on recupere le fichier JSON que l'on passe en String
		final InputStream leBouchonStream = new FileInputStream(PATH_BOUCHON);
		final JSONObject bouchonJson = new JSONObject(leBouchonStream);
		final String bouString = bouchonJson.toString();

		// on creer un StringRequestEntity qui permet d'envoyer le flux Json a
		// la requete.
		final StringRequestEntity requestEntity = new StringRequestEntity(
				bouString, "application/json", "UTF-8");
		methode.setRequestEntity(requestEntity);
		client.executeMethod(methode);

		return methode;
	}

	/**
	 * retourne le status de la reponse HTTP (ie : HTTP/1.1 200 OK)
	 *
	 * @param _param
	 *            string :
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public String getStatus(final String _param) throws JSONException,
			IOException {
		return this.getPOSTResult(_param).getStatusLine().toString();
	}
}