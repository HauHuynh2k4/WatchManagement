package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.cart.CatDAO;
import sample.invoice.InvoiceDAO;
import sample.invoice.InvoiceDTO;
import sample.product.WatchDAO;
import sample.product.WatchDTO;
import sample.user.UserDTO;

@WebServlet(urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            String invoiceId = generateUniqueInvoiceId();
            String userId = user.getUserID();
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String dateOfPurchaseStr = request.getParameter("dateOfPurchase");
            String finalTotalStr = request.getParameter("finalTotal");

            Date purchaseDate = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = dateFormat.parse(dateOfPurchaseStr);
                purchaseDate = new Date(parsedDate.getTime());
            } catch (ParseException e) {
                throw new ServletException("Error parsing date", e);
            }

            BigDecimal totalPrice = new BigDecimal(finalTotalStr);

            InvoiceDTO invoice = new InvoiceDTO(invoiceId, userId, email, address, purchaseDate, totalPrice);
            InvoiceDAO invoiceDAO = new InvoiceDAO();
            boolean result = invoiceDAO.addInvoice(invoice);

             if (result) {
                CatDAO cartDAO = new CatDAO();
                HashMap<String, WatchDTO> cart = cartDAO.getListCart(userId);
                WatchDAO watchDAO = new WatchDAO();

                boolean stockUpdated = updateStock(cart, watchDAO);

                if (stockUpdated) {
                    cartDAO.removeCartByUser(userId);
                    response.sendRedirect("ThankYou.jsp");
                } else {
                    response.sendRedirect("CheckOut.jsp?error=Unable to update stock");
                }
            } else {
                response.sendRedirect("CheckOut.jsp?error=Unable to process your order");
            }
        } catch (Exception e) {
            throw new ServletException("Error processing checkout", e);
        }
    }
    
    private boolean updateStock(HashMap<String, WatchDTO> cart, WatchDAO watchDAO) {
        try {
            for (WatchDTO watch : cart.values()) {
                int newQuantity = watchDAO.getQuantity(watch.getWatchId()) - watch.getQuantity();
                if (newQuantity < 0) {
                    return false;
                }
                watchDAO.updateQuantity(watch.getWatchId(), newQuantity);
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private String generateUniqueInvoiceId() throws SQLException {
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        Random random = new Random();
        String invoiceId;
        boolean exists;
        do {
            int randomNumber = random.nextInt(999999) + 1; 
            invoiceId = "INV-" + randomNumber;
            exists = invoiceDAO.checkInvoiceExists(invoiceId); 
        } while (exists);
        return invoiceId;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
