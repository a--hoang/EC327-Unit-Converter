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
public class ComputerBits extends Activity {

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText Input_val;
    private TextView Output_val;
    private String [] input_unit_options;
    private String [] output_unit_options;
    private String ui;
    private String uf;
    private Button switchButton;
    private TextView numTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_computer_bits);
        Input_val=(EditText) findViewById(R.id.editText);

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.bits_types);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.planets2_spinner);
        output_unit_options = getResources().getStringArray(R.array.bits_types);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Output_val = (TextView) findViewById(R.id.finalAmount_text);

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

                if (TextUtils.isEmpty(Input_val.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                ui = input_unit.getSelectedItem().toString();
                uf = output_unit.getSelectedItem().toString();
                if (ui.equals("Choose") || uf.equals("Choose")) {
                    Toast.makeText(getApplicationContext(), "Please choose units", Toast.LENGTH_SHORT).show();
                    return;
                }


                //bits
                if (ui.equals( "Bits"))
                {
                    Bits Bit_obj= new Bits(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.GetBits()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToByte()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsTokb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsTokB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToMB()));
                    }
                }
                //Bytes
                if (ui.equals( "Bytes"))
                {
                    Bytes Byte_obj= new Bytes(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToBits()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.GetBytes()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesTokb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesTokB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToMB()));
                    }
                }
                //KiloBits
                if (ui.equals( "KiloBits"))
                {
                    KiloBits kb_obj= new KiloBits(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToBit()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToByte()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.Getkb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbTokB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMB()));
                    }
                }

                //KiloBytes
                if (ui.equals( "KiloBytes"))
                {
                    KiloBytes kB_obj= new KiloBytes(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToBit()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToByte()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBTokb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.GetkB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToMB()));
                    }
                }
                //MegaBits
                if (ui.equals( "MegaBits"))
                {
                    MegaBits Mb_obj= new MegaBits(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToBit()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToByte()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbTokb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbTokB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.GetMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToMB()));
                    }
                }
                //MegaBytes
                if (ui.equals( "MegaBytes"))
                {
                    MegaBytes MB_obj= new MegaBytes(Double.parseDouble(Input_val.getText().toString()));
                    if (uf.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToBit()));
                    }
                    else if (uf.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToByte()));
                    }
                    else if (uf.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBTokb()));
                    }
                    else if (uf.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBTokB()));
                    }
                    else if (uf.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToMb()));
                    }
                    else if (uf.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToMb()));
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
}
