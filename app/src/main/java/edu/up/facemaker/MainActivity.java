//@author Ryan Brown
//@version 9/7/2020

package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String hairStyles[] = {"mohawk", "comb-over", "bald"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    protected void init() {
        Face face = findViewById(R.id.faceView);
        Spinner hStyle = findViewById(R.id.hairStyle);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        hStyle.setAdapter(hairAdapter);

        SeekBar rBar = findViewById(R.id.redSeekbar);
        SeekBar bBar = findViewById(R.id.blueSeekbar);
        SeekBar gBar = findViewById(R.id.greenseekBar);

        EditText rNum = findViewById(R.id.rNum);
        EditText bNum = findViewById(R.id.bNum);
        EditText gNum = findViewById(R.id.gNum);

        RadioGroup radioGroup = findViewById(R.id.selectAttr);

        RGBListeners listener = new RGBListeners(face, rNum, bNum, gNum, rBar, bBar, gBar, radioGroup, hStyle);

        rBar.setOnSeekBarChangeListener(listener);
        bBar.setOnSeekBarChangeListener(listener);
        gBar.setOnSeekBarChangeListener(listener);

        radioGroup.setOnCheckedChangeListener(listener);

        Button random = findViewById(R.id.randButton);
        random.setOnClickListener(listener);

        hStyle.setOnItemSelectedListener(listener);

        listener.updateViews(radioGroup.getCheckedRadioButtonId()); //have default values show on launch
    }
}