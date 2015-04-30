package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by ahoang on 4/10/15.
 */
public class PhysicsCindy extends Activity implements View.OnClickListener{

    private Button buttonTemp;
    private Button buttonPressure;
    private Button buttonTime;
    private Button buttonMassForce;
    private Button buttonMol;

    private TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physicscindy);

        buttonTemp = (Button) findViewById(R.id.button);
        buttonPressure = (Button) findViewById(R.id.button2);
        buttonTime = (Button) findViewById(R.id.button3);
        buttonMassForce = (Button) findViewById(R.id.button4);
        buttonMol = (Button) findViewById(R.id.button5);

        buttonTemp.setOnClickListener(this);
        buttonPressure.setOnClickListener(this);
        buttonTime.setOnClickListener(this);
        buttonMassForce.setOnClickListener(this);
        buttonMol.setOnClickListener(this);


        //Populate random fact box
        numTextView = (TextView)findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 90);
        }
        catch(Exception e){
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);

    }
    public void onClick(View v) {
        if(v.getId() == R.id.button)
        {
            Intent resultActivity = new Intent(PhysicsCindy.this, PhysicsTemp.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button2)
        {
            Intent resultActivity = new Intent(PhysicsCindy.this, PhysicsPressure.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button3)
        {
            Intent resultActivity = new Intent(PhysicsCindy.this, PhysicsTime.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button4)
        {
            Intent resultActivity = new Intent(PhysicsCindy.this, PhysicsMassForce.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button5)
        {
            Intent resultActivity = new Intent(PhysicsCindy.this, PhysicsMol.class);
            startActivity(resultActivity);
        }
    }
}


