package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import java.util.Scanner;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MathCynthia extends Activity {

    public static Scanner in = new Scanner(System.in);

    private Spinner first_unit;
    private Spinner last_unit;
    private Button convertbutton;
    private EditText first_value;
    private String string_first_value;
    private double double_first_value;
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

    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    public static double tomvolume(double volume, int p){
        double meter;
        if (p == 1){
            meter = Math.pow(volume, (1/3))/39.3701;
        } else if (p == 2){
            meter = Math.pow(volume, (1/3))/3.2808;
        } else if (p == 3){
            meter = Math.pow(volume, (1/3))/1.0936;
        } else if (p == 4){
            meter = Math.pow(volume, (1/3))*1609;
        } else if (p == 5){
            meter = Math.pow(volume, (1/3))/1000;
        } else if (p == 6){
            meter = Math.pow(volume, (1/3))/100;
        } else if (p == 7){
            meter = Math.pow(volume, (1/3));
        } else {
            meter = Math.pow(volume, (1/3))*1000;
        }

        return meter;
    }
    //1 = inch, 2 = foot, 3 = yard, 4 = mile, 5 = mm, 6 = cm, 7 = m, 8 = km
    public static double convertVolume(){
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

        System.out.println("Initial Volume: ");
        fb = in.nextDouble();
        mb = tomvolume(fb,fs);

        do {
            System.out.println("Final Unit: Inch(1),Foot(2),Yard(3),Mile(4),Millimeter(5),Centimeter(6),Meter(7),Kilometer(8)");
            ls = in.nextInt();
            if (ls < 1 || ls > 8) {
                System.out.println("Invalid Input. Try again.");
            }
        } while (ls < 1 || ls > 8);

        if (ls == 1){
            lb = Math.pow((mb*39.3701),3);
        } else if (ls == 2){
            lb = Math.pow((mb*3.2808),3);
        } else if (ls == 3){
            lb = Math.pow((mb*1.0936),3);
        } else if (ls == 4){
            lb = Math.pow((mb/1609),3);
        } else if (ls == 5){
            lb = Math.pow((mb*1000),3);
        } else if (ls == 6){
            lb = Math.pow((mb*100),3);
        } else if (ls == 7){
            lb = Math.pow(mb,3);
        } else {
            lb = Math.pow((mb/1000),3);
        }

        System.out.println("Final Value is: " + lb);
        return lb;
    }

    public static void quad(){
        int a, b, c;
        double r1, r2;

        System.out.println("Please enter the first coefficient: ");
        a = in.nextInt();

        System.out.println("Please enter the second coefficient: ");
        b = in.nextInt();

        System.out.println("Please enter the third coefficient: ");
        c = in.nextInt();

        if ((Math.pow(b,2) - (4*a*c)) < 0){
            System.out.println("The roots of this equation are complex.");
        } else {
            r1 = (-b + Math.sqrt(Math.pow(b,2)-(4*a*c)))/2;
            r2 = (-b - Math.sqrt(Math.pow(b,2)-(4*a*c)))/2;

            System.out.println("The roots of this quadratic equation are: " + r1 + "and" + r2);
        }
    }

    public static void main(String[] args){
        System.out.println("What would you like to do: ");
        System.out.println("Convert Length (1), Convert Angle (2), Quadratic Formula (3), Convert Area (4), Convert Volume (5)");
        int task = in.nextInt();

        do {
            if (task == 1){
                convertLen();
            } else if (task == 2){
                convertAngle();
            } else if (task == 3){
                quad();
            } else if (task == 4){
                convertArea();
            } else {
                convertVolume();
            }
        } while (task < 1 || task > 5);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mathcynthia);
        first_value=(EditText) findViewById(R.id.editText);
        string_first_value = first_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Drop down menu
        first_unit = (Spinner) findViewById(R.id.planets_spinner);
        first_unit_options = getResources().getStringArray(R.array.math_first_unit_options);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, first_unit_options);
        first_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        last_unit = (Spinner) findViewById(R.id.spinner);
        last_unit_options = getResources().getStringArray(R.array.math_last_unit_options);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, last_unit_options);
        last_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        convertbutton = (Button) findViewById(R.id.button);

        convertbutton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }
}
