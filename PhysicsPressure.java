package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Scanner;

/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsPressure extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private EditText output_value;
    private String[] input_unit_options;
    private String[] output_unit_options;
    private int ui;
    private int uf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_pressure);
        input_value = (EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.pressure_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.pressure_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, input_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        output_value = (EditText)  findViewById(R.id.finalAmount_text);

        convertbutton = (ImageButton) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
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
                if (inputUnitChoice.equals("mmHg/Torr")) {
                    ui = 1;
                } else if (inputUnitChoice.equals("Pa")) {
                    ui = 2;
                } else if (inputUnitChoice.equals("atm")) {
                    ui = 3;
                } else {
                    ui = 4;
                }


                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue * 0.0075006;
                } else if (ui == 3) {
                    mid = initialValue * 759.9999520;
                } else {
                    mid = initialValue * 0.7355591;
                }


                String outputUnitChoice = output_unit.getSelectedItem().toString();
                if (outputUnitChoice.equals("mmHg/Torr")) {
                    uf = 1;
                } else if (outputUnitChoice.equals("Pa")) {
                    uf = 2;
                } else if (outputUnitChoice.equals("atm")) {
                    uf = 3;
                } else {
                    uf = 4;
                }

                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue - 273.15;
                } else {
                    mid = initialValue * 9.0 / 5.0 + 32;
                }

                //convert to final value
                if (uf == 1) {
                    finalValue = mid;
                } else if (uf == 2) {
                    finalValue = Math.round((mid + 273.150) * 100.0) / 100.0;
                } else {
                    finalValue = mid * 5.0 / 9.0 - 32;
                }

                //double finalValue = convertTemp(initialValue, ui, uf);
                String convertOutput = Double.toString(finalValue);
                output_value.setText(convertOutput);
            }

        });
    }
}
