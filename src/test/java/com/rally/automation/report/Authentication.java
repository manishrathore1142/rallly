package com.rally.automation.report;

import javax.mail.PasswordAuthentication;

class Authentication extends javax.mail.Authenticator {

	private PasswordAuthentication authentication;

	public Authentication(String username, String password) {
		authentication = new PasswordAuthentication(username, password);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}
