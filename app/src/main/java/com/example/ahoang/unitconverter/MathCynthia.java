package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import java.util.Scanner;

public class MathCynthia extends Activity {

    public static Scanner in = new Scanner(System.in);

    //0=Mm,1=km,2=hm,3=dm,4=m,5=dim,6=cm,7=mm,8=um,9=nm,10=pm
    public static double tometer(double value,int n) {
        double con;
        if (n == 0){
            con = value/(10^6);
        } else if (n == 1) {
            con = value/1000;
        } else if (n == 2) {
            con = value/100;
        } else if (n == 3) {
            con = value/10;
        } else if (n == 4) {
            con = value;
        } else if (n == 5) {
            con = value*10;
        } else if (n == 6) {
            con = value*100;
        } else if (n == 7) {
            con = value*1000;
        } else if (n == 8) {
            con = value*(10^6);
        } else if (n == 9) {
            con = value*(10^9);
        } else {
            con = value*(10^12);
        }
        return con;
    }

    public static double convertLen(){
        int fu,lu;
        double fl,ml,ll;

        do {
            System.out.println("First Unit: Mm(0),km(1),hm(2),dm(3),m(4),dim(5),cm(6),mm(7),um(8),nm(9),pm(10)");
            fu = in.nextInt();
            if (fu < 0 || fu > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while(fu < 0 || fu > 11);

        System.out.println("Initial length value: ");
        fl = in.nextDouble();
        ml = tometer(fl,fu);

        do {
            System.out.println("Final Unit: Mm(0),km(1),hm(2),dm(3),m(4),dim(5),cm(6),mm(7),um(8),nm(9),pm(10)");
            lu = in.nextInt();
            if (lu < 0 || lu > 11)
            {
                System.out.println("Invalid Input. Try again.");
            }
        } while (lu < 0 || lu > 11);

        if (lu == 0){
            ll = ml/(10^6);
        } else if (lu == 1) {
            ll = ml/1000;
        } else if (lu == 2) {
            ll = ml/100;
        } else if (lu == 3) {
            ll = ml/10;
        } else if (lu == 4) {
            ll = ml;
        } else if (lu == 5) {
            ll = ml*10;
        } else if (lu == 6) {
            ll = ml*100;
        } else if (lu == 7) {
            ll = ml*1000;
        } else if (lu == 8) {
            ll = ml*(10^6);
        } else if (lu == 9) {
            ll = ml*(10^9);
        } else {
            ll = ml*(10^12);
        }

        System.out.println("Final Value is: " + ll);
        return ll;
    }

    //1 = deg, 2 = rad
    public static double todeg(double value, int n) {
        double angle;
        if (n == 1){
            angle = value;
        } else {
            angle = (180/Math.PI)*value;
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
        System.out.println("Convert Length (1), Convert Angle (2), Quadratic Formula (3)");
        int task = in.nextInt();

        do {
            if (task == 1){
                convertLen();
            } else if (task == 2){
                convertAngle();
            } else {
                quad();
            }
        } while (task < 1 || task > 3);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mathcynthia);

    }
}
