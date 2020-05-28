package com.kag.entity;

import java.util.Objects;

/**
 * @Description: 账本实体层
 * @Author: 陈子康
 * @Date: 2020/5/19
 */
public class Ledger {

    private String recordId;
    private int type;
    private double transactionAmount;

    public Ledger(String recordId, int type, double transactionAmount) {
        this.recordId = recordId;
        this.type = type;
        this.transactionAmount = transactionAmount;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
        return type == ledger.type &&
                transactionAmount == ledger.transactionAmount &&
                Objects.equals(recordId, ledger.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, type, transactionAmount);
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "recordId='" + recordId + '\'' +
                ", type=" + type +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
