package com.pb.kozina.hw10;

public class Double extends Number{
    protected double num2;

    public Double(double num) {
        super(num);
        this.num2 = num;
    }

    public int intValue() {
        return (int) this.num2;
    }

    public double doubleValue() {
        return  this.num2;
    }

    public float floatValue() {
        return (float) this.num2;
    }
}
