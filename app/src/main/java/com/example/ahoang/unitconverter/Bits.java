package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class Bits {
    public Bits(double input)
    {
        bits = input;
    }
    public double BitsToMb()
    {
        return bits*0.00000095367431640625;
    }
    public double BitsToMB()
    {
        return bits*0.000000119209289550781;
    }
    public double BitsTokB()
    {
        return bits*0.0001220703125;
    }
    public double BitsTokb()
    {
        return bits*0.0009765625;
    }
    public double BitsToByte()
    {
        return bits*0.125;
    }
    public double GetBits()
    {
        return bits;
    }
    public void SetBits(double input)
    {
        bits = input;
    }
    private static double bits;
}
