/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class WatchDAO {

    private static final String SEARCH_BY_PRICE = "SELECT * FROM tbl_Watch WHERE price BETWEEN ? AND ?";
    private static final String SEARCH_BY_ID_OR_NAME = "SELECT * FROM tbl_Watch WHERE watchId LIKE ? OR name LIKE ?";
    private static final String SEARCH_BY_BRAND = "SELECT * FROM tbl_Watch WHERE brand LIKE ?";
    private static final String SEARCH_BY_TYPE = "SELECT * FROM tbl_Watch WHERE type LIKE ?";
    private static final String GET_ALL_PRODUCT = "SELECT * FROM tbl_Watch";
    private static final String REMOVE = "DELETE FROM tbl_Watch WHERE watchId=?";
    private static final String ADD = "INSERT INTO tbl_Watch(watchId, name,brand,description ,type, image,price,quantity,notSale,discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    private static final String UPDATE = "UPDATE tbl_Watch SET name=?, brand=?, description=?, type=?, image=?,price=?,quantity=?,notSale=?,discount=? WHERE watchId=?";
    private static final String CHECK_DUPLICATE="SELECT watchId FROM tbl_Watch WHERE watchId=?";
    private static final String GET_QUANTITY = "SELECT quantity FROM tbl_Watch WHERE watchId=?";
    private static final String UPDATE_QUANTITY = "UPDATE tbl_Watch SET quantity=? WHERE watchId=?";
    private static final String GET_WATCH_BY_ID = "select * from tbl_Watch where watchId=?";

    public List<WatchDTO> searchWatchByIdOrName(String search) throws SQLException {
        List<WatchDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_ID_OR_NAME);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String watchId = rs.getString("watchId");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String image = rs.getString("image");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    BigDecimal discount = rs.getBigDecimal("discount");
                    list.add(new WatchDTO(watchId, name, brand, description, type, image, price, quantity, notSale,discount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<WatchDTO> searchWatchByBrand(String Brand) throws SQLException {
        List<WatchDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_BRAND);
                ptm.setString(1, "%" + Brand + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String watchId = rs.getString("watchId");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String image = rs.getString("image");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    BigDecimal discount = rs.getBigDecimal("discount");
                    list.add(new WatchDTO(watchId, name, brand, description, type, image, price, quantity, notSale,discount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<WatchDTO> searchWatchByType(String Type) throws SQLException {
        List<WatchDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_TYPE);
                ptm.setString(1, "%" + Type + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String watchId = rs.getString("watchId");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String image = rs.getString("image");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    BigDecimal discount = rs.getBigDecimal("discount");
                    list.add(new WatchDTO(watchId, name, brand, description, type, image, price, quantity, notSale,discount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<WatchDTO> searchWatchPriceRange(BigDecimal minPrice, BigDecimal maxPrice) throws SQLException {
        List<WatchDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_PRICE);
                ptm.setBigDecimal(1, minPrice);
                ptm.setBigDecimal(2, maxPrice);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String watchId = rs.getString("watchId");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String image = rs.getString("image");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    BigDecimal discount = rs.getBigDecimal("discount");
                    list.add(new WatchDTO(watchId, name, brand, description, type, image, price, quantity, notSale,discount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean deleteWatch(String watchId) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(REMOVE);
                ptm.setString(1, watchId);
                checkDelete = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }
    
    public boolean updateWatch(WatchDTO watch) throws SQLException {
        boolean isSuccess = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, watch.getName());
                ptm.setString(2, watch.getBrand());
                ptm.setString(3, watch.getDescription());
                ptm.setString(4, watch.getType());
                ptm.setString(5, watch.getImage());
                ptm.setBigDecimal(6, watch.getPrice());
                ptm.setInt(7, watch.getQuantity());
                ptm.setBoolean(8, watch.isNotSale());
                ptm.setBigDecimal(9, watch.getDiscount());
                ptm.setString(10, watch.getWatchId());
                isSuccess = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return isSuccess;
    }
    
    public List<WatchDTO> getAllWatch() throws SQLException{
        List<WatchDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_ALL_PRODUCT);
                rs = ptm.executeQuery();
                while(rs.next()){
                    String watchId = rs.getString("watchId");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String image = rs.getString("image");
                    BigDecimal price = rs.getBigDecimal("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    BigDecimal discount = rs.getBigDecimal("discount");
                    list.add(new WatchDTO(watchId, name, brand, description, type, image, price, quantity, notSale,discount));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public boolean insertWatch(WatchDTO watch) throws SQLException {
        boolean isSuccess = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD);
                ptm.setString(1, watch.getWatchId());
                ptm.setString(2, watch.getName());
                ptm.setString(3, watch.getBrand());
                ptm.setString(4, watch.getDescription());
                ptm.setString(5, watch.getType());
                ptm.setString(6, watch.getImage());
                ptm.setBigDecimal(7, watch.getPrice());
                ptm.setInt(8, watch.getQuantity());
                ptm.setBoolean(9, watch.isNotSale());
                ptm.setBigDecimal(10, watch.getDiscount());
                isSuccess = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return isSuccess;
    }
    
    public boolean checkDuplicate(String watchID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, watchID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
    
    public boolean updateQuantity(String watchID,int quantity) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean result = false;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, quantity);
                ptm.setString(2, watchID);
                result = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return result;
    }
    
    public int getQuantity(String watchID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUANTITY);
                ptm.setString(1, watchID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    quantity = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return quantity;
    }
    public WatchDTO getWatchById(String watchId) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        WatchDTO result = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_WATCH_BY_ID);
                ptm.setString(1, watchId);
                rs=ptm.executeQuery();
                if(rs.next()){
                    result = new WatchDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getString(5), rs.getString(6), rs.getBigDecimal(7), rs.getInt(8),rs.getBoolean(9),rs.getBigDecimal(10));
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return null;
    }
    
}
