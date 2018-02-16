package com.example.jacobsa20.cs_301_assignment2_face;
/**
 * Created by Alli Jacobs
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Face myFace;
    private String[] hairTypes =
            {"Beehive", "Square", "Curls"};
    private TextView blueSeekBarTV = null;
    private TextView redSeekBarTV = null;
    private TextView greenSeekBarTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myFace = (Face) findViewById(R.id.surfaceView);

        //Make SeekBar Listeners
        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);

        blueSeekBarTV = (TextView) findViewById(R.id.blueTextView);
        redSeekBarTV = (TextView) findViewById(R.id.redTextView);
        greenSeekBarTV = (TextView) findViewById(R.id.greenTextView);

        //Make RFACEBUTTON
        Button randFaceButton=(Button)findViewById(R.id.randomFaceButton);
        /**External Citation
         * Date: February 12, 2018
         * Problem: Have no clue what a Radio Button is, or how to use it.
         * I need to have all three relate to one another
         * Resource:
         * https://developer.android.com
         * /guide/topics/ui/controls/radiobutton.html
         * Solution: Used example to realize I needed a radio group, and
         * made a method to read which radio button was being used
         */
        //Make RadioButton and RadioGroup
        RadioGroup myRadioButtons=(RadioGroup)
                findViewById(R.id.radioGroupHES);
        RadioButton hairRadButt=(RadioButton)
                findViewById(R.id.hairRadioButton);
        RadioButton eyesRadButt=(RadioButton)
                findViewById(R.id.eyesRadioButton);
        RadioButton skinRadButt=(RadioButton)
                findViewById(R.id.skinRadioButton);

        //Event Listener to get seekBar behavior into MainActivity class
        EventListener myEventListener = new EventListener(myFace, blueSeekBar,
                redSeekBar, greenSeekBar);
        myEventListener.addToArray(blueSeekBarTV, blueSeekBar);
        myEventListener.addToArray(redSeekBarTV, redSeekBar);
        myEventListener.addToArray(greenSeekBarTV, greenSeekBar);

        redSeekBar.setOnSeekBarChangeListener(myEventListener);
        blueSeekBar.setOnSeekBarChangeListener(myEventListener);
        greenSeekBar.setOnSeekBarChangeListener(myEventListener);

        randFaceButton.setOnClickListener(myEventListener);

        myRadioButtons.setOnCheckedChangeListener(myEventListener);

        ArrayAdapter<String> hairAdapter =
                new ArrayAdapter<String>
                        (this, android.R.layout.simple_spinner_dropdown_item,
                        hairTypes);
        Spinner spinnerForHairs = (Spinner) findViewById(R.id.hairSpinner);
        spinnerForHairs.setAdapter(hairAdapter);
        spinnerForHairs.setOnItemSelectedListener(myEventListener);
    }
}
