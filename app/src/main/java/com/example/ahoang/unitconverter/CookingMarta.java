package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Scanner;


public class CookingMarta extends Activity implements View.OnClickListener {

    public static Scanner in = new Scanner(System.in);

    //Creating ImageButton objects, which extend (inherit) the View class - used to navigate
    private Button buttonliquid;
    private Button buttonsolid;
    private Button buttonoventemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cookingmarta);

        buttonliquid = (Button) findViewById(R.id.button3);
        buttonsolid = (Button) findViewById(R.id.button2);
        buttonoventemp = (Button) findViewById(R.id.button4);

        buttonliquid.setOnClickListener(this);
        buttonsolid.setOnClickListener(this);
        buttonoventemp.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_liquid.class);
            startActivity(resultActivity);
        } else if (v.getId() == R.id.button2) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_solid.class);
            startActivity(resultActivity);
        } else if (v.getId() == R.id.button4) {
            Intent resultActivity = new Intent(CookingMarta.this, CookingMarta_oventemp.class);
            startActivity(resultActivity);
        }
    }

            /*
             @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   */
}