package com.app.controller;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestTemplate;

public class AbstractGenericController {

	@Autowired
	protected RestTemplate restTemplate;
	
	/** Logger available to subclasses. */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected ResourceLoader resourceLoader;
	
	//protected static final String USER_SERVICE_HOST = "url.service.user";
	protected static final String API_GATEWAY_HOST = "url.api.gateway";
	//protected static final String SOCIAL_AUTHSERVICE = "url.authservice.social";
	
	public String getPropValue(String key) throws IOException {
		Properties props = new Properties();
		try {
			Resource resource = resourceLoader.getResource("classpath:application.properties");
			props.load(resource.getInputStream());
			return props.getProperty(key);
		}catch(IOException ie) {
			throw ie;
		}
	}
}
