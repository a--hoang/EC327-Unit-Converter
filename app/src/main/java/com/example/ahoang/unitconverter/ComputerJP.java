package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jpaftring, ahoang on 4/10/15.
 */
public class ComputerJP extends Activity implements View.OnClickListener{

    private Button buttonBits;
    private Button buttonNumbers;

    TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computerjp);

        buttonBits = (Button) findViewById(R.id.button);
        buttonNumbers = (Button) findViewById(R.id.button2);

        buttonBits.setOnClickListener(this);
        buttonNumbers.setOnClickListener(this);

        //Populate random fact box
        numTextView = (TextView) findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            } while (temp.length() > 90);
        } catch (Exception e) {
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent resultActivity = new Intent(ComputerJP.this, ComputerBits.class);
            startActivity(resultActivity);
        } else if (v.getId() == R.id.button2) {
            Intent resultActivity = new Intent(ComputerJP.this, ComputerNumbers.class);
            startActivity(resultActivity);
        }
    }
}
