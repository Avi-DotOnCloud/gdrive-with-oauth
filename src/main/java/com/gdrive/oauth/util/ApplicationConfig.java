package com.gdrive.oauth.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class ApplicationConfig {

	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;

	@Value("${google.secret.key.path}")
	private String driveSecretKeys;

	@Value("${google.credentials.folder.path}")
	private String credentialsFolder;

	@Value("${myapp.temp.path}")
	private String temporaryFolder;

	public String getCALLBACK_URI() {
		return CALLBACK_URI;
	}

	public void setCALLBACK_URI(String CALLBACK_URI_p) {
		CALLBACK_URI = CALLBACK_URI_p;
	}

	public ClassPathResource getDriveSecretKeys() {
		return new ClassPathResource("driveSecretKeys");
	}

	public void setDriveSecretKeys(String driveSecretKeys) {
		this.driveSecretKeys = driveSecretKeys;
	}

	public ClassPathResource getCredentialsFolder() {
		return new ClassPathResource("credentialsFolder");
	}

	public void setCredentialsFolder(String credentialsFolder) {
		this.credentialsFolder = credentialsFolder;
	}

	public String getTemporaryFolder() {
		return temporaryFolder;
	}

	public void setTemporaryFolder(String temporaryFolder) {
		this.temporaryFolder = temporaryFolder;
	}

}
