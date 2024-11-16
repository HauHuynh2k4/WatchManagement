package sample.cart;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import sample.product.WatchDTO;
import sample.user.UserDTO;
import sample.utils.DBUtils;

public class CatDAO {

    private Map<String, WatchDTO> cart;

    private static final String ADD_TO_CART = "INSERT INTO tbl_Cart(userId, watchId, name, image, price, quantity, discount) VALUES (?,?,?,?,?,?,?)";
    private static final String REMOVE_FROM_CART = "DELETE FROM tbl_Cart WHERE watchId=? AND userId=?";
    private static final String VIEW_CART = "SELECT * FROM tbl_Cart WHERE userId=?";
    private static final String CHECK_CART = "SELECT * FROM tbl_Cart WHERE userId=? AND watchId=?";
    private static final String UPDATE_CART = "UPDATE tbl_Cart SET quantity=? WHERE userId=? AND watchId=?";
    private static final String REMOVE_CART_BY_USER = "DELETE FROM tbl_Cart WHERE userId=?";

    public Map<String, WatchDTO> getCart() {
        return cart;
    }

    public boolean addToCart(WatchDTO watch, UserDTO loginUser) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String userID = loginUser.getUserID();
        String watchID = watch.getWatchId();

        try {
            conn = DBUtils.getConnection();
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }

            ps = conn.prepareStatement(CHECK_CART);
            ps.setString(1, userID);
            ps.setString(2, watchID);
            rs = ps.executeQuery();

            if (rs.next()) {
                int currentQuantity = rs.getInt("quantity");
                int newQuantity = currentQuantity + watch.getQuantity();
                ps = conn.prepareStatement(UPDATE_CART);
                ps.setInt(1, newQuantity);
                ps.setString(2, userID);
                ps.setString(3, watchID);
                check = ps.executeUpdate() > 0;
            } else {
                ps = conn.prepareStatement(ADD_TO_CART);
                ps.setString(1, userID);
                ps.setString(2, watchID);
                ps.setString(3, watch.getName());
                ps.setString(4, watch.getImage());
                ps.setBigDecimal(5, watch.getPrice());
                ps.setInt(6, watch.getQuantity());
                ps.setBigDecimal(7, watch.getDiscount());
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public HashMap<String, WatchDTO> getListCart(String userId) throws SQLException, ClassNotFoundException {
        HashMap<String, WatchDTO> list = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(VIEW_CART);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String watchId = rs.getString("watchId");
                String name = rs.getString("name");
                String image = rs.getString("image");
                BigDecimal price = rs.getBigDecimal("price");
                int quantity = rs.getInt("quantity");
                BigDecimal discount = rs.getBigDecimal("discount");

                if (image == null) {
                    image = "https://lh5.googleusercontent.com/proxy/lJeqvMPUc4a5MGN4gPOJDSgrigqBcZ1OZEMPZXulKgZVTUNWm9p3LbxFuuoAgLyoJmuhpHHlP7NeToxj0usQEMf2eWPFiqfe";
                }
                list.put(watchId, new WatchDTO(watchId, name, null, null, null, image, price, quantity, false, discount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean removeFromCart(String userId, String watchId) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(REMOVE_FROM_CART);
            ps.setString(1, watchId);
            ps.setString(2, userId);
            check = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public CartDTO getCartItem(String userId, String watchId) throws SQLException, ClassNotFoundException {
        CartDTO cart = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(CHECK_CART);
            ps.setString(1, userId);
            ps.setString(2, watchId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                BigDecimal price = rs.getBigDecimal("price");
                int quantity = rs.getInt("quantity");
                BigDecimal discount = rs.getBigDecimal("discount");
                if (image == null) {
                    image = "https://lh5.googleusercontent.com/proxy/lJeqvMPUc4a5MGN4gPOJDSgrigqBcZ1OZEMPZXulKgZVTUNWm9p3LbxFuuoAgLyoJmuhpHHlP7NeToxj0usQEMf2eWPFiqfe";
                }
                cart = new CartDTO(userId, watchId, name, image, price, quantity, discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return cart;
    }

    public boolean updateCartItem(String userId, String watchId, int quantity) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(UPDATE_CART);
            ps.setInt(1, quantity);
            ps.setString(2, userId);
            ps.setString(3, watchId);
            check = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean removeCartByUser(String userId) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(REMOVE_CART_BY_USER);
            ps.setString(1, userId);
            check = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
