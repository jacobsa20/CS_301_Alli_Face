package com.example.jacobsa20.cs_301_assignment2_face;

/**
 * Alli Jacobs
 * Created by jacobsa20 on 2/9/2018.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.BLACK;

public class Face extends SurfaceView{
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    private Paint skinPaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint hairPaint = new Paint();
    private int radioChoice=0;


    Random num = null;
    protected Paint myPaint;

    public Face(Context context){
        super(context);
        randomize();
        setWillNotDraw(false);
    }

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        randomize();
        setWillNotDraw(false);
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        randomize();
        setWillNotDraw(false);
    }


    public void randomize(){
        num = new Random();
        this.hairStyle = num.nextInt(3);

        this.skinColor = Color.argb(255, num.nextInt(256),
                num.nextInt(256), num.nextInt(256));
        this.eyeColor = Color.argb(255, num.nextInt(256),
                num.nextInt(256), num.nextInt(256));
        this.hairColor = Color.argb(255, num.nextInt(256),
                num.nextInt(256), num.nextInt(256));
    }

    public void onDraw(Canvas g){
        myPaint = new Paint(); //any color I can hard code,
        // like the whites of the eyes, or the pupils
        skinPaint.setColor(skinColor);
        g.drawCircle(300.0f, 300.0f, 150.0f, skinPaint);
        /////////////Draw Hair////////////
        hairStyleOptions(g,myPaint);
        ///////////// Painting Eyes////////
        myPaint.setColor(WHITE);
        g.drawCircle(275.0f, 275.0f, 50.0f, myPaint);
        g.drawCircle(325.0f, 275.0f, 50.0f, myPaint);
        eyePaint.setColor(eyeColor);
        g.drawCircle(275.0f, 275.0f, 25.0f, eyePaint);
        g.drawCircle(325.0f, 275.0f, 25.0f, eyePaint);
        myPaint.setColor(BLACK);
        g.drawCircle(275.0f, 275.0f, 10.0f, myPaint);
        g.drawCircle(325.0f, 275.0f, 10.0f, myPaint);
        g.drawCircle(300.0f, 320.0f, 20.0f, myPaint);

        invalidate();
    }

    public void hairStyleOptions(Canvas g, Paint myPaint){

        hairPaint.setColor(hairColor);
        hairPaint.setStrokeWidth(5.0f);
        if(hairStyle==0){
            //Beehive
            g.drawCircle(300.0f, 150.0f, 75.0f, hairPaint);
            g.drawCircle(300.0f, 100.0f, 50.0f, hairPaint);
            g.drawCircle(300.0f, 50.0f, 25.0f, hairPaint);
            invalidate();
        }
        if(hairStyle==1){
            //Square
            g.drawRect(150.0f, 150.0f, 450.0f, 200.0f, hairPaint);
            g.drawRect(200.0f, 125.0f, 400.0f, 175.0f, hairPaint);
            g.drawRect(250.0f, 100.0f, 350.0f, 150.0f, hairPaint);
            invalidate();
        }
        if(hairStyle==2){
            //Curls
            g.drawCircle(200.0f,200.0f,25.0f,hairPaint);
            g.drawCircle(250.0f,200.0f,25.0f,hairPaint);
            g.drawCircle(300.0f,200.0f,25.0f,hairPaint);
            g.drawCircle(350.0f,200.0f,25.0f,hairPaint);
            g.drawCircle(400.0f,200.0f,25.0f,hairPaint);
            g.drawCircle(225.0f,175.0f,25.0f,hairPaint);
            g.drawCircle(275.0f,175.0f,25.0f,hairPaint);
            g.drawCircle(325.0f,175.0f,25.0f,hairPaint);
            g.drawCircle(375.0f,175.0f,25.0f,hairPaint);
            g.drawCircle(250.0f,150.0f,25.0f,hairPaint);
            g.drawCircle(300.0f,150.0f,25.0f,hairPaint);
            g.drawCircle(350.0f,150.0f,25.0f,hairPaint);
            invalidate();

        }
    }

    /**
     * External Citation
     * Date: February 15, 2018
     * Problem: Had trouble transfering colors onto seekBars.
     * These getters and setters were a hint to the rest of
     * the code.
     * Resource: Chris Fishback
     * Solution: He helped me write the getters and setters,
     * then I had to keep going
     */
    public void setHairColor(int r, int g, int b){
    this.hairColor=Color.rgb(r,g,b);}
    public void setEyeColor(int r, int g, int b){
    this.eyeColor=Color.rgb(r,g,b);}
    public void setSkinColor(int r, int g, int b){
    this.skinColor=Color.rgb(r,g,b);}
    public void setRadioChoice(int choice){radioChoice=choice;}
    public int getRadioChoice(){return radioChoice;}
}