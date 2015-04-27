package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathCynthia extends Activity implements View.OnClickListener{

    private Button buttonAngle;
    private Button buttonArea;
    private Button buttonLength;
    private Button buttonVolume;

    private TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathcynthia);

        buttonAngle = (Button) findViewById(R.id.button);
        buttonArea = (Button) findViewById(R.id.button2);
        buttonLength = (Button) findViewById(R.id.button3);
        buttonVolume = (Button) findViewById(R.id.button4);

        buttonAngle.setOnClickListener(this);
        buttonArea.setOnClickListener(this);
        buttonLength.setOnClickListener(this);
        buttonVolume.setOnClickListener(this);

        //Populate random fact box
        numTextView = (TextView)findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 110);
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
            Intent resultActivity = new Intent(MathCynthia.this, MathCynthia_angle.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button2)
        {
            Intent resultActivity = new Intent(MathCynthia.this, MathCynthia_area.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button3)
        {
            Intent resultActivity = new Intent(MathCynthia.this, MathCynthia_length.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.button4)
        {
            Intent resultActivity = new Intent(MathCynthia.this, MathCynthia_volume.class);
            startActivity(resultActivity);
        }
    }

}
