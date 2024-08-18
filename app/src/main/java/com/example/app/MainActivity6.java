package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;

public class MainActivity6 extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor heartRateSensor;
    private Sensor oxygenSensor;

    public static final String Name = "Name";
    public  static  final String ID="ID";

TextView nameText;
String name;
int id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the navigation bar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Set your content view
        setContentView(R.layout.activity_main6);
        nameText=findViewById(R.id.nameText);
        Intent i = getIntent();
        name=i.getStringExtra(Name);
        id=i.getIntExtra(ID,-1);
        nameText.setText(name);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        //oxygenSensor = sensorManager.getDefaultSensor(Sensor.TYPE_OXYGEN_SATURATION);

        sensorManager.registerListener(sensorEventListener, heartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
       // sensorManager.registerListener(sensorEventListener, oxygenSensor, SensorManager.SENSOR_DELAY_NORMAL);


    }
    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
                float heartRate = event.values[0];
                // Send heart rate to the server
                sendToServer("heartRate", heartRate);
            } /*else if (event.sensor.getType() == Sensor.TYPE_OXYGEN_SATURATION) {
                float oxygenLevel = event.values[0];
                // Send oxygen level to the server
                sendToServer("oxygenLevel", oxygenLevel);
            }*/
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };
    private void sendToServer(String type, float value) {
        // Implement network call to send data to server
    }

    public void med_page(View view) {
        Intent in = new Intent(this, MainActivity7.class);
        startActivity(in);
    }

    public void account(View view) {
        Intent in = new Intent(this, MainActivity9.class);
        in.putExtra(MainActivity9.ID1,id);
        startActivity(in);
    }
}