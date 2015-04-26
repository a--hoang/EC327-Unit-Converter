package com.example.ahoang.unitconverter;

/**
 * Created by Joseph on 4/20/2015.
 */
public class KiloBytes {
    public KiloBytes(double input)
    {
        kB = input;
    }
    public double kBToMb()
    {
        return kB*0.0078125;
    }
    public double kBToMB()
    {
        return kB*0.0009765625;
    }
    public double kBTokb()
    {
        return kB*8;
    }
    public double kBToBit()
    {
        return kB*8192;
    }
    public double kBToByte()
    {
        return kB*1024;
    }
    public double GetkB()
    {
        return kB;
    }
    public void SetkB(double input)
    {
        kB = input;
    }
    private static double kB;
}
