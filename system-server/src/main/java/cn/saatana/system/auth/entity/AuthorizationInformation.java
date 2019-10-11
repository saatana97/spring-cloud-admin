package cn.saatana.system.auth.entity;

import lombok.Data;

@Data
public class AuthorizationInformation {
	private String sessionId;
	private String token;
	private Authorizer auth;

	public AuthorizationInformation() {
	}

	public AuthorizationInformation(String token, String sessionId, Authorizer auth) {
		this.token = token;
		this.sessionId = sessionId;
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "sessionId=" + sessionId + ", token=" + token + ", auth=" + auth.getUsername();
	}

}
