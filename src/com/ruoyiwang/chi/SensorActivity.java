package com.ruoyiwang.chi;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SensorActivity extends Activity{
	private final SensorManager mSensorManager;
	private final Sensor mAccelerometer;
	private static final float NS2S = 1.0f / 1000000000.0f;
    private final float[] deltaRotationVector = new float[4];
    private float timestamp;

	public SensorActivity() {
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener((SensorEventListener) this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener((SensorListener) this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public void onSensorChanged(SensorEvent event)
	{
		// alpha is calculated as t / (t + dT)
		// with t, the low-pass filter's time-constant
		// and dT, the event delivery rate

		final float alpha = (float) 0.8;

		double[] gravity = {0,0,0};
		double[] linear_acceleration = {0,0,0};
		
		gravity[0] = alpha * mSensorManager.GRAVITY_EARTH + (1 - alpha) * event.values[0];
		gravity[1] = alpha * mSensorManager.GRAVITY_EARTH + (1 - alpha) * event.values[1];
		gravity[2] = alpha * mSensorManager.GRAVITY_EARTH + (1 - alpha) * event.values[2];

		linear_acceleration[0] = event.values[0] - gravity[0];
		linear_acceleration[1] = event.values[1] - gravity[1];
		linear_acceleration[2] = event.values[2] - gravity[2];
		
		if (linear_acceleration[0]>1 || linear_acceleration[1]>1 || linear_acceleration[2]>1 ){
			TextView textView = (TextView) findViewById(R.id.tvMainOutput);
			textView.setText("lalala");
		}
	}
}