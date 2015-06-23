/**
 *
 */
package specs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.json.JSONException;
import org.apache.commons.json.JSONObject;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 * @author pgauchy
 *
 */
@RunWith(ConcordionRunner.class)
public class StartSessionFixture {
	private static final String URI = "http://localhost:8080/RECO/";
	private static final String PATH_BOUCHON = "D:/Projets/RECO/workspaces/ReposRECO/RECO/RECO/src/main/resources/bouchons/bouchon_eureka_startsession_client.json";

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
