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


public class CookingMarta_liquid extends Activity {

    public static Scanner in = new Scanner(System.in);
    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private TextView output_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private int ui, uf;
    private Button switchButton;
    private TextView numTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooking_liquid);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.input_unit_liquid);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.input_unit_liquid);
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

                //convert to intermediate ml

                //1 = ounces // 2 = tbsp // 3 = cups // 4 = pint // 5 = quart // 6 = gallon // 7 = milliters // 8 = liter
                if (ui==1) {
                    mid = 30.0*initialValue;
                } else if (ui==2) {
                    mid = 15.0*initialValue;
                } else if (ui==3) {
                    mid = 250.0*initialValue;
                } else if (ui==4) {
                    mid = 500.0*initialValue;
                } else if (ui==5) {
                    mid = 1000.0 * initialValue;
                } else if (ui ==6) {
                    mid = 4000.0 * initialValue;
                }else if (ui == 7){
                    mid =  initialValue;
                } else if (ui == 8){
                    mid = 1000.0 * initialValue;
                }

                //convert ml to other unit
                if (uf==1) {
                    finalValue = mid/30.0;
                } else if (uf==2) {
                    finalValue  = mid/15.0;
                } else if (uf==3) {
                    finalValue = mid/250.0;
                } else if (uf==4) {
                    finalValue  = mid/500.0;
                } else if (uf== 5){
                    finalValue  = mid/1000.0;
                } else if (uf == 6) {
                    finalValue  = mid/4000.0;
                } else if (uf==7 ) {
                    finalValue  = mid;
                }else if (uf==8 ) {
                    finalValue  = mid/1000.0;
                }

                //double finalValue = convertTemp(initialValue, ui, uf);
                DecimalFormat df = new DecimalFormat("0.00000");
                output_value.setText(df.format(finalValue));
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
