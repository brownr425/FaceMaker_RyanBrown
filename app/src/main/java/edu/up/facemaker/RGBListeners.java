package edu.up.facemaker;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioGroup;

public class RGBListeners implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, TextView.OnEditorActionListener {

    private EditText rVal;
    private EditText bVal;
    private EditText gVal;
    private SeekBar rSeekbar;
    private SeekBar bSeekbar;
    private SeekBar gSeekbar;
    private RadioGroup changes;

    public RGBListeners(EditText rVal, EditText bVal, EditText gVal,
                        SeekBar rSeekbar, SeekBar bSeekbar, SeekBar gSeekbar) { //constructor to set values of numberview and seekbar
        this.rVal = rVal;
        this.bVal = bVal;
        this.gVal = gVal;
        this.rSeekbar = rSeekbar;
        this.bSeekbar = bSeekbar;
        this.gSeekbar = gSeekbar;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser) {
            switch (seekBar.getId()) {
                case R.id.redSeekbar:
                    rVal.setText("" + progress);
                    break;
                case R.id.blueSeekbar:
                    bVal.setText("" + progress);
                    break;
                case R.id.greenseekBar:
                    gVal.setText("" + progress);
            }
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
        int adj = 1;

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        updateTexts(textView, 0);
        return true;
    }

    /**
     * helper method
     *
     *
     * @param src
     * @param adj - what amount to adjust value by
     */
    private void updateTexts(TextView src, int adj) { //all taken from Nux ;)
        CharSequence cs = src.getText();
        String strCurrVal = cs.toString();
        int currVal = Integer.parseInt(strCurrVal);
        int newVal = currVal + adj;
        switch(src.getId()) {
            case R.id.rNum:
                rVal.setText("" +newVal);
                break;
            case R.id.bNum:
                bVal.setText("" +newVal);
                break;
            case R.id.gNum:
                gVal.setText("" +newVal);
                break;
        }
    }
}
