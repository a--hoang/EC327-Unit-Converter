package com.example.ahoang.unitconverter;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends ActionBarActivity implements View.OnClickListener, View.OnTouchListener{

    private TextView numTextView;

    //Creating ImageButton objects, which extend (inherit) the View class - used to navigate
    private ImageButton buttonMarta;
    private ImageButton buttonCynthia;
    private ImageButton buttonJP;
    private ImageButton buttonCindy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        buttonMarta = (ImageButton) findViewById(R.id.martaButton);
        buttonCynthia = (ImageButton) findViewById(R.id.cynthiaButton);
        buttonJP = (ImageButton) findViewById(R.id.jpButton);
        buttonCindy = (ImageButton) findViewById(R.id.cindyButton);


        buttonMarta.setOnClickListener(this);
        buttonCynthia.setOnClickListener(this);
        buttonJP.setOnClickListener(this);
        buttonCindy.setOnClickListener(this);

        buttonMarta.setOnTouchListener(this);
        buttonCynthia.setOnTouchListener(this);
        buttonJP.setOnTouchListener(this);
        buttonCindy.setOnTouchListener(this);

        numTextView = (TextView)findViewById(R.id.numberText);
//        //set api string - removed due to API failure
//        String temp;
//        try {
//            do {
//                temp = new DownloadTask().execute().get();
//            }while (temp.length() > 120);
//        }
//        catch(Exception e){
//            temp = "Error, connection refused.";
//            System.out.println("Error, connection refused.");
//        }

        //catfacts

        String temp;
        try{
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 100);
        }
        catch(Exception e){
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);
    }

    @Override public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                v.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                v.getBackground().clearColorFilter();
                v.invalidate();
                break;
            }
        }
        return false;
    }

    @Override public void onClick(View v) {
        if(v.getId() == R.id.martaButton)
        {
            Intent resultActivity = new Intent(Home.this, CookingMarta.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.cynthiaButton)
        {
            Intent resultActivity = new Intent(Home.this, MathCynthia.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.jpButton)
        {
            Intent resultActivity = new Intent(Home.this, ComputerJP.class);
            startActivity(resultActivity);
        }
        else if (v.getId() == R.id.cindyButton)
        {
            Intent resultActivity = new Intent(Home.this, PhysicsCindy.class);
            startActivity(resultActivity);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
}
