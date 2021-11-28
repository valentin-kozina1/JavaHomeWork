package com.pb.kozina.hw10;

public  class Number {
    protected int num1;
    protected double num2;
    protected float  num3;

    public Number(int num) {
        this.num1 = num;
    }
    public Number(double num) {
        this.num2 = num;
    }
    public Number(float num) {
        this.num3 = num;
    }

    public int intValue() {
        return this.num1;
    }

    public double doubleValue() { System.out.println(" sdf " + this.num1);
        return  this.num2;
    }

    public float floatValue() {
        return this.num3;
    }

}
