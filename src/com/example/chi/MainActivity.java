package com.example.chi;

import java.util.Vector;
import java.lang.Math;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Vector<String> getListOfPlacesToEat(){
    	Vector<String> vsListOfPlacesToEat = new Vector<String>(1);
    	vsListOfPlacesToEat.addElement("Sogo√¿ ≥");			//English and Chinese mixed
    	vsListOfPlacesToEat.addElement("Waterloo Star");	//English only
    	vsListOfPlacesToEat.addElement(" Ò¡Ùœ„");			//Chinese only
    	return vsListOfPlacesToEat;
    }
    private Vector<String>vsListOfPlacesToEat = this.getListOfPlacesToEat();
    private String getNewRandomRestaurant(){
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
    
    public void getNewRestaurant(View view){
    	String sNewRandomRestaurant = this.getNewRandomRestaurant();
    	
        TextView textView = (TextView) findViewById(R.id.tvMainOutput);
        textView.setText(sNewRandomRestaurant);    	
    }
}
