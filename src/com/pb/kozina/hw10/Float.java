package com.pb.kozina.hw10;

public class Float extends Number{
    protected float num3;

    public Float(float num) {
        super(num);
        this.num3 = num;
    }

    public int intValue() {
        return (int) this.num3;
    }

    public double doubleValue() {
        return (double) this.num3;
    }

    public float floatValue() {
        return  this.num3;
    }

}
