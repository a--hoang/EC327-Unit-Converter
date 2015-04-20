package com.example.ahoang.unitconverter;
import java.lang.*;
/**
 * Created by Joseph on 4/18/2015.
 */
public class Binary {
    public Binary(String input)
    {
        bin = input;
    }
    public int BinToDec()
    {
        int dec = Integer.parseInt(bin,2);

        return dec;
    }
    public String BinToHex()
    {
        int dec = Integer.parseInt(bin,2);
        String Hex = Integer.toString(dec,16);
        return Hex;
    }
    public String BinToOct()
    {
        int dec = Integer.parseInt(bin,2);
        String oct = Integer.toOctalString(dec);
        return oct;
    }
    public String GetBin()
    {
        return bin;
    }
    public void SetBin(String input)
    {
        bin = input;
    }
    private static String bin;
}
