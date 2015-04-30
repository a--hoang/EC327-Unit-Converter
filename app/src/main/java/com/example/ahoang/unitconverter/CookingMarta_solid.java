
package com.example.ahoang.unitconverter;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Scanner;


public class CookingMarta_solid extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private Button switchButton;
    private int ui, uf;
    private TextView numTextView;
    private TextView output_value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooking_solid);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.input_unit_solid);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.input_unit_solid);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK


        //Populate random fact box
        numTextView = (TextView)findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 100);
        }
        catch(Exception e){
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);

        output_value = (TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);


        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double mid = 0;
                double initialValue;
                double finalValue = 0;

                //if text box is empty, do nothing
                if (TextUtils.isEmpty(input_value.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    initialValue = Double.parseDouble(input_value.getText().toString());
                }

                ui = input_unit.getSelectedItemPosition();
                uf = output_unit.getSelectedItemPosition();
                if (ui == 0 || uf == 0) {
                    Toast.makeText(getApplicationContext(), "Please choose units", Toast.LENGTH_SHORT).show();
                    return;
                }

                //convert to intermediate gr

                //ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), gram (6), kilogram (7)
                if (ui==1) {
                    mid= 28.6*initialValue;
                } else if (ui==2) {
                    mid = 14.3*initialValue;
                } else if (ui==3) {
                    mid = 4.766666666666*initialValue;
                } else if (ui==4) {
                    mid = 226.8*initialValue;
                } else if (ui==5) {
                    mid = 453.6 * initialValue;
                }else if (ui ==6) {
                    mid = initialValue;
                }else if (ui ==7) {
                    mid = 100.0 * initialValue;
                }

                //convert gram to other unit
                if (uf==1) {
                    finalValue = mid/28.6;
                } else if (uf==2) {
                    finalValue = mid/14.3;
                } else if ( uf==3) {
                    finalValue = mid/4.7666666666;
                } else if (uf==4) {
                    finalValue = mid/226.8;
                } else if (uf == 5){
                    finalValue = mid/453.6;
                } else if (uf == 6) {
                    finalValue = mid;
                } else if (uf == 7) {
                    finalValue = mid/100.0;
                }

                if (finalValue >= Math.pow(10, 6) || finalValue <= Math.pow(10,-6)) {
                    DecimalFormat df = new DecimalFormat("###0.####E0");
                    output_value.setText(df.format(finalValue));
                } else {
                    DecimalFormat df = new DecimalFormat("0.00000");
                    output_value.setText(df.format(finalValue));
                }
            }

        });

        switchButton = (Button) findViewById(R.id.switchbutton);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ui = input_unit.getSelectedItemPosition();
                uf = output_unit.getSelectedItemPosition();
                input_unit.setSelection(uf);
                output_unit.setSelection(ui);
            }
        });

    }
}

