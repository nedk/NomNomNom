package com.ruoyi.chi;

import java.util.ArrayList;

public class ChiRegion {
	private String sName;
	private String sRegiionType;
	private ArrayList<ChiRestaurant> alResturants = new ArrayList<ChiRestaurant>(1);
	
	public ChiRegion(String sName, String sType){
		this.sName = sName;
		this.sRegiionType = sType;
	}	
	public ChiRegion(String sName, String sType, ArrayList<ChiRestaurant> alResturants){
		this.sName = sName;
		this.sRegiionType = sType;
		this.alResturants = alResturants;
	}
	public String getRegiionType() {
		return sRegiionType;
	}
	public void setRegiionType(String sRegiionType) {
		this.sRegiionType = sRegiionType;
	}
	public String getName() {
		return sName;
	}
	public void setName(String sName) {
		this.sName = sName;
	}
	public ArrayList<ChiRestaurant> getResturants() {
		return alResturants;
	}
	public void setResturants(ArrayList<ChiRestaurant> alResturants) {
		this.alResturants = alResturants;
	}
	public Boolean addRestaurants(ChiRestaurant crRes){
		Boolean bSuccess = this.alResturants.add(crRes);
		return bSuccess;
	}
	public Boolean removeRestaurants(ChiRestaurant crRes){
		Boolean bSuccess = this.alResturants.remove(crRes);
		return bSuccess;
	}
}
