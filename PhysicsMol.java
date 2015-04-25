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
                double mid;
                double initialValue;
                double finalValue;
                double extraAM = 1;
                double extraL = 1;

                //if text box is empty, do nothing
                if (TextUtils.isEmpty(input_value.getText().toString())) {
                    return;
                } else {
                    initialValue = Double.parseDouble(input_value.getText().toString());
                }

                String inputUnitChoice = input_unit.getSelectedItem().toString();
                if (inputUnitChoice.equals("moles")){
                    ui = 1;
                } else if (inputUnitChoice.equals("molecules")) {
                    ui = 2;
                } else if (inputUnitChoice.equals("molar")) {
                    ui = 3;
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: volume in liters", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    extraL = Double.parseDouble(extraInputL.getText().toString());
                } else {
                    ui = 4;
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: volume in liters", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    extraAM = Double.parseDouble(extraInputAM.getText().toString());
                }

                String outputUnitChoice = output_unit.getSelectedItem().toString();
                if (outputUnitChoice.equals("moles")) {
                    uf = 1;
                } else if (outputUnitChoice.equals("molecules")) {
                    uf = 2;
                } else if (outputUnitChoice.equals("molar")){
                    uf = 3;
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: volume in liters", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    extraL = Double.parseDouble(extraInputL.getText().toString());
                } else {
                    uf = 4;
                    if (TextUtils.isEmpty((extraInputL.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Missing: atomic mass in kilograms", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    extraAM = Double.parseDouble(extraInputAM.getText().toString());
                }

                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue / NA;
                } else if (ui == 3) {
                    mid = initialValue * extraL;
                } else {
                    mid = initialValue / extraAM;
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
