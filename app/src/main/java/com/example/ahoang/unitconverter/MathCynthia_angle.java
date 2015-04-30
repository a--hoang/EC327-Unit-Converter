package com.example.ahoang.unitconverter;

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


public class MathCynthia_angle extends Activity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_math_angle);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.first_unit_angles);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.first_unit_angles);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        output_value=(TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);

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
                if (ui == 1) {
                    inter = initialvalue;
                } else {
                    inter = (180 / Math.PI) * initialvalue;
                }
                if (uf == 1) {
                    finalvalue = inter;
                } else {
                    finalvalue = (Math.PI / 180) * inter;
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


