package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by ahoang on 4/10/15.
 */
public class PhysicsCindy extends Activity implements View.OnClickListener{

    private Button buttonTemp;
    private Button buttonPressure;
    private Button buttonTime;
    private Button buttonMassForce;
    private Button buttonMol;


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


