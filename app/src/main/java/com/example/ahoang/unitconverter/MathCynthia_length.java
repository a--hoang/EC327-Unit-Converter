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
import java.util.Scanner;

public class MathCynthia_length extends Activity {
    public static Scanner in = new Scanner(System.in);
    private Spinner first_unit;
    private Spinner last_unit;
    private Button convertbutton;
    private EditText first_value;
    private String [] first_unit_options;
    private String [] last_unit_options;

    //0=Mm,1=km,2=hm,3=dm,4=m,5=dim,6=cm,7=mm,8=um,9=nm,10=pm,11=inch,12=feet,13=yard,14=mile
    public static double tometer(double input,int funit) {
        double con;
        if (funit == 0){
            con = input*(10^6);
        } else if (funit == 1) {
            con = input*1000;
        } else if (funit == 2) {
            con = input*100;
        } else if (funit == 3) {
            con = input*10;
        } else if (funit == 4) {
            con = input;
        } else if (funit == 5) {
            con = input/10;
        } else if (funit == 6) {
            con = input/100;
        } else if (funit == 7) {
            con = input/1000;
        } else if (funit == 8) {
            con = input/(10^6);
        } else if (funit == 9) {
            con = input/(10^9);
        } else if (funit == 10) {
            con = input/(10^12);
        } else if (funit == 11) {
            con = input/39.3701;
        } else if (funit == 12) {
            con = input/3.2808;
        } else if (funit == 13) {
            con = input/1.0936;
        } else {
            con = input*1609;
        }
        return con;
    }

    public static double convertLen(){
        int funit,lunit;
        double inputval,inter,outputval;

        do {
            System.out.println("First Unit: Mm(0),km(1),hm(2),dm(3),m(4),dim(5),cm(6),mm(7),um(8),nm(9),pm(10),inch(11),foot(12),yard(13),mile(14)");
            funit = in.nextInt();
            if (funit < 0 || funit > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while(funit < 0 || funit > 11);

        System.out.println("Initial length value: ");
        inputval = in.nextDouble();
        inter = tometer(inputval,funit);

        do {
            System.out.println("Final Unit: Mm(0),km(1),hm(2),dm(3),m(4),dim(5),cm(6),mm(7),um(8),nm(9),pm(10),inch(11),foot(12),yard(13),mile(14)");
            lunit = in.nextInt();
            if (lunit < 0 || lunit > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while (lunit < 0 || lunit > 11);

        if (lunit == 0){
            outputval = inter/(10^6);
        } else if (lunit == 1) {
            outputval = inter/1000;
        } else if (lunit == 2) {
            outputval = inter/100;
        } else if (lunit == 3) {
            outputval = inter/10;
        } else if (lunit == 4) {
            outputval = inter;
        } else if (lunit == 5) {
            outputval = inter*10;
        } else if (lunit == 6) {
            outputval = inter*100;
        } else if (lunit == 7) {
            outputval = inter*1000;
        } else if (lunit == 8) {
            outputval = inter*(10^6);
        } else if (lunit == 9) {
            outputval = inter*(10^9);
        } else if (lunit == 10) {
            outputval = inter*(10^12);
        } else if (funit == 11) {
            outputval = inter*39.3701;
        } else if (funit == 12) {
            outputval = inter*3.2808;
        } else if (funit == 13) {
            outputval = inter*1.0936;
        } else {
            outputval = inter/1609;
        }

        System.out.println("Final Value is: " + outputval);
        return outputval;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mathcynthia);
        first_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        first_unit = (Spinner) findViewById(R.id.planets_spinner);
        first_unit_options = getResources().getStringArray(R.array.first_unit_lengths);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, first_unit_options);
        first_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        last_unit = (Spinner) findViewById(R.id.spinner);
        last_unit_options = getResources().getStringArray(R.array.first_unit_lengths);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, last_unit_options);
        last_unit.setAdapter(dataAdapter_out);
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
