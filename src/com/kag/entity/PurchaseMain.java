package com.kag.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @apiNote 进货（主表）实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class PurchaseMain {

    private String purchaseId;
    private int medicineKinds;
    private double transactionAmount;
    private Date purchaseDate;
    private int fid;
    private int sid;
    private String remark;

    public PurchaseMain(String purchaseId, int medicineKinds, double transactionAmount, Date purchaseDate, int fid, int sid, String remark) {
        this.purchaseId = purchaseId;
        this.medicineKinds = medicineKinds;
        this.transactionAmount = transactionAmount;
        this.purchaseDate = purchaseDate;
        this.fid = fid;
        this.sid = sid;
        this.remark = remark;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
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
        PurchaseMain that = (PurchaseMain) o;
        return purchaseId == that.purchaseId &&
                medicineKinds == that.medicineKinds &&
                Double.compare(that.transactionAmount, transactionAmount) == 0 &&
                fid == that.fid &&
                sid == that.sid &&
                Objects.equals(purchaseDate, that.purchaseDate) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, medicineKinds, transactionAmount, purchaseDate, fid, sid, remark);
    }

    @Override
    public String toString() {
        return "PurchaseMain{" +
                "purchaseId=" + purchaseId +
                ", medicineKinds=" + medicineKinds +
                ", transactionAmount=" + transactionAmount +
                ", purchaseDate=" + purchaseDate +
                ", fid=" + fid +
                ", sid=" + sid +
                ", remark='" + remark + '\'' +
                '}';
    }
}
