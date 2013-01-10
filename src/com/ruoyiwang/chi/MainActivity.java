package com.ruoyiwang.chi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruoyiwang.chi.model.ChiRegion;
import com.ruoyiwang.chi.model.ChiRestaurant;
import com.ruoyiwang.chi.view.ChiTagView;

public class MainActivity extends Activity {
	private ChiRegion crUwPlaza;
	//generates the list of restaurants in university plaza beside uWaterloo
	private ArrayList<ChiRestaurant> getListOfPlacesToEat() {
		ArrayList<ChiRestaurant> alListOfPlacesToEat = new ArrayList<ChiRestaurant>(10);
		alListOfPlacesToEat.add(new ChiRestaurant("Sweet Dreams Tea Shop","", "Bubble Tea", "Asian"));
		alListOfPlacesToEat.add(new ChiRestaurant("Curry in a Hurry","", "India"));
		alListOfPlacesToEat.add(new ChiRestaurant("Harveys","", "Fast Food", "Burgers", "Grill"));
		alListOfPlacesToEat.add(new ChiRestaurant("Shandiz Persian Cuisine",""));
		alListOfPlacesToEat.add(new ChiRestaurant("East Side Mario's","", "Italian"));
		alListOfPlacesToEat.add(new ChiRestaurant("McGinnis FrontRow Restaurant","", "American"));
		alListOfPlacesToEat.add(new ChiRestaurant("The Grill","", "Grill"));
		alListOfPlacesToEat.add(new ChiRestaurant("Vegitarian Fastfood Restaurant","", "Vegetarian"));
		alListOfPlacesToEat.add(new ChiRestaurant("Kismet Retaurant",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Home Garden 台湾小吃","", "Chinese", "Taiwanese"));
		alListOfPlacesToEat.add(new ChiRestaurant("蜀留香 China Legend","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Mickey's Eatery","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Subway","", "Sandwich"));
		alListOfPlacesToEat.add(new ChiRestaurant("Da Won","", "Korean"));
		alListOfPlacesToEat.add(new ChiRestaurant("Campus Pizza","", "Pizza"));
		alListOfPlacesToEat.add(new ChiRestaurant("Mr. Panino's Beijing House 北京小厨","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Chen's Restaurant 橙子餐厅","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Seoul Soul","", "Korean"));
		alListOfPlacesToEat.add(new ChiRestaurant("Phat Cat","", "Middle Eastern"));
		alListOfPlacesToEat.add(new ChiRestaurant("William's Coffee Pub","", "Cafes"));
		alListOfPlacesToEat.add(new ChiRestaurant("Pita Factory",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Panda King","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Grab-a-Greek","", "Greek"));
		alListOfPlacesToEat.add(new ChiRestaurant("Waterloo Star 同德园","", "Chinese"));
		alListOfPlacesToEat.add(new ChiRestaurant("Bubble Tease","", "Chinese", "Bubble Tea"));
		alListOfPlacesToEat.add(new ChiRestaurant("Sogo美食","", "Chinese", "Dim Sum"));
		return alListOfPlacesToEat;
	}
	private void loadUWRegion(){
		ChiRegion crUwPlaza = new ChiRegion("University Plaza", "plaza", getListOfPlacesToEat());
		this.crUwPlaza = crUwPlaza;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.loadUWRegion();
		String message = "Click the button below to get a random restaurant!";
		// Create the text view
		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(message);
		
		ChiTagView filterLayout = (ChiTagView) findViewById(R.id.filterTags);
		LayoutInflater li = getLayoutInflater();
		
		for(Iterator<Entry<String,Integer>> it = crUwPlaza.getRestaurantTypeAndCounts(); it.hasNext(); ){
			Entry<String,Integer> entry = it.next();
			
			TextView tagView = ChiTagView.createChiTag(entry.getKey(), entry.getValue());
			
			filterLayout.setTag(tagView);
		}
		filterLayout.flush();
		
	}

	public void getNewRestaurant(View view) {
		ChiTagView filterLayout = (ChiTagView) findViewById(R.id.filterTags);
		this.crUwPlaza.filterRestaurants(filterLayout.getAllSelectedTags());
		
		ChiRestaurant crRandomRestaurant = this.crUwPlaza.getRandomRestaurant();

		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(crRandomRestaurant.name());
		
		LinearLayout vTagLayout = (LinearLayout) findViewById(R.id.lltagLayout);
		vTagLayout.removeAllViews();
		LayoutInflater li = getLayoutInflater();
		
		for (String type: crRandomRestaurant.getTypes()){
			TextView tagView = (TextView) li.inflate(R.layout.chi_tag, null);
			
			tagView.setText(type);
			vTagLayout.addView(tagView);
		}
		
	}
}
