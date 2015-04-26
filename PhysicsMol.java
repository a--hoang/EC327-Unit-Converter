package com.example.ahoang.unitconverter;

import android.app.Activity;

import java.util.Scanner;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsMol extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private EditText output_value;
    private EditText extraInputAM;
    private EditText extraInputL;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private int ui;
    private int uf;
    private Button switchButton;

    static final double NA = 6.0221415 * (10 ^ 13);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_mol);
        input_value=(EditText) findViewById(R.id.editText);
        extraInputAM = (EditText) findViewById(R.id.atomic_mass);
        extraInputL = (EditText) findViewById(R.id.liters);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.mol_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.mol_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        output_value = (EditText) findViewById(R.id.finalAmount_text);

        convertbutton = (ImageButton) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mid = 0;
                double initialValue;
                double finalValue = 0;
                double extraAM = 1;
                double extraL = 1;

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

                if (ui == 3 || uf == 3) {
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: volume in liters", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        extraL = Double.parseDouble(extraInputL.getText().toString());
                    }

                } else if (ui == 4 || uf == 4) {
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: volume in liters", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        extraAM = Double.parseDouble(extraInputAM.getText().toString());
                    }
                }


                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue / NA;
                } else if (ui == 3) {
                    mid = initialValue * extraL;
                } else if (ui == 4) {
                    mid = initialValue / extraAM;
                }

                //convert to final value
                if (uf == 1) {
                    finalValue = mid;
                } else if (uf == 2) {
                    finalValue = mid * NA;
                } else if (uf == 3) {
                    finalValue = mid / extraL;
                } else if (uf == 4) {
                    finalValue = mid * extraAM;
                }

                String convertOutput = Double.toString(finalValue);
                output_value.setText(convertOutput);
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
