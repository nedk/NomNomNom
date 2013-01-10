package com.ruoyiwang.chi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ruoyiwang.chi.model.ChiRegion;
import com.ruoyiwang.chi.model.ChiRestaurant;

public class MainActivity extends Activity {
	private ChiRegion crUwPlaza;
	private SensorManager mSensorManager;
	private float mAccel; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity
	private long fLastShakeTime = 0;
	
	//generates the list of restaurants in university plaza beside uWaterloo
	private ArrayList<ChiRestaurant> getListOfPlacesToEat() {
		ArrayList<ChiRestaurant> alListOfPlacesToEat = new ArrayList<ChiRestaurant>(1);
		alListOfPlacesToEat.add(new ChiRestaurant("Sweet Dreams Tea Shop",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Curry in a Hurry",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Harveys",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Shandiz Persian Cuisine",""));
		alListOfPlacesToEat.add(new ChiRestaurant("East Side Mario's",""));
		alListOfPlacesToEat.add(new ChiRestaurant("McGinnis FrontRow Restaurant",""));
		alListOfPlacesToEat.add(new ChiRestaurant("The Grill",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Vegitarian Fastfood Restaurant",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Kismet Retaurant",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Home Garden 台湾小吃",""));
		alListOfPlacesToEat.add(new ChiRestaurant("蜀留香 China Legend",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Mickey's Eatery",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Subway",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Da Won",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Campus Pizza",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Mr. Panino's Beijing House 北京小厨",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Chen's Restaurant 橙子餐厅",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Seoul Soul",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Phat Cat",""));
		alListOfPlacesToEat.add(new ChiRestaurant("William's Coffee Pub",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Pita Factory",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Panda King",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Grab-a-Greek",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Waterloo Star 同德园",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Bubble Tease",""));
		alListOfPlacesToEat.add(new ChiRestaurant("Sogo美食",""));
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
		//startActivity(intent);
		
		/* do this in onCreate */
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
		mAccelLast = SensorManager.GRAVITY_EARTH;
	}

	public void getNewRestaurant(View view) {
		ChiRestaurant crRandomRestaurant = this.crUwPlaza.getRandomRestaurant();
		TextView textView = (TextView) findViewById(R.id.tvMainOutput);
		textView.setText(crRandomRestaurant.name());
	}

	private final SensorEventListener mSensorListener = new SensorEventListener() {
		public void onSensorChanged(SensorEvent se) {
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2];
			mAccelLast = mAccelCurrent;
			mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
			float delta = mAccelCurrent - mAccelLast;
			mAccel = mAccel * 0.9f + delta; // perform low-cut filter
			long fCurTime = System.currentTimeMillis();
			if (mAccel > 2 && (fCurTime - fLastShakeTime) > 250){
				//this "1" a temp value, because we don't know what yet )=
				TextView textView = (TextView) findViewById(R.id.tvMainOutput);
				fLastShakeTime = fCurTime;
				getNewRestaurant(textView);
			}
		}

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mSensorListener);
		super.onPause();
	}
}
