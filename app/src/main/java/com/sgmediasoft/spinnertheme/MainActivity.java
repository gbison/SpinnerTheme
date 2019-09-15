package com.sgmediasoft.spinnertheme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare variables of the correct widget type to hold our objects.
    Spinner spinner;
    TextView textView;

    int myint = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //BOILER PLATE CODE - DONT TOUCH
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //END BOILER PLATE CODE

        //Initialize declared variables with references to our objects on the frontend.
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        //Here we must add an internal event for the Spinner -
        //Spinners dont respond to click events and must look for OnItemSelected instead.
        //We use the standard anonymous function for the pass.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Here we define the body of the overridden method in AdapterView.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                //In order to make sure its working, we output to the console as a debug call.
                System.out.println("SPINNGER ITEM SELECTED");

                //Let gather the data from the calling item - in this case its string name.
                String text = parent.getSelectedItem().toString();

                //Another debug statement which you can check inside your Run consoles when you
                //run the program
                System.out.println(text);

                //Finally, send our gathered result to the TextView.
                textView.setText(text);
            }

            //We aren't using onNothingSelected, but it has to be present or it wont compile!
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Place holder for something cool you want to do...
            }
        });
    }
}
