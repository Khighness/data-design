package com.kag.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @apiNote 职员实体层
 * @author KHighness
 * @since 2020/5/6
 */
public class Staff {

    private int sid;
    private String staffName;
    private String password;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    private String bankCard;
    private int status;

    public Staff(){

    }

    public Staff(int sid, String staffName, String password, Date birthDate, String address, String phoneNumber, String bankCard, int status) {
        this.sid = sid;
        this.staffName = staffName;
        this.password = password;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankCard = bankCard;
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return sid == staff.sid &&
                status == staff.status &&
                Objects.equals(staffName, staff.staffName) &&
                Objects.equals(password, staff.password) &&
                Objects.equals(birthDate, staff.birthDate) &&
                Objects.equals(address, staff.address) &&
                Objects.equals(phoneNumber, staff.phoneNumber) &&
                Objects.equals(bankCard, staff.bankCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, staffName, password, birthDate, address, phoneNumber, bankCard, status);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sid=" + sid +
                ", staffName='" + staffName + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankCrd='" + bankCard + '\'' +
                ", status=" + status +
                '}';
    }
}
