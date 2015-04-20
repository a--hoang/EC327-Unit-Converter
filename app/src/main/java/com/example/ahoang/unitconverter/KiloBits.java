package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class KiloBits {
    public KiloBits(double input)
    {
        kb = input;
    }
    public double kbToMb()
    {
        return kb*0.0001220703125;
    }
    public double kbToMB()
    {
        return kb*0.0009765625;
    }
    public double kbTokB()
    {
        return kb*0.125;
    }
    public double kbToBit()
    {
        return kb*1024;
    }
    public double kbToByte()
    {
        return kb*128;
    }
    public double Getkb()
    {
        return kb;
    }
    public void Setkb(double input)
    {
        kb = input;
    }
    private static double kb;
}
