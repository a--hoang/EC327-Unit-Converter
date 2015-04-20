package com.example.ahoang.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import java.util.Arrays;
import android.widget.AdapterView;
import android.widget.AdapterView.*;


/**
 * Created by ahoang on 4/10/15.
 */
public class ComputerJP extends Activity {

    EditText Input_val,Output_val;
    Spinner Input_spin,Output_spin;
    String [] comp_list,bit_list,num_list;
    String Input_unit, Output_unit,Input_data,Output_data;
    Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_computerjp);
        //define comp_list from the strings.xml
        comp_list = getResources().getStringArray(R.array.comp_list);
        bit_list = Arrays.copyOfRange(comp_list,0,6);
        num_list = Arrays.copyOfRange(comp_list,6,10);

        // define all text fields and spinners
        Input_spin = (Spinner) findViewById(R.id.input_spinner);
        Output_spin = (Spinner) findViewById(R.id.output_spinner);

        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, comp_list);
        Input_spin.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adjust the second spinner relative to what is selected in the first spinner
        Input_spin.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long id) {

                if(position < 6)
                {
                    ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,bit_list);
                    Output_spin.setAdapter(dataAdapter_out);
                }
                else if(position > 5)
                {
                    ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,num_list);
                    Output_spin.setAdapter(dataAdapter_out);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        Input_val = (EditText) findViewById(R.id.input_text);
        Output_val = (EditText) findViewById(R.id.output_text);
        //conversions -- couldn't find a better way other than straight if chaining
        convert = (Button) findViewById(R.id.button1);
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Input_unit = Input_spin.getSelectedItem().toString();
                Output_unit = Output_spin.getSelectedItem().toString();
                //binary
                if (Input_unit.equals( "Binary"))
                {
                    Binary Bin_obj= new Binary(Input_val.getText().toString());
                    if (Output_unit.equals("Decimal"))
                    {
                        Output_val.setText(Integer.toString(Bin_obj.BinToDec()));
                    }
                    else if (Output_unit.equals("Binary"))
                    {
                        Output_val.setText(Bin_obj.GetBin());
                    }
                    else if (Output_unit.equals("Hexadecimal"))
                    {
                        Output_val.setText(Bin_obj.BinToHex());
                    }
                    else if (Output_unit.equals("Octal"))
                    {
                        Output_val.setText(Bin_obj.BinToOct());
                    }
                }
                //decimal
                if (Input_unit.equals( "Decimal"))
                {
                    Decimal Dec_obj= new Decimal(Integer.parseInt(Input_val.getText().toString()));
                    if (Output_unit.equals("Decimal"))
                    {
                        Output_val.setText(Integer.toString(Dec_obj.GetDec()));
                    }
                    else if (Output_unit.equals("Binary"))
                    {
                        Output_val.setText(Dec_obj.DecToBin());
                    }
                    else if (Output_unit.equals("Hexadecimal"))
                    {
                        Output_val.setText(Dec_obj.DecToHex());
                    }
                    else if (Output_unit.equals("Octal"))
                    {
                        Output_val.setText(Dec_obj.DecToOct());
                    }
                }
                //hexadecimal
                if (Input_unit.equals( "Hexadecimal"))
                {
                    Hexadecimal Hex_obj= new Hexadecimal(Input_val.getText().toString());
                    if (Output_unit.equals("Decimal"))
                    {
                        Output_val.setText(Integer.toString(Hex_obj.HexToDec()));
                    }
                    else if (Output_unit.equals("Binary"))
                    {
                        Output_val.setText(Hex_obj.HexToBin());
                    }
                    else if (Output_unit.equals("Hexadecimal"))
                    {
                        Output_val.setText(Hex_obj.GetHex());
                    }
                    else if (Output_unit.equals("Octal"))
                    {
                        Output_val.setText(Hex_obj.HexToOct());
                    }
                }
                //octal
                if (Input_unit.equals( "Octal"))
                {
                    Octal Oct_obj= new Octal(Input_val.getText().toString());
                    // CONVERSIONS FAIL FOR 8-9 in single digit place -- TODO implement error check for octal input
                    if (Output_unit.equals("Decimal"))
                    {
                        Output_val.setText(Integer.toString(Oct_obj.OctToDec()));
                    }
                    else if (Output_unit.equals("Binary"))
                    {
                       Output_val.setText(Oct_obj.OctToBin());
                    }
                    else if (Output_unit.equals("Hexadecimal"))
                    {
                        Output_val.setText(Oct_obj.OctToHex());
                    }
                    else if (Output_unit.equals("Octal"))
                    {
                        Output_val.setText(Oct_obj.GetOct());
                    }
                }
                //bits
                if (Input_unit.equals( "Bits"))
                {
                    Bits Bit_obj= new Bits(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.GetBits()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsTokb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Bit_obj.BitsToMB()));
                    }
                }
                //Bytes
                if (Input_unit.equals( "Bytes"))
                {
                    Bytes Byte_obj= new Bytes(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToBits()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.GetBytes()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesTokb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Byte_obj.BytesToMB()));
                    }
                }
                //KiloBits
                if (Input_unit.equals( "KiloBits"))
                {
                    KiloBits kb_obj= new KiloBits(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToBit()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.Getkb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMB()));
                    }
                }
                //KiloBytes
                if (Input_unit.equals( "KiloBits"))
                {
                    KiloBits kb_obj= new KiloBits(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToBit()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.Getkb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(kb_obj.kbToMB()));
                    }
                }
                //KiloBytes
                if (Input_unit.equals( "KiloBytes"))
                {
                    KiloBytes kB_obj= new KiloBytes(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToBit()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBTokb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.GetkB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(kB_obj.kBToMB()));
                    }
                }
                //MegaBits
                if (Input_unit.equals( "MegaBits"))
                {
                    MegaBits Mb_obj= new MegaBits(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToBit()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbTokb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.GetMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(Mb_obj.MbToMB()));
                    }
                }
                //MegaBytes
                if (Input_unit.equals( "MegaBytes"))
                {
                    MegaBytes MB_obj= new MegaBytes(Double.parseDouble(Input_val.getText().toString()));
                    if (Output_unit.equals("Bits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToBit()));
                    }
                    else if (Output_unit.equals("Bytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToByte()));
                    }
                    else if (Output_unit.equals("KiloBits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBTokb()));
                    }
                    else if (Output_unit.equals("KiloBytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBTokB()));
                    }
                    else if (Output_unit.equals("MegaBits"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToMb()));
                    }
                    else if (Output_unit.equals("MegaBytes"))
                    {
                        Output_val.setText(String.valueOf(MB_obj.MBToMb()));
                    }
                }






            }
        });





    }

}


