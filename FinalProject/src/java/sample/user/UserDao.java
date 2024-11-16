package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

public class UserDao {

    private static final String LOGIN = "SELECT fullName, role, gmail, address FROM tbl_User WHERE userId=? AND password=?";
    private static final String SEARCH = "SELECT userId,password, fullName, role, gmail, address FROM tbl_User WHERE fullName LIKE ? OR userId LIKE ?";
    private static final String GET_ALL_USER = "SELECT userId,password, fullName, role, gmail, address FROM tbl_User";
    private static final String CHECK_DUPLICATE = "SELECT userId FROM tbl_User WHERE userId=?";
    private static final String UPDATE_USER = "UPDATE tbl_User SET password=?, fullName=?, gmail=?, address=? WHERE userID=?";
    private static final String INSERT = "INSERT INTO tbl_User(userId, password, fullName, role, gmail, address) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM tbl_User WHERE userID=?";

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    String gmail = rs.getString("gmail");
                    String address = rs.getString("address");
                    user = new UserDTO(userID, password, fullName, role, gmail, address);
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
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userId");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    String gmail = rs.getString("gmail");
                    String address = rs.getString("address");
                    list.add(new UserDTO(userID, password, fullName, role, gmail, address));
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

    public List<UserDTO> getAllUser() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_USER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userId");
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    String gmail = rs.getString("gmail");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    list.add(new UserDTO(userID, password, fullName, role, gmail, address));
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

    public boolean insert(UserDTO user) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getPassword());
                ptm.setString(3, user.getFullName());
                ptm.setString(4, user.getRole());
                ptm.setString(5, user.getGmail());
                ptm.setString(6, user.getAddress());
                checkInsert = ptm.executeUpdate() > 0;
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
        return checkInsert;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean update_User(UserDTO user) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_USER);
                ptm.setString(1, user.getPassword());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getGmail());
                ptm.setString(4, user.getAddress());
                ptm.setString(5, user.getUserID());
                checkUpdate = ptm.executeUpdate() > 0;
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
        return checkUpdate;
    }

    public boolean delete(String userID) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
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
}
