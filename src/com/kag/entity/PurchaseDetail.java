package com.kag.entity;

import java.util.Objects;

/**
 * @apiNote 进货（附表）实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class PurchaseDetail {

    private String purchaseId;
    private int mid;
    private double purchasePrice;
    private int purchaseQuantity;
    private String remark;

    public PurchaseDetail(String purchaseId, int mid, double purchasePrice, int purchaseQuantity, String remark) {
        this.purchaseId = purchaseId;
        this.mid = mid;
        this.purchasePrice = purchasePrice;
        this.purchaseQuantity = purchaseQuantity;
        this.remark = remark;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
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
        PurchaseDetail that = (PurchaseDetail) o;
        return purchaseId == that.purchaseId &&
                mid == that.mid &&
                Double.compare(that.purchasePrice, purchasePrice) == 0 &&
                purchaseQuantity == that.purchaseQuantity &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, mid, purchasePrice, purchaseQuantity, remark);
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "purchaseId=" + purchaseId +
                ", mid=" + mid +
                ", purchasePrice=" + purchasePrice +
                ", purchaseQuantity=" + purchaseQuantity +
                ", remark='" + remark + '\'' +
                '}';
    }
}
