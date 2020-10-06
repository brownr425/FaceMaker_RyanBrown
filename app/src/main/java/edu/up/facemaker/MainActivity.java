//@author Ryan Brown
//@version 9/7/2020

package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
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

        SeekBar rBar = findViewById(R.id.redSeekbar);
        SeekBar bBar = findViewById(R.id.blueSeekbar);
        SeekBar gBar = findViewById(R.id.greenseekBar);

        EditText rNum = findViewById(R.id.rNum);
        EditText bNum = findViewById(R.id.bNum);
        EditText gNum = findViewById(R.id.gNum);

        RGBListeners listener = new RGBListeners(rNum, bNum, gNum, rBar, bBar, gBar);

        rBar.setOnSeekBarChangeListener(listener);
        bBar.setOnSeekBarChangeListener(listener);
        gBar.setOnSeekBarChangeListener(listener);
        rNum.setOnEditorActionListener(listener);
        bNum.setOnEditorActionListener(listener);
        gNum.setOnEditorActionListener(listener);
    }

}