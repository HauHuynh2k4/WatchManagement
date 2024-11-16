package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            String watchId = request.getParameter("watchId");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            WatchDAO watchDao = new WatchDAO();
            CatDAO cartDao = new CatDAO();

            WatchDTO watch = watchDao.getWatchById(watchId);
            if (watch != null) {
                int availableQuantity = watch.getQuantity();
                if (quantity > availableQuantity) {
                    request.setAttribute("ERROR_MESSAGE", "Not enough quantity watch to buy.");
                } else {
                    HashMap<String, WatchDTO> cartItems = cartDao.getListCart(user.getUserID());
                    if (cartItems.containsKey(watchId)) {
                        cartDao.updateCartItem(user.getUserID(), watchId, quantity);
                    }
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR_MESSAGE", "Could not update item in cart.");
            }
        } catch (Exception e) {
            log("Error at getAllWatchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
