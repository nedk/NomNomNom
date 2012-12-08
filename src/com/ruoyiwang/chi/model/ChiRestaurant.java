package com.ruoyiwang.chi.model;

public class ChiRestaurant{
	private String sName;
	private String sAddress;
	
	protected void setRestaurantName(String sName){
		this.sName = sName;
	}
	protected String getRestaurantName(){
		return this.sName;
	}
	public String getAddress() {
		return sAddress;
	}
	public void setAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public ChiRestaurant(String sName, String sAddress){
		this.sName = sName;
		this.sAddress = sAddress;
	}
}