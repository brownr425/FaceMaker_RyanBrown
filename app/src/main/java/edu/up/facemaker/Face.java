// @author Ryan Brown
// @version 9/9/2020

package edu.up.facemaker;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

public class Face extends SurfaceView {
    private FaceModel faceModel;

    //Paints for drawing each part of face
    Paint hairPaint = new Paint();
    Paint skinPaint = new Paint();
    Paint innerEyePaint = new Paint();
    Paint outerEyePaint = new Paint();
    Paint mouthPaint = new Paint();

    float faceMidH = 825.0f;
    float faceMidV = 725.0f;
    float faceWidth = 800.0f;
    float faceHeight = 950.0f;
    float moHeight = 500.0f;
    float moWidth = 250.0f;
    float eyeRad = 100.0f;
    float smallEyeRad = 50.0f;
    float mouthWidth = 300.0f;
    float mouthHeight = 50.0f;

    public Face(Context context, AttributeSet attrSet) {
        super(context,attrSet);

        faceModel = new FaceModel();

        randomize();

        //set up color palette
        setColors();
        hairPaint.setStyle(Paint.Style.FILL);
        skinPaint.setStyle(Paint.Style.FILL);
        innerEyePaint.setStyle(Paint.Style.FILL);
        outerEyePaint.setColor(Color.WHITE);
        outerEyePaint.setStyle(Paint.Style.FILL);
        mouthPaint.setColor(Color.BLACK);
        mouthPaint.setStyle(Paint.Style.FILL);

        setWillNotDraw(false);
        this.setBackgroundColor(Color.LTGRAY);
    }

    private void setColors() {
        faceModel.skinColor = Color.argb(255,faceModel.skinColorR,faceModel.skinColorG,faceModel.skinColorB);
        faceModel.eyeColor = Color.argb(255,faceModel.eyeColorR,faceModel.eyeColorG,faceModel.eyeColorB);
        faceModel.hairColor = Color.argb(255,faceModel.hairColorR,faceModel.hairColorG,faceModel.hairColorB);
        hairPaint.setColor(faceModel.hairColor);
        skinPaint.setColor(faceModel.skinColor);
        innerEyePaint.setColor(faceModel.eyeColor);

    }
    public void randomize()
    {
        Random rnd = new Random(); //create random object for color creation
        faceModel.skinColorR = rnd.nextInt(256);
        faceModel.skinColorG = rnd.nextInt(256);
        faceModel.skinColorB = rnd.nextInt(256); //set and save random argb color values for skinColor

        faceModel.eyeColorR = rnd.nextInt(256);
        faceModel.eyeColorG = rnd.nextInt(256);
        faceModel.eyeColorB = rnd.nextInt(256); //set and save random argb color values for eyeColor

        faceModel.hairColorR = rnd.nextInt(256);
        faceModel.hairColorG = rnd.nextInt(256);
        faceModel.hairColorB = rnd.nextInt(256); //set and save random argb color values for hairColor

        faceModel.hairStyle = rnd.nextInt(3); //set random hairStyle to value between 0-2 for corresponding hairstyles
        //Log.v("Debug1", "print " + faceModel.skinColor + " " + faceModel.eyeColor + " " + faceModel.hairColor + " " + faceModel.hairStyle); //check if randomized

    }
     public void onDraw(Canvas canvas) {
        setColors();
        drawFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
        canvas.drawRect(faceMidH - mouthWidth/2, faceMidV + faceHeight/3, faceMidH + mouthWidth/2, faceMidV + faceHeight/3 + mouthHeight, mouthPaint);
     }

     private void drawFace(Canvas canvas) {
        canvas.drawOval(faceMidH - faceWidth/2, faceMidV - faceHeight/2, //draws head based on mid values given
                faceMidH + faceWidth/2, faceMidV + faceHeight/2, skinPaint);
     }

     private void drawHair(Canvas canvas) {
        switch(faceModel.hairStyle) {
            case 0: //mohawk - draws a very tall mohawk that goes off the screen
                //Log.d("mohawk", "mohawk drawn"); //had problems getting stuff to draw on top of face
                canvas.drawRect(faceMidH - moWidth/2,faceMidV - faceHeight/2 - moHeight/2,faceMidH + moWidth/2,faceMidV - faceHeight/2 + moHeight/3, hairPaint);
                break;
            case 1: //comb-over - draws lines scarcely across the top of the head
                canvas.drawLine(650, 400, 975, 350, hairPaint);
                canvas.drawLine(650, 350, 975, 300, hairPaint);
                canvas.drawLine(650, 375, 975, 325, hairPaint);
                canvas.drawLine(650, 360, 975, 310, hairPaint);
                canvas.drawLine(650, 410, 975, 360, hairPaint);
                canvas.drawLine(650, 420, 975, 370, hairPaint);
                canvas.drawLine(650, 410, 975, 350, hairPaint);
                canvas.drawLine(650, 330, 975, 300, hairPaint);
                canvas.drawLine(650, 340, 975, 325, hairPaint);
                canvas.drawLine(650, 370, 975, 310, hairPaint);
                canvas.drawLine(650, 415, 975, 360, hairPaint);
                canvas.drawLine(650, 425, 975, 370, hairPaint);
                break;
            case 2: //bald
                break;
        }
     }
     private void drawEyes(Canvas canvas) {
        canvas.drawCircle(faceMidH - eyeRad - smallEyeRad, faceMidV - eyeRad, eyeRad, outerEyePaint);
        canvas.drawCircle(faceMidH + eyeRad + smallEyeRad, faceMidV - eyeRad, eyeRad, outerEyePaint);
        canvas.drawCircle(faceMidH - eyeRad - smallEyeRad, faceMidV - eyeRad, smallEyeRad, innerEyePaint);
        canvas.drawCircle(faceMidH + eyeRad + smallEyeRad, faceMidV - eyeRad, smallEyeRad, innerEyePaint);
     }

     public FaceModel getFaceModel() { return faceModel; }
}
