/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.invoice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import sample.product.WatchDTO;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class InvoiceDAO {

    private static final String INSERT_NEW_INVOICES = "INSERT INTO tbl_Invoice(invId,userId,gmail,address,purchaseDate,totalPrice) VALUES(?,?,?,?,?,?)";
    private static final String GET_ALL_INVOICES = "SELECT * FROM tbl_Invoice";
    private static final String CHECK_INVOICES ="SELECT * FROM tbl_Invoice where invId = ?";
    private static final String Seach_INVOICE_BY_UserID ="SELECT * FROM tbl_Invoice where userId like ?";
        
    public List<InvoiceDTO> searchInvoiceByUserId(String search) throws SQLException {
        List<InvoiceDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(Seach_INVOICE_BY_UserID);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String invId = rs.getString("invId");
                    String userId = rs.getString("userId");
                    String gmail = rs.getString("gmail");
                    String address = rs.getString("address");
                    Date purchaseDate = rs.getDate("purchaseDate");
                    BigDecimal totalPrice = rs.getBigDecimal("totalPrice");
                    list.add(new InvoiceDTO(invId, userId, gmail, address, purchaseDate, totalPrice));
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
    
    public boolean addInvoice(InvoiceDTO invoice) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_NEW_INVOICES);

                ptm.setString(1, invoice.getInvId());
                ptm.setString(2, invoice.getUserId());
                ptm.setString(3, invoice.getGmail());
                ptm.setString(4, invoice.getAddress());
                ptm.setTimestamp(5, new Timestamp(invoice.getPurchaseDate().getTime()));
                ptm.setBigDecimal(6, invoice.getTotalPrice());

                result = ptm.executeUpdate() > 0;
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
        return result;
    }
    
    public List<InvoiceDTO> getAllInvoices() throws SQLException {
        List<InvoiceDTO> invoices = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_INVOICES);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String invId = rs.getString("invId");
                    String userId = rs.getString("userId");
                    String gmail = rs.getString("gmail");
                    String address = rs.getString("address");
                    Date buyDate = rs.getDate("purchaseDate");
                    BigDecimal totalPrice = rs.getBigDecimal("totalPrice");

                    InvoiceDTO invoice = new InvoiceDTO(invId, userId, gmail, address,buyDate, totalPrice);
                    invoices.add(invoice);
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
        return invoices;
    }
    public boolean checkInvoiceExists(String invId) throws SQLException {
        boolean exists = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_INVOICES);
                ptm.setString(1, invId);
                rs = ptm.executeQuery();
                exists = rs.next();
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
        return exists;
    }

}
