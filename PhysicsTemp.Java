package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsTemp extends Activity{

    public static Scanner in = new Scanner(System.in);

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private String string_input_value;
    private double double_input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;

    public static double toCelsius(double tempi, int ui) {
        double c = 0;
        if (ui == 1) {
            c = tempi;
        } else if (ui == 2) {
            c = tempi - 273.15;
        } else {
            c = tempi * 9 / 5 + 32;
        }
        return c;
    }

    public static double convertTemp() {
        int ui, uf;
        double tempi, tempf = 0, temp_aux;

        //get initial unit
        do {
            System.out.println("Choose initial unit: celsius (1), Kelvin (2), fahrenheit (3)");
            ui = in.nextInt();
            if (ui < 1 || ui > 3)
                System.out.println("Invalid unit. Try again.");
        } while (ui < 1 || ui > 3);

        //convert to Celsius
        System.out.println("Initial value: ");
        tempi = in.nextDouble();
        temp_aux = toCelsius(tempi, ui);

        //get final unit
        do {
            System.out.println("Choose final unit: celsius (1), Kelvin (2), fahrenheit (3)");
            uf = in.nextInt();
            if (uf < 1 || uf > 3)
                System.out.println("Invalid unit. Try again.");
        } while (uf < 1 || uf > 3);

        //convert to final unit
        if (uf == 1) {
            tempf = temp_aux;
        } else if (uf == 2) {
            DecimalFormat df = new DecimalFormat(".##");
            tempf = Math.round((temp_aux + 273.150) * 100.0) / 100.0;
        } else {
            tempf = temp_aux * 5 / 9 - 32;
        }

        System.out.println("Final value is " + tempf);
        return tempf;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_temp);
        input_value=(EditText) findViewById(R.id.editText);
        string_input_value = input_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

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
        // NEED ERROR CHECK

        convertbutton = (ImageButton) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Connect to converter functions

            }
        });
    }


}
