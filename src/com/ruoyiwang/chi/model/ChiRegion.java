package com.ruoyiwang.chi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ChiRegion implements Serializable {
	private String sName;
	private String sRegiionType;
	private ArrayList<ChiRestaurant> alResturants;
	private ArrayList<ChiRestaurant> alResturantsFiltered;
	private Map<String, Integer> hmResturantTypes = new TreeMap<String, Integer>();
	
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
		List<ChiRestaurant> lRestautrantSet = alResturants;
		
		if(alResturantsFiltered != null)
			lRestautrantSet = alResturantsFiltered;
			
		int iRegionSize = lRestautrantSet.size();
		int iKey = (int)(Math.random() * iRegionSize);
		
		return lRestautrantSet.get(iKey);
	}
	
	public Iterator<Entry<String, Integer>> getRestaurantTypeAndCounts(){
		return hmResturantTypes.entrySet().iterator();
	}
	
	public void filterRestaurants(List<String> lResTags){
		if(lResTags.size() == 0)
			alResturantsFiltered = null;
		else{
			alResturantsFiltered = new ArrayList<ChiRestaurant>();
			for(ChiRestaurant restaurant : alResturants){
				List<String> restTyps = restaurant.getTypes();
				for(String tag : lResTags){
					if(restTyps.contains(tag)){
						alResturantsFiltered.add(restaurant);
						break;
					}
				}
			}
		}
		
	}
}
