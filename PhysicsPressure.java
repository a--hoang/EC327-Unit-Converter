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
public class PhysicsPressure extends Activity {

    public static Scanner in = new Scanner(System.in);

    private Spinner input_unit;
    private Spinner output_unit;
    private ImageButton convertbutton;
    private EditText input_value;
    private String string_input_value;
    private double double_input_value;
    private String[] input_unit_options;
    private String[] output_unit_options;


    public static double tommHg(double pi, int ui) {
        double mmHg;
        if (ui == 1) {
            mmHg = pi;
        } else if (ui == 2) {
            mmHg = pi * 0.0075006;
        } else if (ui == 3) {
            mmHg = pi * 759.9999520;
        } else {
            mmHg = pi * 0.7355591;
        }
        return mmHg;
    }

    public static double convertPressure() {
        int ui, uf;
        double pi, pf, p_aux;

        //get initial unit
        do {
            System.out.println("Initial pressure unit: mmH4 (1), Pa (2), atm (3), or cmH20 (4)");
            ui = in.nextInt();
            if (ui < 1 || ui > 4) {
                System.out.println("Invalid input. Try again.");
            }
        } while (ui < 1 || ui > 4);

        //convert to mmHg
        System.out.println("Initial pressure value: ");
        pi = in.nextDouble();
        p_aux = tommHg(pi, ui);

        //get final unit
        do {
            System.out.println("Choose final unit: mmHg (1), Pa (2), atm (3), or cmH2O (4)");
            uf = in.nextInt();
            if (uf < 1 || uf > 4)
                System.out.println("Invalid unit. Try again.");
        } while (uf < 1 || uf > 4);

        //convert mmHg to other unit
        if (uf == 1) {
            pf = p_aux;
        } else if (uf == 2) {
            pf = (p_aux / 0.0075006);
        } else if (uf == 3) {
            pf = (p_aux / 759.9999520);
        } else if (uf == 4) {
            pf = (p_aux / 0.7355591);
        } else {
            System.out.println("invalid unit. try again.");
            pf = 0;
        }
        System.out.println("Final value is " + pf);
        return pf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics_pressure);
        input_value = (EditText) findViewById(R.id.editText);
        string_input_value = input_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.pressure_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.mol_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, input_unit_options);
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
