package com.example.ahoang.unitconverter;

/**
 * Created by Clock on 4/25/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

public class MathCynthia_area extends Activity{

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private TextView output_value;
    private Button switchButton;
    private int ui;
    private int uf;

    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_math_area);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.first_unit_area_volume);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.first_unit_area_volume);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        output_value=(TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double initialvalue;
                double finalvalue;
                double inter;

                if (TextUtils.isEmpty(input_value.getText())) {
                    Toast.makeText(getApplicationContext(), "Please input a value", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    initialvalue = Double.parseDouble(input_value.getText().toString());
                }
                ui = input_unit.getSelectedItemPosition();
                uf = output_unit.getSelectedItemPosition();
                if (ui == 0 || uf == 0) {
                    Toast.makeText(getApplicationContext(), "Please choose units", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ui == 1){
                    inter = Math.sqrt(initialvalue)/39.3701;
                } else if (ui == 2){
                    inter = Math.sqrt(initialvalue)/3.2808;
                } else if (ui == 3){
                    inter = Math.sqrt(initialvalue)/1.0936;
                } else if (ui == 4){
                    inter = Math.sqrt(initialvalue)*1609;
                } else if (ui == 5){
                    inter = Math.sqrt(initialvalue)/1000;
                } else if (ui == 6){
                    inter = Math.sqrt(initialvalue)/100;
                } else if (ui == 7){
                    inter = Math.sqrt(initialvalue);
                } else {
                    inter = Math.sqrt(initialvalue)*1000;
                }

                if (uf == 1){
                    finalvalue = Math.pow((inter*39.3701),2);
                } else if (uf == 2){
                    finalvalue = Math.pow((inter*3.2808),2);
                } else if (uf == 3){
                    finalvalue = Math.pow((inter*1.0936),2);
                } else if (uf == 4){
                    finalvalue = Math.pow((inter/1609),2);
                } else if (uf == 5){
                    finalvalue = Math.pow((inter*1000),2);
                } else if (uf == 6){
                    finalvalue = Math.pow((inter*100),2);
                } else if (uf == 7){
                    finalvalue = Math.pow(inter,2);
                } else {
                    finalvalue = Math.pow((inter/1000),2);
                }

                output_value.setText(""+finalvalue);
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
