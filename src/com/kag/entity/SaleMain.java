package com.kag.entity;

import java.util.*;

/**
 * @apiNote 批发（主表）实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class SaleMain {

    private String saleId;
    private int medicineKinds;
    private double transactionAmount;
    private Date saleDate;
    private int cid;
    private int sid;
    private String remark;

    public SaleMain(String saleId, int medicineKinds, double transactionAmount, Date saleDate, int cid, int sid, String remark) {
        this.saleId = saleId;
        this.medicineKinds = medicineKinds;
        this.transactionAmount = transactionAmount;
        this.saleDate = saleDate;
        this.cid = cid;
        this.sid = sid;
        this.remark = remark;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public int getMedicineKinds() {
        return medicineKinds;
    }

    public void setMedicineKinds(int medicineKinds) {
        this.medicineKinds = medicineKinds;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleMain saleMain = (SaleMain) o;
        return medicineKinds == saleMain.medicineKinds &&
                Double.compare(saleMain.transactionAmount, transactionAmount) == 0 &&
                cid == saleMain.cid &&
                sid == saleMain.sid &&
                Objects.equals(saleId, saleMain.saleId) &&
                Objects.equals(saleDate, saleMain.saleDate) &&
                Objects.equals(remark, saleMain.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, medicineKinds, transactionAmount, saleDate, cid, sid, remark);
    }

    @Override
    public String toString() {
        return "SaleMain{" +
                "saleId='" + saleId + '\'' +
                ", medicineKinds=" + medicineKinds +
                ", transactionAmount=" + transactionAmount +
                ", saleDate=" + saleDate +
                ", cid=" + cid +
                ", sid=" + sid +
                ", remark='" + remark + '\'' +
                '}';
    }

}
