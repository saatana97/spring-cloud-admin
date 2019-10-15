package cn.saatana.entity;

import lombok.Data;

@Data
public class AuthorizationInformation {
	private String sessionId;
	private String token;
	private Authorize auth;

	public AuthorizationInformation() {
	}

	public AuthorizationInformation(String token, String sessionId, Authorize auth) {
		this.token = token;
		this.sessionId = sessionId;
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "sessionId=" + sessionId + ", token=" + token + ", auth=" + auth.getUsername();
	}

}
