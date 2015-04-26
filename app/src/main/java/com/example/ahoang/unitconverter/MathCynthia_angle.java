package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Scanner;


public class MathCynthia_angle extends Activity {

    public static Scanner in = new Scanner(System.in);
    private Spinner first_unit;
    private Spinner last_unit;
    private Button convertbutton;
    private EditText first_value;
    private String [] first_unit_options;
    private String [] last_unit_options;

    //1 = deg, 2 = rad
    public static double todeg(double input, int funit) {
        double angle;
        if (funit == 1){
            angle = input;
        } else {
            angle = (180/Math.PI)*input;
        }
        return angle;
    }

    public static double convertAngle(){
        int fv, lv;
        double fa, ma, la;

        do {
            System.out.println("First Version: Degree (1), Radian (2)");
            fv = in.nextInt();
            if (fv < 0 || fv > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while (fv < 0 || fv > 11);

        System.out.println("Initial Angle: ");
        fa = in.nextDouble();
        ma = todeg(fa,fv);

        do {
            System.out.println("First Version: Degree (1), Radian (2)");
            lv = in.nextInt();
            if (lv < 0 || lv > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while (lv < 0 || lv > 11);

        if (lv == 1){
            la = ma;
        } else {
            la = (180/Math.PI)*ma;
        }
        System.out.println("Final Value is: " + la);
        return la;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mathcynthia);
        first_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        first_unit = (Spinner) findViewById(R.id.planets_spinner);
        first_unit_options = getResources().getStringArray(R.array.first_unit_angles);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, first_unit_options);
        first_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        last_unit = (Spinner) findViewById(R.id.spinner);
        last_unit_options = getResources().getStringArray(R.array.first_unit_angles);
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
