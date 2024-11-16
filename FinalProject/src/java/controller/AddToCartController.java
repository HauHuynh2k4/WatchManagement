package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.CatDAO;
import sample.product.WatchDAO;
import sample.product.WatchDTO;
import sample.user.UserDTO;

@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String watchId = request.getParameter("watchId");
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

        WatchDAO watchDao = new WatchDAO();
        CatDAO cartDao = new CatDAO();
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            WatchDTO watch = watchDao.getWatchById(watchId);
            if (watch != null && user != null) {
                HashMap<String, WatchDTO> cartItems = cartDao.getListCart(user.getUserID());
                if (cartItems.containsKey(watchId)) {
                    int currentQuantity = cartItems.get(watchId).getQuantity();
                    int newQuantity = currentQuantity + 1;
                    cartDao.updateCartItem(user.getUserID(), watchId, newQuantity);
                } else {
                    watch.setQuantity(1); 
                    cartDao.addToCart(watch, user);
                }

                String done = "The " + watch.getName() + " has been added to your cart!";
                session.setAttribute("SUCCESS_MESSAGE", done);
            } else {
                String error = "Could not add item to cart. Please try again.";
                session.setAttribute("ERROR_MESSAGE", error);
            }

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
            session.setAttribute("ERROR_MESSAGE", "Error occurred while adding product to cart.");
        } finally {
            String referer = request.getHeader("Referer");
            if (referer != null && !referer.isEmpty()) {
                response.sendRedirect(referer);
            } else {
                response.sendRedirect("getAllWatchController");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
