package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cindy on 4/28/2015.
 */
public class ComputerNumbers extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private TextView output_value;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private String ui;
    private String uf;
    private Button switchButton;
    private TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_computer_numbers);
        input_value=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.number_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.number_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_value = (TextView) findViewById(R.id.finalAmount_text);

        convertbutton = (Button) findViewById(R.id.imageButton);

        numTextView = (TextView)findViewById(R.id.numberText);
        //set api string
        String temp;
        try {
            do {
                temp = new DownloadTask().execute().get();
            }while (temp.length() > 100);
        }
        catch(Exception e){
            temp = "Error, connection refused.";
            System.out.println("Error, connection refused.");
        }
        numTextView.setText(temp);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if text box is empty, do nothing
                if (TextUtils.isEmpty(input_value.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                ui = input_unit.getSelectedItem().toString();
                uf = output_unit.getSelectedItem().toString();
                if (ui.equals("Choose:") || uf.equals("Choose:")) {
                    Toast.makeText(getApplicationContext(), "Please choose units", Toast.LENGTH_SHORT).show();
                    return;
                }

                //binary
                if (ui.equals("Binary"))
                {
                    //check if binary
                    if(binaryInCheck(input_value.getText().toString()) == false){
                        Toast.makeText(getApplicationContext(), "Please enter 1s & 0s only", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Binary Bin_obj= new Binary(input_value.getText().toString());

                    if (uf.equals("Decimal"))
                    {
                        output_value.setText(Integer.toString(Bin_obj.BinToDec()));
                    }
                    else if (uf.equals("Binary"))
                    {
                        output_value.setText(Bin_obj.GetBin());
                    }
                    else if (uf.equals("Hexadecimal"))
                    {
                        output_value.setText(Bin_obj.BinToHex());
                    }
                    else if (uf.equals("Octal"))
                    {
                        output_value.setText(Bin_obj.BinToOct());
                    }
                }

                //decimal
                if (ui.equals( "Decimal"))
                {
                    //check if decimal
                    if(!decimalInCheck(input_value.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter positive integers only", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Decimal Dec_obj= new Decimal(Integer.parseInt(input_value.getText().toString()));
                    if (uf.equals("Decimal"))
                    {
                        output_value.setText(Integer.toString(Dec_obj.GetDec()));
                    }
                    else if (uf.equals("Binary"))
                    {
                        output_value.setText(Dec_obj.DecToBin());
                    }
                    else if (uf.equals("Hexadecimal"))
                    {
                        output_value.setText(Dec_obj.DecToHex());
                    }
                    else if (uf.equals("Octal"))
                    {
                        output_value.setText(Dec_obj.DecToOct());
                    }
                }
                //hexadecimal
                if (ui.equals( "Hexadecimal"))
                {
                    //check if hexadecimal
                    if(!hexaDecimalInCheck(input_value.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter 1-9 and a-f only", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Hexadecimal Hex_obj= new Hexadecimal(input_value.getText().toString());
                    if (uf.equals("Decimal"))
                    {
                        output_value.setText(Integer.toString(Hex_obj.HexToDec()));
                    }
                    else if (uf.equals("Binary"))
                    {
                        output_value.setText(Hex_obj.HexToBin());
                    }
                    else if (uf.equals("Hexadecimal"))
                    {
                        output_value.setText(Hex_obj.GetHex());
                    }
                    else if (uf.equals("Octal"))
                    {
                        output_value.setText(Hex_obj.HexToOct());
                    }
                }
                //octal
                if (ui.equals( "Octal"))
                {
                    //check if octal
                    if(!octalInCheck(input_value.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter 1-8 digits only", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Octal Oct_obj= new Octal(input_value.getText().toString());
                    if (uf.equals("Decimal"))
                    {
                        output_value.setText(Integer.toString(Oct_obj.OctToDec()));
                    }
                    else if (uf.equals("Binary"))
                    {
                        output_value.setText(Oct_obj.OctToBin());
                    }
                    else if (uf.equals("Hexadecimal"))
                    {
                        output_value.setText(Oct_obj.OctToHex());
                    }
                    else if (uf.equals("Octal"))
                    {
                        output_value.setText(Oct_obj.GetOct());
                    }
                }

            }
        });

        switchButton = (Button) findViewById(R.id.switchbutton);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1, p2;
                p1 = input_unit.getSelectedItemPosition();
                p2 = output_unit.getSelectedItemPosition();
                input_unit.setSelection(p2);
                output_unit.setSelection(p1);
            }
        });
    }

    //check binary input - return true if acceptable
    public boolean binaryInCheck(String s){
        try {
            int temp = Integer.parseInt(s, 2);
            if(temp < 0){
                return false;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Not Binary Format");
            return false;
        }
        return true;
    }

    //check decimal input - return true if acceptable
    public boolean decimalInCheck(String s){
        try {
            int temp = Integer.parseInt(s, 10);
            if(temp < 0){
                return false;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Not Decimal Format");
            return false;
        }
        return true;
    }

    //check hexadecimal input - return true if acceptable
    public boolean hexaDecimalInCheck(String s){
        try {
            int temp = Integer.parseInt(s, 16);
            if(temp < 0){
                return false;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Not hexaDecimal Format");
            return false;
        }
        return true;
    }

    //check octal input - return true if acceptable
    public boolean octalInCheck(String s){
        try {
            int temp = Integer.parseInt(s, 8);
            if(temp < 0){
                return false;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Not Octal Format");
            return false;
        }
        return true;
    }

}
