package sample.wishlist;

/**
 *
 * @author ADMIN
 */
public class WishListDTO {

    private String userId;
    private String watchId;

    public WishListDTO() {
    }

    public WishListDTO(String userId, String watchId) {
        this.userId = userId;
        this.watchId = watchId;
    }

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

}
