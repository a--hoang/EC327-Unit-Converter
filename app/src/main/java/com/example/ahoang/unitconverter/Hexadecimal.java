package com.example.ahoang.unitconverter;
/**
 * Created by Joseph on 4/19/2015.
 */
public class Hexadecimal {
    public Hexadecimal(String input)
    {
        Hex = input;
    }
    public String HexToBin()
    {
        int dec = Integer.parseInt(Hex, 16);
        String bin = Integer.toBinaryString(dec);
        return bin;
    }
    public int HexToDec()
    {
        return Integer.parseInt(Hex, 16 );
    }
    public String HexToOct()
    {
        return Integer.toOctalString(Integer.parseInt(Hex, 16)); //  convert to decimal then to octal string -> int -> string
    }
    public String GetHex()
    {
        return Hex;
    }
    public void SetHex(String input)
    {
        Hex = input;
    }
    private static String Hex;
}
