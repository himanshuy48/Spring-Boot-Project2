package com.digi.uniprr.enums;

import java.io.Serializable;

public enum YNStatus implements Serializable {
	Yes("Yes"), No("No");

	private String action;

	public String getAction() {
		return this.action;
	}

	private YNStatus(String action) {
		this.action = action;
	}

}
