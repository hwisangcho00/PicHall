package com.web7.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("gimminjoo2126@gmail.com", "giovoa186205!");
	}
	
	

}
