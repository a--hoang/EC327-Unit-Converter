package com.example.ahoang.unitconverter;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Scanner;


/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsMassForce extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private EditText output_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private int ui;
    private int uf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_massforce);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.massforce_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.massforce_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_value = (EditText) findViewById(R.id.finalAmount_text);

        convertbutton = (ImageButton) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mid;
                double initialValue;
                double finalValue;

                //if text box is empty, do nothing
                if (TextUtils.isEmpty(input_value.getText().toString())) {
                    return;
                } else {
                    initialValue = Double.parseDouble(input_value.getText().toString());
                }

                String inputUnitChoice = input_unit.getSelectedItem().toString();
                if (inputUnitChoice.equals("kilograms")){
                    ui = 1;
                } else if (inputUnitChoice.equals("pounds")) {
                    ui = 2;
                } else {
                    ui = 3;
                }

                String outputUnitChoice = output_unit.getSelectedItem().toString();
                if (outputUnitChoice.equals("kilograms")) {
                    uf = 1;
                } else if (outputUnitChoice.equals("pounds")) {
                    uf = 2;
                } else {
                    uf = 3;
                }

                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue/ 2.20462;
                } else {
                    mid = initialValue / 9.80665;
                }

                //convert to final value
                if (uf == 1) {
                    finalValue = mid;
                } else if (uf == 2) {
                    finalValue = mid * 2.20462;
                } else {
                    finalValue = mid * 9.80665;
                }

                String convertOutput = Double.toString(finalValue);
                output_value.setText(convertOutput);

            }



        });
    }
}
