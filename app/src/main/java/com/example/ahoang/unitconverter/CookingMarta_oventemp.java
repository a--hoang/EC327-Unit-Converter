package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Scanner;

public class CookingMarta_oventemp extends Activity {

    public static Scanner in = new Scanner(System.in);
    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private int ui, uf;
    private Button switchButton;

    public static double convertOven() {
        int unitinput;
        double inputvalue;
        double outputvalue=0;

        //get initial unit
        do {
            System.out.println("Initial temperature unit: celsius (1) or fahrenheit ");
            unitinput = in.nextInt();
            if (unitinput < 1 || unitinput > 2) {
                System.out.println("Invalid input. Try again.");
            }
        } while (unitinput < 1 || unitinput > 2);

        System.out.println("Initial temperature value: ");
        inputvalue = in.nextDouble();

        //Conversor
        if (unitinput ==1){
            outputvalue =  inputvalue  * 9/5 + 32;
        }
        else if (unitinput ==2) {
            outputvalue = ( inputvalue - 32) / (9/5);
        }
        System.out.println("Final value is " + outputvalue);
        return outputvalue;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooking_oventemp);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.input_unit_oventemp);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.input_unit_oventemp);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        convertbutton = (Button) findViewById(R.id.imageButton);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
