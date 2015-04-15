package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Created by ahoang on 4/10/15.
 */
public class PhysicsCindy extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physicscindy);
    }
    
  public static Scanner in = new Scanner(System.in);  
  static final double NA = 6.0221415*(10^13);
  
  public static double tommHg(double pi, int ui) {
    double mmHg;
    if (ui==1) {
      mmHg = pi;
    } else if (ui==2) {
      mmHg =  pi*0.0075006;
    } else if (ui==3) {
      mmHg = pi*759.9999520;
    } else {
      mmHg = pi*0.7355591;
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
    if (uf==1) {
      pf = p_aux;
    } else if (uf==2) { 
      pf = (p_aux/0.0075006);
    } else if (uf==3) {
      pf = (p_aux/759.9999520);
    } else if (uf==4) {
      pf = (p_aux/0.7355591);
    } else {
      System.out.println("invalid unit. try again.");
      pf = 0;
    } 
    System.out.println("Final value is " + pf);
    return pf;
  }
  
  
  
  public static double toSec(double ti, int ui) {
    double s;
    if (ui==1) {
      s = ti;
    } else if (ui==2) {
      s = ti*60;
    } else if (ui==3) {
      s = ti*60*60;
    } else if (ui==4) {
      s = ti*24*60*60;
    } else {
      s = ti*7*24*60*60;
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
     if (uf==1) {
       tf = t_aux;
     } else if (uf==2) {
       tf = t_aux/60;
     } else if (uf==3) {
       tf = t_aux/60/60;
     } else if (uf==4) {
       tf = t_aux/24/60/60;
     } else {
       tf = t_aux/7/24/60/60;
     }
     
    System.out.println("Final value is " + tf);
  }
  
  
  
  public static double toCelsius(double tempi, int ui) {
    double c = 0;
    if (ui==1) {
      c = tempi;
    } else if (ui==2) {
      c = tempi - 273.15;
    } else {
      c = tempi*9/5 + 32;
    }
    return c;
  }
  
  public static double convertTemp() {
    int ui, uf;
    double tempi, tempf = 0, temp_aux;
    
    //get initial unit
    do {
      System.out.println("Choose initial unit: celsius (1), Kelvin (2), fahrenheit (3)");
      ui = in.nextInt();
      if (ui < 1 || ui > 3)
        System.out.println("Invalid unit. Try again.");
    } while (ui < 1 || ui > 3);
      
    //convert to Celsius
    System.out.println("Initial value: ");
    tempi = in.nextDouble();
    temp_aux = toCelsius(tempi, ui);
    
    //get final unit
    do {
      System.out.println("Choose final unit: celsius (1), Kelvin (2), fahrenheit (3)");
      uf = in.nextInt();
      if (uf < 1 || uf > 3)
        System.out.println("Invalid unit. Try again.");
    } while (uf < 1 || uf > 3);
    
    //convert to final unit
    if (uf==1) {
      tempf = temp_aux;
    } else if (uf==2) {
      DecimalFormat df = new DecimalFormat(".##");
      tempf = Math.round((temp_aux + 273.150)*100.0)/100.0;
    } else {
      tempf = temp_aux*5/9 - 32;
    }   
    
    System.out.println("Final value is " + tempf);
    return tempf;
  }
  
  public static double toKg(double mi, int ui) {
    double kg = 0;
    if (ui==1) {
      kg = mi;
    } else if (ui==2) {
      kg = mi/2.20462;
    } else {
      kg = mi/9.80665;
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
    if (uf==1) {
      mf = m_aux;
    } else if (uf==2) {
      mf = m_aux*2.20462;
    } else {
      mf = m_aux*9.80665;
    }
    
    System.out.println("Final value is " + mf);
    return mf;
  }
  
  
  public static double toMol(double mi, int ui) {
    double mol = 0;
    if (ui==1) {
      mol = mi;
    } else if (ui==2) {
      mol = mi/NA;
    } else if (ui==3) {
      System.out.println("Volume in Liters: ");
      double vol = in.nextDouble();
      mol = mi*vol;
    } else {
      System.out.println("Atomic mass in kg");
      double am = in.nextDouble();
      mol = mi/am;
    }
    return mol;
  }
  
  public static double convertMole() {
    int ui, uf;
    double mi, mf = 0, m_aux;
    
    //get initial unit
    do {
      System.out.println("Choose initial unit: moles (1), molecules (2), molarity (3), kg (4)");
      ui = in.nextInt();
      if (ui < 1 || ui > 4)
        System.out.println("Invalid unit. Try again.");
    } while (ui < 1 || ui > 4);
      
    //convert to kg
    System.out.println("Initial value: ");
    mi = in.nextDouble();
    m_aux = toMol(mi, ui);
    
    //get final unit
    do {
      System.out.println("Choose final unit: moles (1), molecules (2), molarity (3)");
      uf = in.nextInt();
      if (uf < 1 || uf > 3)
        System.out.println("Invalid unit. Try again.");
    } while (uf < 1 || uf > 3);
    
    //convert to final unit
    if (uf==1) {
      mf = m_aux;
    } else if (uf==2) {
      mf = m_aux*NA;
    } else if (uf==3) {
      System.out.println("Volume in Liters: ");
      double vol = in.nextDouble();
      mf = mi*vol;
    } else {
      System.out.println("Atomic mass in kg");
      double am = in.nextDouble();
      mf = m_aux/am;
    }
    
    System.out.println("Final value is " + mf);
    return mf;
  }
  
  public static void main(String[] args) {
    System.out.println("What would you like to convert?");
    System.out.println("Choose one: pressure (1), time (2), temperature (3), mass/force (4), moles/molecules (5)");
    int convtype = in.nextInt();
    do {
      if (convtype==1) {
        convertPressure();
      } else if (convtype==2) {
        convertTime();
      } else if (convtype==3) {
        convertTemp();
      } else if (convtype==4) {
        convertMassForce();
      } else if (convtype==5) {
        convertMole();
      } else {
        System.out.println("Invalid input. Try again.");
      } 
    } while (convtype < 1 || convtype > 5);
  }
    
}
