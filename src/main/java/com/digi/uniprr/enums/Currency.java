package com.digi.uniprr.enums;

import java.io.Serializable;

public enum Currency implements Serializable{
	
	USD("USD"), GBP("GBP"), EURO("EURO"), INR("INR");
	
	private String action;
	
	private Currency(String action) {
		this.action = action;
	}

}
