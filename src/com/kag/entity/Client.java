package com.kag.entity;

import java.util.Objects;

/**
 * @apiNote 客户实体层
 * @author KHighness
 * @since 2020/5/19
 */
public class Client {

    private int cid;
    private String clientName;
    private String clientAddress;
    private String phoneNumber;
    private String bankCard;
    private double credibility;
    private String remark;

    public Client(int cid, String clientName, String clientAddress, String phoneNumber, String bankCard, double credibility, String remark) {
        this.cid = cid;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.phoneNumber = phoneNumber;
        this.bankCard = bankCard;
        this.credibility = credibility;
        this.remark = remark;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public double getCredibility() {
        return credibility;
    }

    public void setCredibility(double credibility) {
        this.credibility = credibility;
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
        Client client = (Client) o;
        return cid == client.cid &&
                Double.compare(client.credibility, credibility) == 0 &&
                Objects.equals(clientName, client.clientName) &&
                Objects.equals(clientAddress, client.clientAddress) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(bankCard, client.bankCard) &&
                Objects.equals(remark, client.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, clientName, clientAddress, phoneNumber, bankCard, credibility, remark);
    }

    @Override
    public String toString() {
        return "Client{" +
                "cid=" + cid +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", credibility=" + credibility +
                ", remark='" + remark + '\'' +
                '}';
    }
}
