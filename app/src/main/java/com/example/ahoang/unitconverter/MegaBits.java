package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class MegaBits {
    public MegaBits(double input)
    {
        Mb = input;
    }
    public double MbToMB()
    {
        return Mb*0.125;
    }
    public double MbTokb()
    {
        return Mb*1024;
    }
    public double MbTokB()
    {
        return Mb*128;
    }
    public double MbToBit()
    {
        return Mb*1048576;
    }
    public double MbToByte()
    {
        return Mb*131072;
    }
    public double GetMb()
    {
        return Mb;
    }
    public void SetMb(double input)
    {
        Mb = input;
    }
    private static double Mb;
}
