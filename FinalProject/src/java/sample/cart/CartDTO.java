package sample.cart;

import java.math.BigDecimal;

public class CartDTO {

    private String userId;
    private String watchId;
    private String name;
    private String image;
    private BigDecimal price;
    private int quantity;
    private BigDecimal discount;

    public CartDTO() {
    }

    public CartDTO(String userId, String watchId, String name, String image, BigDecimal price, int quantity, BigDecimal discount) {
        this.userId = userId;
        this.watchId = watchId;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


}
