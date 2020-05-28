package com.kag.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @Description: 批发（附表）实体层
 * @Author: 陈子康
 * @Date: 2020/5/19
 */
public class SaleDetail {

    private String saleId;
    private int mid;
    private int saleQuantity;
    private String remark;

    public SaleDetail(String saleId, int mid, int saleQuantity, String remark) {
        this.saleId = saleId;
        this.mid = mid;
        this.saleQuantity = saleQuantity;
        this.remark = remark;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
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
        SaleDetail that = (SaleDetail) o;
        return mid == that.mid &&
                saleQuantity == that.saleQuantity &&
                Objects.equals(saleId, that.saleId) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, mid, saleQuantity, remark);
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "saleId='" + saleId + '\'' +
                ", mid=" + mid +
                ", saleQuantity=" + saleQuantity +
                ", remark='" + remark + '\'' +
                '}';
    }
}
