package com.heba.rachid.Heba.leaky;

public class State {
    private  int bkt_size;
    private  int pkt_size;
    private  boolean isAccepted;
    private int pkt_sent;

    public State(int bkt_size, int pkt_size, boolean isAccepted, int pkt_sent, int arrivingTime) {
        this.bkt_size = bkt_size;
        this.pkt_size = pkt_size;
        this.isAccepted = isAccepted;
        this.pkt_sent = pkt_sent;
        this.arrivingTime = arrivingTime;
    }

    public State(){};

    @Override
    public String toString() {
        return "Bucket{" +
                "bkt_size=" + bkt_size +
                ", pkt_size=" + pkt_size +
                ", isAccepted=" + isAccepted +
                ", pkt_sent=" + pkt_sent +
                ", arrivingTime=" + arrivingTime +
                '}';
    }

    public int getBkt_size() {
        return bkt_size;
    }

    public void setBkt_size(int bkt_size) {
        this.bkt_size = bkt_size;
    }

    public int getPkt_size() {
        return pkt_size;
    }

    public void setPkt_size(int pkt_size) {
        this.pkt_size = pkt_size;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getPkt_sent() {
        return pkt_sent;
    }

    public void setPkt_sent(int pkt_sent) {
        this.pkt_sent = pkt_sent;
    }

    public int getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(int arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    private int arrivingTime;

}
