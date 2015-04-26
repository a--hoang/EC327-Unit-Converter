package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/19/2015.
 */
public class Decimal {
    public Decimal(int input)
    {
        dec = input;
    }
    public String DecToBin()
    {
        return Integer.toBinaryString(dec);
    }
    public String DecToHex()
    {
        return Integer.toHexString(dec);
    }
    public String DecToOct()
    {
        return Integer.toOctalString(dec);
    }
    public int GetDec()
    {
        return dec;
    }
    public void SetDec(int input)
    {
        dec = input;
    }
    private static int dec;
}
