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

import java.text.DecimalFormat;

public class MathCynthia_volume extends Activity{

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
    private TextView numTextView;

    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_math_volume);
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

        output_value =(TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);

//        numTextView = (TextView)findViewById(R.id.numberText);
//        //set api string
//        String temp;
//        try {
//            do {
//                temp = new DownloadTask().execute().get();
//            }while (temp.length() > 100);
//        }
//        catch(Exception e){
//            temp = "Error, connection refused.";
//            System.out.println("Error, connection refused.");
//        }
//        numTextView.setText(temp);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double initialvalue = 0;
                double finalvalue;
                double inter;
                //1 = deg, 2 = rad
                if (TextUtils.isEmpty(input_value.getText())) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
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
                    inter = Math.pow(initialvalue, (1/3))/39.3701;
                } else if (ui == 2){
                    inter = Math.pow(initialvalue, (1/3))/3.2808;
                } else if (ui == 3){
                    inter = Math.pow(initialvalue, (1/3))/1.0936;
                } else if (ui == 4){
                    inter = Math.pow(initialvalue, (1/3))*1609;
                } else if (ui == 5){
                    inter = Math.pow(initialvalue, (1/3))/1000.0;
                } else if (ui == 6){
                    inter = Math.pow(initialvalue, (1/3))/100.0;
                } else if (ui == 7){
                    inter = Math.pow(initialvalue, (1/3));
                } else {
                    inter = Math.pow(initialvalue, (1/3))*1000;
                }

                if (uf == 1){
                    finalvalue = Math.pow((inter*39.3701),3);
                } else if (uf == 2){
                    finalvalue = Math.pow((inter*3.2808),3);
                } else if (uf == 3){
                    finalvalue = Math.pow((inter*1.0936),3);
                } else if (uf == 4){
                    finalvalue = Math.pow((inter/1609),3);
                } else if (uf == 5){
                    finalvalue = Math.pow((inter*1000),3);
                } else if (uf == 6){
                    finalvalue = Math.pow((inter*100),3);
                } else if (uf == 7){
                    finalvalue = Math.pow(inter,3);
                } else {
                    finalvalue = Math.pow((inter/1000.0),3);
                }

                DecimalFormat df = new DecimalFormat("0.00000");
                output_value.setText(df.format(finalvalue));

                //output_value.setText(""+finalvalue);
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