package com.heba.rachid.Heba.leaky;

import java.util.Arrays;

public class Bucket {
    private int n;
    private int op_rate;
    private int bsize;
    private String spkt;

    public String getSpkt() {
        return spkt;
    }

    public void setSpkt(String spkt) {
        this.spkt = spkt;
    }

    public Bucket(){}

    @Override
    public String toString() {
        return "Bucket{" +
                "n=" + n +
                ", op_rate=" + op_rate +
                ", bsize=" + bsize +
                ", spkt='" + spkt + '\'' +
                '}';
    }

    public Bucket(int n, int op_rate, int bsize, String spkt) {
        this.n = n;
        this.op_rate = op_rate;
        this.bsize = bsize;
        this.spkt = spkt;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getOp_rate() {
        return op_rate;
    }

    public void setOp_rate(int op_rate) {
        this.op_rate = op_rate;
    }

    public int getBsize() {
        return bsize;
    }

    public void setBsize(int bsize) {
        this.bsize = bsize;
    }

}
