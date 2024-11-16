package sample.wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

public class WishListDAO {

    private static final String ADD_WISHLIST = "INSERT INTO tbl_WishList (userId, watchId) VALUES (?, ?)";
    private static final String GET_WISH_LIST_BY_UID = "SELECT * FROM tbl_WishList WHERE userId=?";
    private static final String GET_ALL = "SELECT * FROM tbl_WishList";
    private static final String DELETE = "DELETE FROM tbl_WishList WHERE userId=? AND watchId=?";
    private static final String CHECK_WISH_LIST = "SELECT * FROM tbl_WishList WHERE userId=? AND watchId=?";

    public boolean addWishlistItem(WishListDTO item) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(ADD_WISHLIST);
                ps.setString(1, item.getUserId());
                ps.setString(2, item.getWatchId());
                result = ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<WishListDTO> getWishlistByUserId(String userId) throws ClassNotFoundException, SQLException {
        List<WishListDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(GET_WISH_LIST_BY_UID);
                ps.setString(1, userId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String watchId = rs.getString("watchId");
                    list.add(new WishListDTO(userId, watchId));
                }
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
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<WishListDTO> getAllWishlistItems() throws SQLException, ClassNotFoundException {
        List<WishListDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(GET_ALL);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String userId = rs.getString("userId");
                    String watchId = rs.getString("watchId");
                    list.add(new WishListDTO(userId, watchId));
                }
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
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean deleteWishlistItem(String userId, String watchId) throws ClassNotFoundException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(DELETE);
                ps.setString(1, userId);
                ps.setString(2, watchId);
                result = ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean isWishlistItemExists(String userId, String watchId) throws SQLException, ClassNotFoundException {
        boolean exists = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(CHECK_WISH_LIST);
                ps.setString(1, userId);
                ps.setString(2, watchId);
                rs = ps.executeQuery();
                exists = rs.next(); 
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
            if (con != null) {
                con.close();
            }
        }
        return exists;
    }
}
