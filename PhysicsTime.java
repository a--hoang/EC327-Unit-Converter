package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Scanner;

/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsTime extends Activity {

    public static Scanner in = new Scanner(System.in);

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private String string_input_value;
    private double double_input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;

    public static double toSec(double ti, int ui) {
        double s;
        if (ui == 1) {
            s = ti;
        } else if (ui == 2) {
            s = ti * 60;
        } else if (ui == 3) {
            s = ti * 60 * 60;
        } else if (ui == 4) {
            s = ti * 24 * 60 * 60;
        } else {
            s = ti * 7 * 24 * 60 * 60;
        }
        return s;
    }

    public static void convertTime() {
        int ui, uf;
        double ti, tf = 0, t_aux;

        //get initial unit
        do {
            System.out.println("Choose initial unit: seconds (1), minute (2), hour (3), day (4), week (5)");
            ui = in.nextInt();
            if (ui < 1 || ui > 5)
                System.out.println("Invalid unit. Try again.");
        } while (ui < 1 || ui > 5);

        //convert to seconds
        System.out.println("Initial value: ");
        ti = in.nextDouble();
        t_aux = toSec(ti, ui);

        //get final unit
        do {
            System.out.println("Choose initial unit: seconds (1), minute (2), hour (3), day (4), week (5)");
            uf = in.nextInt();
            if (uf < 1 || uf > 5)
                System.out.println("Invalid unit. Try again.");
        } while (uf < 1 || uf > 5);

        //convert to final unit
        if (uf == 1) {
            tf = t_aux;
        } else if (uf == 2) {
            tf = t_aux / 60;
        } else if (uf == 3) {
            tf = t_aux / 60 / 60;
        } else if (uf == 4) {
            tf = t_aux / 24 / 60 / 60;
        } else {
            tf = t_aux / 7 / 24 / 60 / 60;
        }

        System.out.println("Final value is " + tf);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_time);
        input_value=(EditText) findViewById(R.id.editText);
        string_input_value = input_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.time_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.time_types);
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
