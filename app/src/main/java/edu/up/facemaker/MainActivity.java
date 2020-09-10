//@author Ryan Brown
//@version 9/7/2020

package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String hairStyles[] = {"buzz", "long", " longer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner hStyle = findViewById(R.id.hairStyle);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        hStyle.setAdapter(hairAdapter);
        Face face = new Face();
    }

}