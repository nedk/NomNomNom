package com.ruoyiwang.chi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChiRestaurant implements Serializable{
	private String sName;
	private String sAddress;
	private List<String> sTypes = new ArrayList<String>();

	public ChiRestaurant(String sName, String sAddress, String... types){
		this.sName = sName;
		this.sAddress = sAddress;
		
		for(String type : types){
			sTypes.add(type);
		}
	}
	
	protected void setRestaurantName(String sName){
		this.sName = sName;
	}
	public String getRestaurantName(){
		return this.sName;
	}
	public String name(){
		return this.sName;
	}
	public String getAddress() {
		return sAddress;
	}
	public void setAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public List<String> getTypes() {
		return sTypes;
	}
	public void setTypes(List<String> sTypes) {
		this.sTypes = sTypes;
	}

}