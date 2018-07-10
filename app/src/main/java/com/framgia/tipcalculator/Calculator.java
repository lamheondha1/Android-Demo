package com.framgia.tipcalculator;

public class Calculator {
    private int so;
    private String pheptinh;

    public Calculator(int so, String pheptinh) {
        this.so = so;
        this.pheptinh = pheptinh;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public String getPheptinh() {
        return pheptinh;
    }

    public void setPheptinh(String pheptinh) {
        this.pheptinh = pheptinh;
    }
}
