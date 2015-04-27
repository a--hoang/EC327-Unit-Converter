package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class MegaBytes {
    public MegaBytes(double input)
    {
        MB = input;
    }
    public double MBToMb()
    {
        return MB*8;
    }
    public double MBTokb()
    {
        return MB*8192;
    }
    public double MBTokB()
    {
        return MB*1024;
    }
    public double MBToBit()
    {
        return MB*8388608;
    }
    public double MBToByte()
    {
        return MB*1048576;
    }
    public double GetMB()
    {
        return MB;
    }
    public void SetMB(double input)
    {
        MB = input;
    }
    private static double MB;
}
