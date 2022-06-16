package com.kag.entity;

import java.util.Objects;

/**
 * @apiNote 库存实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class Stock {

    private int mid;
    private int stockQuantity;
    private String remark;

    public Stock(int mid, int stockQuantity, String remark) {
        this.mid = mid;
        this.stockQuantity = stockQuantity;
        this.remark = remark;
    }


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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
        Stock stock = (Stock) o;
        return mid == stock.mid &&
                stockQuantity == stock.stockQuantity &&
                Objects.equals(remark, stock.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, stockQuantity, remark);
    }

    @Override
    public String toString() {
        return "Shock{" +
                "mid=" + mid +
                ", stockQuantity=" + stockQuantity +
                ", remark='" + remark + '\'' +
                '}';
    }
}
