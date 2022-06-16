package com.kag.entity;

import java.util.*;

/**
 * @apiNote 零售实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class Retail {

    private String retailId;
    private int mid;
    private int retailQuantity;
    private double transactionAmount;
    private Date retailDate;
    private int cid;
    private int sid;
    private String remark;

    public Retail(String retailId, int mid, int retailQuantity, double transactionAmount, Date retailDate, int cid, int sid, String remark) {
        this.retailId = retailId;
        this.mid = mid;
        this.retailQuantity = retailQuantity;
        this.transactionAmount = transactionAmount;
        this.retailDate = retailDate;
        this.cid = cid;
        this.sid = sid;
        this.remark = remark;
    }

    public String getRetailId() {
        return retailId;
    }

    public void setRetailId(String retailId) {
        this.retailId = retailId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getRetailQuantity() {
        return retailQuantity;
    }

    public void setRetailQuantity(int retailQuantity) {
        this.retailQuantity = retailQuantity;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getRetailDate() {
        return retailDate;
    }

    public void setRetailDate(Date retailDate) {
        this.retailDate = retailDate;
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
        Retail retail = (Retail) o;
        return mid == retail.mid &&
                retailQuantity == retail.retailQuantity &&
                Double.compare(retail.transactionAmount, transactionAmount) == 0 &&
                cid == retail.cid &&
                sid == retail.sid &&
                Objects.equals(retailId, retail.retailId) &&
                Objects.equals(retailDate, retail.retailDate) &&
                Objects.equals(remark, retail.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retailId, mid, retailQuantity, transactionAmount, retailDate, cid, sid, remark);
    }

    @Override
    public String toString() {
        return "Retail{" +
                "retailId='" + retailId + '\'' +
                ", mid=" + mid +
                ", retailQuantity=" + retailQuantity +
                ", transactionAmount=" + transactionAmount +
                ", retailDate=" + retailDate +
                ", cid=" + cid +
                ", sid=" + sid +
                ", remark='" + remark + '\'' +
                '}';
    }
}
