package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/19/2015.
 */
public class Octal {
    public Octal(String input)
    {
        Oct = input;
    }
    public String OctToBin()
    {
        int dec = Integer.parseInt(Oct, 8);//convert to dec
        String bin = Integer.toBinaryString(dec);//convert to binary
        return bin;
    }
    public int OctToDec()
    {
        return Integer.parseInt(Oct, 8);
    }
    public String OctToHex()
    {
        int dec = Integer.parseInt(Oct , 8); //conver to decimal
        return Integer.toString(dec,(int)16); //convert to octal
    }
    public String GetOct()
    {
        return Oct;
    }
    public void SetOct(String input)
    {
        Oct = input;
    }
    private static String Oct;
}
