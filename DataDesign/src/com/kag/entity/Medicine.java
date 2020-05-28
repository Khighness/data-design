package com.kag.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @Description: 药品实体层
 * @Author: 陈子康
 * @Date: 2020/5/19
 */
public class Medicine {

    private int mid;
    private String medicineName;
    private String manufacturer;
    private double purchasePrice;
    private double retailPrice;
    private double salePrice;
    private Date produceDate;
    private int shelfLife;
    private String character;
    private String dosageForm;
    private String ingredient;
    private String indication;
    private String aboutUse;
    private String taboo;
    private String adverseReactions;

    public Medicine(int mid, String medicineName, String manufacturer, double purchasePrice) {
        this.mid = mid;
        this.medicineName = medicineName;
        this.manufacturer = manufacturer;
        this.purchasePrice = purchasePrice;
    }

    public Medicine(int mid, String medicineName, String character, String dosageForm, String ingredient, String indication, String aboutUse, String taboo, String adverseReactions) {
        this.mid = mid;
        this.medicineName = medicineName;
        this.character = character;
        this.dosageForm = dosageForm;
        this.ingredient = ingredient;
        this.indication = indication;
        this.aboutUse = aboutUse;
        this.taboo = taboo;
        this.adverseReactions = adverseReactions;
    }

    public Medicine(int mid, String medicineName, String manufacturer, double purchasePrice, double retailPrice, double salePrice, Date produceDate, int shelfLife, String character, String dosageForm, String ingredient, String indication, String aboutUse, String taboo, String adverseReactions) {
        this.mid = mid;
        this.medicineName = medicineName;
        this.manufacturer = manufacturer;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.salePrice = salePrice;
        this.produceDate = produceDate;
        this.shelfLife = shelfLife;
        this.character = character;
        this.dosageForm = dosageForm;
        this.ingredient = ingredient;
        this.indication = indication;
        this.aboutUse = aboutUse;
        this.taboo = taboo;
        this.adverseReactions = adverseReactions;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getAboutUse() {
        return aboutUse;
    }

    public void setAboutUse(String aboutUse) {
        this.aboutUse = aboutUse;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return mid == medicine.mid &&
                Double.compare(medicine.purchasePrice, purchasePrice) == 0 &&
                Double.compare(medicine.retailPrice, retailPrice) == 0 &&
                Double.compare(medicine.salePrice, salePrice) == 0 &&
                shelfLife == medicine.shelfLife &&
                Objects.equals(medicineName, medicine.medicineName) &&
                Objects.equals(manufacturer, medicine.manufacturer) &&
                Objects.equals(produceDate, medicine.produceDate) &&
                Objects.equals(character, medicine.character) &&
                Objects.equals(dosageForm, medicine.dosageForm) &&
                Objects.equals(ingredient, medicine.ingredient) &&
                Objects.equals(indication, medicine.indication) &&
                Objects.equals(aboutUse, medicine.aboutUse) &&
                Objects.equals(taboo, medicine.taboo) &&
                Objects.equals(adverseReactions, medicine.adverseReactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, medicineName, manufacturer, purchasePrice, retailPrice, salePrice, produceDate, shelfLife, character, dosageForm, ingredient, indication, aboutUse, taboo, adverseReactions);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "mid=" + mid +
                ", medicineName='" + medicineName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", retailPrice=" + retailPrice +
                ", salePrice=" + salePrice +
                ", produceDate=" + produceDate +
                ", shelfLife=" + shelfLife +
                ", character='" + character + '\'' +
                ", dosageForm='" + dosageForm + '\'' +
                ", quantityStandard='" + ingredient + '\'' +
                ", indication='" + indication + '\'' +
                ", aboutUse='" + aboutUse + '\'' +
                ", taboo='" + taboo + '\'' +
                ", adverseReactions='" + adverseReactions + '\'' +
                '}';
    }
}
