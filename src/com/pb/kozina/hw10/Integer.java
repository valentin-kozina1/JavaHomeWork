package com.pb.kozina.hw10;

public class Integer extends Number{
    protected int num1;

    public Integer(int num) {
       super(num);
        this.num1 = num;
    }

     public int intValue() {
        return this.num1;
    }

    public double doubleValue() {
        return (double) this.num1;
    }

    public float floatValue() {
        return (float) this.num1;
    }
}
