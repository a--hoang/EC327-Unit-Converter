package com.example.ahoang.unitconverter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Scanner;


/**
 * Created by Cindy on 4/22/2015.
 */
public class PhysicsMassForce extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private String string_input_value;
    private double double_input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;

    public static Scanner in = new Scanner(System.in);

    public static double toKg(double mi, int ui) {
        double kg = 0;
        if (ui == 1) {
            kg = mi;
        } else if (ui == 2) {
            kg = mi / 2.20462;
        } else {
            kg = mi / 9.80665;
        }
        return kg;
    }

    public static double convertMassForce() {
        int ui, uf;
        double mi, mf = 0, m_aux;

        //get initial unit
        do {
            System.out.println("Choose initial unit: kilograms (1), pounds (2), Newtons (3)");
            ui = in.nextInt();
            if (ui < 1 || ui > 3)
                System.out.println("Invalid unit. Try again.");
        } while (ui < 1 || ui > 3);

        //convert to kg
        System.out.println("Initial value: ");
        mi = in.nextDouble();
        m_aux = toKg(mi, ui);

        //get final unit
        do {
            System.out.println("Choose final unit: kilograms (1), pounds (2), Newtons (3)");
            uf = in.nextInt();
            if (uf < 1 || uf > 3)
                System.out.println("Invalid unit. Try again.");
        } while (uf < 1 || uf > 3);

        //convert to final unit
        if (uf == 1) {
            mf = m_aux;
        } else if (uf == 2) {
            mf = m_aux * 2.20462;
        } else {
            mf = m_aux * 9.80665;
        }

        System.out.println("Final value is " + mf);
        return mf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_massforce);
        input_value=(EditText) findViewById(R.id.editText);
        string_input_value = input_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.massforce_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.massforce_types);
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
