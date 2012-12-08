package com.ruoyiwang.chi;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import com.ruoyiwang.chi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private List<String> getListOfPlacesToEat() {
		List<String> vsListOfPlacesToEat = new ArrayList<String>();
		vsListOfPlacesToEat.add("Sogo√¿ ≥"); // English and Chinese mixed
		vsListOfPlacesToEat.add("Waterloo Star"); // English only
		vsListOfPlacesToEat.add(" Ò¡Ùœ„"); // Chinese only
		return vsListOfPlacesToEat;
	}

	private List<String> vsListOfPlacesToEat = this.getListOfPlacesToEat();

	private String getNewRandomRestaurant() {
		int iListSize = this.vsListOfPlacesToEat.size();
		int iListKey = ((int) (Math.random() * iListSize));
		String sRandomRestaurant = vsListOfPlacesToEat.get(iListKey);
		return sRandomRestaurant;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String message = "Click the button below to get a random restaurant!";
		// Create the text view
		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(message);
	}

	public void getNewRestaurant(View view) {
		String sNewRandomRestaurant = this.getNewRandomRestaurant();

		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(sNewRandomRestaurant);
	}
}
