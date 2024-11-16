/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.invoice;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class InvoiceDTO {
    private String invId;
    private String userId;
    private String gmail;
    private String address;
    private Date purchaseDate;
    private BigDecimal totalPrice;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String invId, String userId, String gmail, String address, Date purchaseDate, BigDecimal totalPrice) {
        this.invId = invId;
        this.userId = userId;
        this.gmail = gmail;
        this.address = address;
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
    }

    

    public String getInvId() {
        return invId;
    }

    public void setInvId(String invId) {
        this.invId = invId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
