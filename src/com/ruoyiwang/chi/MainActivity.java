package com.ruoyiwang.chi;

import java.util.ArrayList;
import com.ruoyiwang.chi.R;
import com.ruoyiwang.chi.model.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ChiRegion crUwPlaza;
	//generates the list of restaurants in university plaza beside uWaterloo
	private ArrayList<ChiRestaurant> getListOfPlacesToEat() {
		ArrayList<ChiRestaurant> vsListOfPlacesToEat = new ArrayList<ChiRestaurant>(1);
		vsListOfPlacesToEat.add(new ChiRestaurant("Sweet Dreams Tea Shop",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Curry in a Hurry",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Harveys",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Shandiz Persian Cuisine",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("East Side Mario's",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("McGinnis FrontRow Restaurant",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("The Grill",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Vegitarian Fastfood Restaurant",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Kismet Retaurant",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Home Garden 台湾小吃",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("蜀留香 China Legend",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Mickey's Eatery",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Subway",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Da Won",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Campus Pizza",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Mr. Panino's Beijing House 北京小厨",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Chen's Restaurant 橙子餐厅",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Seoul Soul",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Phat Cat",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("William's Coffee Pub",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Pita Factory",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Panda King",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Grab-a-Greek",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Waterloo Star 同德园",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Bubble Tease",""));
		vsListOfPlacesToEat.add(new ChiRestaurant("Sogo美食",""));
		return vsListOfPlacesToEat;
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
	}

	public void getNewRestaurant(View view) {
		ChiRestaurant crRandomRestaurant = this.crUwPlaza.getRandomRestaurant();

		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(crRandomRestaurant.name());
	}
}
