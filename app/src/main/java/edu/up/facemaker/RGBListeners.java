package edu.up.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup;


public class RGBListeners implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, Button.OnClickListener, Spinner.OnItemSelectedListener {

    //set instance variables
    private EditText rVal;
    private EditText bVal;
    private EditText gVal;
    private SeekBar rSeekbar;
    private SeekBar bSeekbar;
    private SeekBar gSeekbar;
    private RadioGroup radioGroup;
    private Spinner hairSpinner;

    private FaceModel faceModel;
    private Face faceView;

    public RGBListeners(Face faceView, EditText rVal, EditText bVal, EditText gVal, SeekBar rSeekbar,
                            SeekBar bSeekBar, SeekBar gSeekbar, RadioGroup radioGroup, Spinner hairSpinner) { //constructor to set values of all instance variables
        this.faceView = faceView;
        this.faceModel = this.faceView.getFaceModel();
        this.rVal = rVal;
        this.bVal = bVal;
        this.gVal = gVal;
        this.rSeekbar = rSeekbar;
        this.bSeekbar = bSeekBar;
        this.gSeekbar = gSeekbar;
        this.radioGroup = radioGroup;
        this.hairSpinner = hairSpinner;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { //when seekBar moves, update progress
        if(fromUser) {
            int i = radioGroup.getCheckedRadioButtonId();
            switch (seekBar.getId()) { //check which seekBar is being updated
                case R.id.redSeekbar:
                    switch(i) { //check which RadioButton is selected, update corresponding value with seekBar progress
                        case R.id.hair:
                            faceModel.hairColorR = progress;
                            break;
                        case R.id.eyes:
                            faceModel.eyeColorR = progress;
                            break;
                        case R.id.skin:
                            faceModel.skinColorR = progress;
                    }
                    break;
                case R.id.blueSeekbar:
                    switch(i) {
                        case R.id.hair:
                            faceModel.hairColorB = progress;
                            break;
                        case R.id.eyes:
                            faceModel.eyeColorB = progress;
                            break;
                        case R.id.skin:
                            faceModel.skinColorB = progress;
                    }
                    break;
                case R.id.greenseekBar:
                    switch(i) {
                        case R.id.hair:
                            faceModel.hairColorG = progress;
                            break;
                        case R.id.eyes:
                            faceModel.eyeColorG = progress;
                            break;
                        case R.id.skin:
                            faceModel.skinColorG = progress;
                    }
                    break;
            }
            updateViews(i); //after change, update the view
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //not needed
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not needed
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        updateViews(i);
    } // only need to update the view to show changed values of seekbars and numviews

    protected void updateViews(int i) {
        //Log.d("UPDATEVIEWS", "updateViews is called");
        switch (i) {
            case R.id.hair: //hair
                rVal.setText("" +faceModel.hairColorR);
                rSeekbar.setProgress(faceModel.hairColorR);
                bVal.setText("" +faceModel.hairColorB);
                bSeekbar.setProgress(faceModel.hairColorB);
                gVal.setText("" +faceModel.hairColorG);
                gSeekbar.setProgress(faceModel.hairColorG);
                break;
            case R.id.eyes: //eyes
                rVal.setText("" +faceModel.eyeColorR);
                rSeekbar.setProgress(faceModel.eyeColorR);
                bVal.setText("" +faceModel.eyeColorB);
                bSeekbar.setProgress(faceModel.eyeColorB);
                gVal.setText("" +faceModel.eyeColorG);
                gSeekbar.setProgress(faceModel.eyeColorG);
                break;
            case R.id.skin: //skin
                rVal.setText("" +faceModel.skinColorR);
                rSeekbar.setProgress(faceModel.skinColorR);
                bVal.setText("" +faceModel.skinColorB);
                bSeekbar.setProgress(faceModel.skinColorB);
                gVal.setText("" +faceModel.skinColorG);
                gSeekbar.setProgress(faceModel.skinColorG);
                break;
        }
        hairSpinner.setSelection(faceModel.hairStyle);
        faceView.invalidate();
    }
    @Override
    public void onClick(View view) { //only one button, so only one action
        faceView.randomize(); //randomize all fields of the faceView
        updateViews(radioGroup.getCheckedRadioButtonId());
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        faceModel.hairStyle = i; // update hairStyle value to change hairStyle on face
        updateViews(radioGroup.getCheckedRadioButtonId());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //not needed, default set
    }
}
