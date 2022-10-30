package com.enigmacamp.lambda.challange;

public class Transaction {
    private String outlet;
    private String periode;
    private int totalOmzet;
    private int totalTrx;

    public Transaction(String outlet, String periode, int totalOmzet, int totalTrx) {
        this.outlet = outlet;
        this.periode = periode;
        this.totalOmzet = totalOmzet;
        this.totalTrx = totalTrx;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getTotalOmzet() {
        return totalOmzet;
    }

    public void setTotalOmzet(int totalOmzet) {
        this.totalOmzet = totalOmzet;
    }

    public int getTotalTrx() {
        return totalTrx;
    }

    public void setTotalTrx(int totalTrx) {
        this.totalTrx = totalTrx;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "outlet='" + outlet + '\'' +
                ", periode='" + periode + '\'' +
                ", totalOmzet=" + totalOmzet +
                ", totalTrx=" + totalTrx +
                '}';
    }
}
