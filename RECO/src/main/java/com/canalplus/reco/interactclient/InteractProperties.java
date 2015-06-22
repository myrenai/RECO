package com.canalplus.reco.interactclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InteractProperties {

	@Value("${reco.interact.url}")
	private String url;

	@Value("${reco.inetract.ipName}")
	private String ipName;

	@Value("${reco.interact.audienceLevel}")
	private String audianceLevel;

	@Value("${reco.interact.numberRequested}")
	private String numberRequested;

	public InteractProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the audianceLevel
	 */
	public String getAudianceLevel() {
		return this.audianceLevel;
	}

	/**
	 * @return the ipName
	 */
	public String getIpName() {
		return this.ipName;
	}

	/**
	 * @return the numberRequested
	 */
	public String getNumberRequested() {
		return this.numberRequested;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

}
