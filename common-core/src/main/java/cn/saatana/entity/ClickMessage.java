package cn.saatana.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClickMessage extends BaseMessage {
	private String EventKey;

	public ClickMessage() {
	}

	public ClickMessage(String key) {
		this.EventKey = key;
	}
}
