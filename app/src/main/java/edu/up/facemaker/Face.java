// @author Ryan Brown
// @version 9/9/2020

package edu.up.facemaker;

import java.util.Random;
import android.graphics.Color;
import android.util.Log;

public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face() {
        randomize();
    }

    public void randomize()
    {
        Random rnd = new Random(); //create random object for color creation
        skinColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)); //set random argb color skinColor
        eyeColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)); //set random argb color eyeColor
        hairColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)); //set random argb color hairColor
        hairStyle = rnd.nextInt(3); //set random hairStyle to value between 0-3 for corresponding hairstyles
        Log.v("Debug1", "print " + skinColor + " " + eyeColor + " " + hairColor + " " + hairStyle); //check if randomized
    }
}
