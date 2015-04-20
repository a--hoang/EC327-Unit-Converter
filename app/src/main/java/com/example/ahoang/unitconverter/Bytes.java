package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class Bytes {
    public Bytes(double input)
    {
        Bytes = input;
    }
    public double BytesToMb()
    {
        return Bytes*0.00000762939453125;
    }
    public double BytesToMB()
    {
        return Bytes*0.00000095367431640625;
    }
    public double BytesTokB()
    {
        return Bytes*0.0009765625;
    }
    public double BytesTokb()
    {
        return Bytes*0.0078125;
    }
    public double BytesToBits()
    {
        return Bytes*8;
    }
    public double GetBytes()
    {
        return Bytes;
    }
    public void SetBytes(double input)
    {
        Bytes = input;
    }
    private static double Bytes;
}
