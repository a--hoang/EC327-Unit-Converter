package com.example.ahoang.unitconverter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Scanner;


public class CookingMarta_solid extends Activity {

    public static Scanner in = new Scanner(System.in);
    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;

    public static double togram (double input, int unitinput) {
        double gram = 0;
        //ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)
        if (unitinput==1) {
            gram = 28.6*input;
        } else if (unitinput==2) {
            gram = 14.3*input;
        } else if (unitinput==3) {
            gram = 4.766666666666*input;
        } else if (unitinput==4) {
            gram = 226.8*input;
        } else if (unitinput==5) {
            gram = 453.6 * input;
        } else if (unitinput ==6) {
            gram = 100 * input;
        }

        return gram;
    }

    public static double convertDry() {
        int unitinput, finalunit;
        double inputvalue, inputtogram, outputvalue;

        //get initial unit
        do {
            System.out.println("Initial mass unit: ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)");
            unitinput = in.nextInt();
            if (unitinput < 1 || unitinput > 7) {
                System.out.println("Invalid input. Try again.");
            }
        } while (unitinput < 1 || unitinput > 7);

        //convert to gram
        System.out.println("Initial mass value: ");
        inputvalue = in.nextDouble();
        inputtogram = togram(inputvalue, unitinput);

        //get final unit
        do {
            System.out.println("Choose final unit: ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)");
            finalunit = in.nextInt();
            if (finalunit < 1 || finalunit > 8)
                System.out.println("Invalid unit. Try again.");
        } while (finalunit < 1 || finalunit > 8);

        //convert gram to other unit
        if (finalunit==1) {
            outputvalue = inputtogram/28.6;
        } else if (finalunit==2) {
            outputvalue = inputtogram/14.3;
        } else if ( finalunit==3) {
            outputvalue = inputtogram/4.7666666666;
        } else if (finalunit==4) {
            outputvalue = inputtogram/226.8;
        } else if (finalunit == 5){
            outputvalue = inputtogram/453.6;
        } else if (finalunit == 6) {
            outputvalue = inputtogram/100;
        } else {
            outputvalue = inputvalue;
        }
        System.out.println("Final value is " + outputvalue);
        return outputvalue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cookingmarta);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.input_unit_solid);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.spinner);
        output_unit_options = getResources().getStringArray(R.array.input_unit_solid);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        convertbutton = (Button) findViewById(R.id.button);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }


}
