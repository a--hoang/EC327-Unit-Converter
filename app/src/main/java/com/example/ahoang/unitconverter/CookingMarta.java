package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Scanner;


public class CookingMarta extends Activity implements View.OnClickListener {

    public static Scanner in = new Scanner(System.in);

    //Creating ImageButton objects, which extend (inherit) the View class - used to navigate
    private Button buttonliquid;
    private Button buttonsolid;
    private Button buttonoventemp;
    private TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cookingmarta);

        buttonliquid = (Button) findViewById(R.id.button1);
        buttonsolid = (Button) findViewById(R.id.button2);
        buttonoventemp = (Button) findViewById(R.id.button3);

        buttonliquid.setOnClickListener(this);
        buttonsolid.setOnClickListener(this);
        buttonoventemp.setOnClickListener(this);

        //Populate random fact box
        numTextView = (TextView)findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 130);
        }
        catch(Exception e){
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);
    }

    @Override public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_liquid.class);
            startActivity(resultActivity);
        } else if (v.getId() == R.id.button2) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_solid.class);
            startActivity(resultActivity);
        } else if (v.getId() == R.id.button3) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_oventemp.class);
            startActivity(resultActivity);
        }
    }
}