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

public class MathCynthia_area extends Activity{
    public static Scanner in = new Scanner(System.in);
    private Spinner first_unit;
    private Spinner last_unit;
    private Button convertbutton;
    private EditText first_value;
    private String [] first_unit_options;
    private String [] last_unit_options;

    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    public static double tomarea(double area, int m){
        double meter;
        if (m == 1){
            meter = Math.sqrt(area)/39.3701;
        } else if (m == 2){
            meter = Math.sqrt(area)/3.2808;
        } else if (m == 3){
            meter = Math.sqrt(area)/1.0936;
        } else if (m == 4){
            meter = Math.sqrt(area)*1609;
        } else if (m == 5){
            meter = Math.sqrt(area)/1000;
        } else if (m == 6){
            meter = Math.sqrt(area)/100;
        } else if (m == 7){
            meter = Math.sqrt(area);
        } else {
            meter = Math.sqrt(area)*1000;
        }

        return meter;
    }
    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    public static double convertArea(){
        int fs, ls;
        double fb, mb, lb;

        do {
            System.out.println("First Unit: Inch(1),Foot(2),Yard(3),Mile(4),Millimeter(5),Centimeter(6),Meter(7),Kilometer(8)");
            fs = in.nextInt();
            if (fs < 1 || fs > 8)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while (fs < 1 || fs > 8);

        System.out.println("Initial Area: ");
        fb = in.nextDouble();
        mb = tomarea(fb,fs);

        do {
            System.out.println("Final Unit: Inch(1),Foot(2),Yard(3),Mile(4),Millimeter(5),Centimeter(6),Meter(7),Kilometer(8)");
            ls = in.nextInt();
            if (ls < 1 || ls > 8) {
                System.out.println("Invalid Input. Try again.");
            }
        } while (ls < 1 || ls > 8);

        if (ls == 1){
            lb = Math.pow((mb*39.3701),2);
        } else if (ls == 2){
            lb = Math.pow((mb*3.2808),2);
        } else if (ls == 3){
            lb = Math.pow((mb*1.0936),2);
        } else if (ls == 4){
            lb = Math.pow((mb/1609),2);
        } else if (ls == 5){
            lb = Math.pow((mb*1000),2);
        } else if (ls == 6){
            lb = Math.pow((mb*100),2);
        } else if (ls == 7){
            lb = Math.pow(mb,2);
        } else {
            lb = Math.pow((mb/1000),2);
        }

        System.out.println("Final Value is: " + lb);
        return lb;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mathcynthia);
        first_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        first_unit = (Spinner) findViewById(R.id.planets_spinner);
        first_unit_options = getResources().getStringArray(R.array.first_unit_area_volume);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, first_unit_options);
        first_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        last_unit = (Spinner) findViewById(R.id.spinner);
        last_unit_options = getResources().getStringArray(R.array.first_unit_area_volume);
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
