package com.example.jacobsa20.cs_301_assignment2_face;
/**
 * Alli Jacobs
 * Created by jacobsa20 on 2/12/2018.
 //it's like my "NuxListener"
 */
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class EventListener
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener,RadioGroup.OnCheckedChangeListener{
    private ArrayList<TextView> allSeekBarTV=new ArrayList<TextView>();
    private ArrayList<SeekBar> allSeekBarRBG=new ArrayList<SeekBar>();

    public int r;
    public int g;
    public int b;

    protected SeekBar[] seekBars = new SeekBar[3];
    public Color[] colors = new Color[3];

    Face thisFace;

    public EventListener(Face face, SeekBar blue, SeekBar red, SeekBar green){
        seekBars[0] = blue;
        seekBars[1] = red;
        seekBars[2] = green;

        r = red.getProgress();
        g = green.getProgress();
        b = blue.getProgress();
        thisFace=face;
    }
    /**
     * External Citation
     * Date: February 15, 2018
     * Problem: Couldn't get seekBar Text Views to change
     * when I dragged the seekBars around.
     * Resource: Chris Fishback
     * Solution: Let me use his code as a resource,
     * took his work as an example, however they are
     * not exactly the same code. I moved my "settext"
     */
    @Override
    public void onProgressChanged
    (SeekBar seekBar, int progress, boolean fromUser){
        int r = 0;
        int g = 0;
        int b = 0;
        if(seekBar.getId()==R.id.redSeekBar){
            for (TextView tv: allSeekBarTV){
                if(tv.getId()==R.id.redTextView){
                    tv.setText(""+progress);
                    r=progress;}
            }}
        if(seekBar.getId()==R.id.greenSeekBar){
            for (TextView tv: allSeekBarTV){
                if(tv.getId()==R.id.greenTextView){
                    tv.setText(""+progress);
                    g=progress;}
            }}
        if(seekBar.getId()==R.id.blueSeekBar){
            for (TextView tv: allSeekBarTV){
                if(tv.getId()==R.id.blueTextView){
                    tv.setText(""+progress);
                    b=progress;}
            }}
        if(thisFace.getRadioChoice()==0){
            thisFace.setHairColor(r,g,b);}
        else if(thisFace.getRadioChoice()==1){
            thisFace.setEyeColor(r,g,b);}
        else if(thisFace.getRadioChoice()==2){
            thisFace.setSkinColor(r,g,b);}
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar){
        //do nothing.  I don't care about this event
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar){
        //do nothing.  I don't care about this event
    }
    @Override
    public void onClick(View v){
        //check what was pressed
        thisFace.randomize();
    }
    public void addToArray(TextView colorTV, SeekBar colorSB){
        allSeekBarRBG.add(colorSB);
        allSeekBarTV.add(colorTV);
    }
    /** EXTERNAL CITATION
     Date:February 2018
     Problem:Could not get onItemSelected to change hairstyle
     correctly; before using resource, if I were to click on
     the spinner, it would randomly choose a hairstyle instead
     of the one I wanted.
     Resource:www.mkyong.com/android/android-spinner-drop-down-list-example/
     and Mason Fredenberg: Mason helped me find the website.
     Solution: I used the example code posted on this website.
     **/
    @Override
    public void onItemSelected
            (AdapterView<?> parent, View view, int position, long id){
        //Copied code to get the position of the seekBar
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " +
                        parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
        thisFace.hairStyle=position;
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){
    //I don't care about this button
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
        //if a certain radio button is pressed, the specific radio button
        //sets it's color representative to the face
        if(checkedId==R.id.hairRadioButton){
            thisFace.setRadioChoice(0);
        }
        if(checkedId==R.id.eyesRadioButton){
            thisFace.setRadioChoice(1);
        }
        if(checkedId==R.id.skinRadioButton){
            thisFace.setRadioChoice(2);
        }
    }
}