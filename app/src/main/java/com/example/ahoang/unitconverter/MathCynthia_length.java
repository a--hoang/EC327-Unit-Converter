package com.example.ahoang.unitconverter;

/**
 * Created by Clock on 4/25/15.
 */

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

public class MathCynthia_length extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private TextView output_value;
    private String[] input_unit_options;
    private String [] output_unit_options;
    private int ui;
    private int uf;
    private Button switchButton;
    private TextView numTextView;


    //0=Mm,1=km,2=hm,3=dm,4=m,5=dim,6=cm,7=mm,8=um,9=nm,10=pm,11=inch,12=feet,13=yard,14=mile
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_math_lengths);
        input_value = (EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.first_unit_lengths);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.first_unit_lengths);
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
            public void onClick(View v) {
                double initialvalue;
                double finalvalue = 0;
                double inter = 0;
                //1 = deg, 2 = rad
//
                //if text box is empty, do nothing
                if (TextUtils.isEmpty(input_value.getText().toString())) {
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
                    inter = initialvalue*Math.pow(10,6);
                } else if (ui == 2) {
                    inter = initialvalue*1000;
                } else if (ui == 3) {
                    inter = initialvalue*100;
                } else if (ui == 4) {
                    inter = initialvalue*10;
                } else if (ui == 5) {
                    inter = initialvalue;
                } else if (ui == 6) {
                    inter = initialvalue/10.0;
                } else if (ui == 7) {
                    inter = initialvalue/100;
                } else if (ui == 8) {
                    inter = initialvalue/1000;
                } else if (ui == 9) {
                    inter = initialvalue/(Math.pow(10,6));
                } else if (ui == 10) {
                    inter = initialvalue/(Math.pow(10,9));
                } else if (ui == 11) {
                    inter = initialvalue/(Math.pow(10,12));
                } else if (ui == 12) {
                    inter = initialvalue/39.3701;
                } else if (ui == 13) {
                    inter = initialvalue/3.2808;
                } else if (ui == 14) {
                    inter = initialvalue/1.0936;
                } else if (ui == 15) {
                    inter = initialvalue*1609;
                }

                if (uf == 1){
                    finalvalue = inter/(Math.pow(10,6));
                } else if (uf == 2) {
                    finalvalue = inter/1000.0;
                } else if (uf == 3) {
                    finalvalue = inter/100.0;
                } else if (uf == 4) {
                    finalvalue = inter/10.0;
                } else if (uf == 5) {
                    finalvalue = inter;
                } else if (uf == 6) {
                    finalvalue = inter*10;
                } else if (uf == 7) {
                    finalvalue = inter*100;
                } else if (uf == 8) {
                    finalvalue = inter*1000;
                } else if (uf == 9) {
                    finalvalue = inter*(Math.pow(10,6));
                } else if (uf == 10) {
                    finalvalue = inter*(Math.pow(10,9));
                } else if (uf == 11) {
                    finalvalue = inter*(Math.pow(10,12));
                } else if (uf == 12) {
                    finalvalue = inter*39.3701;
                } else if (uf == 13) {
                    finalvalue = inter*3.2808;
                } else if (uf == 14) {
                    finalvalue = inter*1.0936;
                } else if (uf == 15) {
                    finalvalue = inter/1609.0;
                }

                if (finalvalue >= Math.pow(10, 6) || finalvalue <= Math.pow(10,-6)) {
                    DecimalFormat df = new DecimalFormat("###0.####E0");
                    output_value.setText(df.format(finalvalue));
                } else {
                    DecimalFormat df = new DecimalFormat("0.00000");
                    output_value.setText(df.format(finalvalue));
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
