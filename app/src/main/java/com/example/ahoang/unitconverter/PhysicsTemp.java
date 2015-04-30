package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsTemp extends Activity{

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private TextView output_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private int ui;
    private int uf;
    private Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_temp);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.temp_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.temp_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_value = (TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);
        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                //convert to intermediate
                if (ui == 1) {
                    mid = initialValue;
                } else if (ui == 2) {
                    mid = initialValue - 273.15;
                } else if (ui == 3) {
                    mid = (initialValue - 32) * (5.0/9.0);
                }

                //convert to final value
                if (uf == 1) {
                    finalValue = mid;
                    DecimalFormat df = new DecimalFormat("0.00000");
                    output_value.setText(df.format(finalValue));
                } else if (uf == 2) {
                    finalValue = Math.round((mid + 273.150) * 100.0) / 100.0;
                    String convertOutput = Double.toString(finalValue);
                    output_value.setText(convertOutput);
                } else  if (uf == 3) {
                    finalValue = mid * (9.0/5.0) + 32;
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