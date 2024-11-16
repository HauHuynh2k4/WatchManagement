/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class WatchDTO {
    private String watchId;
    private String name;
    private String brand;
    private String description;
    private String type;
    private String image;
    private BigDecimal price;
    private int quantity;
    private boolean notSale;
    private BigDecimal discount;

    public WatchDTO(String watchId, String name, String brand, String description, String type, String image, BigDecimal price, int quantity, boolean notSale,BigDecimal discount) {
        this.watchId = watchId;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.type = type;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.notSale = notSale;
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public WatchDTO() {
    }

    public String getWatchId() {
        return watchId;
    }

    public void setWatchId(String watchId) {
        this.watchId = watchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }
    
    
}
