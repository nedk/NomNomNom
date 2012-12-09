package com.ruoyiwang.chi.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ChiRegion {
	private String sName;
	private String sRegiionType;
	private ArrayList<ChiRestaurant> alResturants;
	private HashMap<String, Integer> hmResturantTypes = new HashMap<String, Integer>(10);
	
	public ChiRegion(String sName, String sType){
		this.sName = sName;
		this.sRegiionType = sType;
		this.alResturants = new ArrayList<ChiRestaurant>(1);
	}	
	public ChiRegion(String sName, String sType, ArrayList<ChiRestaurant> alResturants){
		this.sName = sName;
		this.sRegiionType = sType;
		this.alResturants = alResturants;
		
		for(ChiRestaurant res: alResturants)
			addRestaurantType(res);
	}
	
	private void addRestaurantType(ChiRestaurant crRes){
		for(String type: crRes.getTypes()){
			if(hmResturantTypes.containsKey(type)){
				Integer count = hmResturantTypes.get(type);
				hmResturantTypes.put(type, ++count);
			}
			else
				hmResturantTypes.put(type, 1);
		}
	}
	
	private void removeRestaurantTypes(ChiRestaurant crRes){
		for(String type: crRes.getTypes()){
			if(hmResturantTypes.containsKey(type)){
				Integer count = hmResturantTypes.get(type);
				hmResturantTypes.put(type, count--);
			}
		}
	}
	
	//accessor and manipulator of the region type
	public String getRegiionType() {
		return sRegiionType;
	}
	public void setRegiionType(String sRegiionType) {
		this.sRegiionType = sRegiionType;
	}
	//accessor and manipulator of this region name
	public String getName() {
		return sName;
	}
	public void setName(String sName) {
		this.sName = sName;
	}
	//accessor and manipulator of the list of restaurants in this region
	public ArrayList<ChiRestaurant> getResturants() {
		return alResturants;
	}
	public void setResturants(ArrayList<ChiRestaurant> alResturants) {
		this.alResturants = alResturants;
	}
	//add and remove restaurants in this region
	public Boolean addRestaurants(ChiRestaurant crRes){
		Boolean bSuccess = this.alResturants.add(crRes);
		addRestaurantType(crRes);
		return bSuccess;
	}
	public Boolean removeRestaurants(ChiRestaurant crRes){
		Boolean bSuccess = this.alResturants.remove(crRes);
		return bSuccess;
	}
	//get a random restaurant in this region
	public ChiRestaurant getRandomRestaurant(){
		int iRegionSize = this.alResturants.size();
		int iKey = (int)(Math.random() * iRegionSize);
		
		return this.alResturants.get(iKey);
	}
}
