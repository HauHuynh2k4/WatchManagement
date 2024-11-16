package controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.WatchDAO;
import sample.product.WatchDTO;
import sample.user.UserDTO;
import sample.wishlist.WishListDAO;
import sample.wishlist.WishListDTO;

@WebServlet(name = "InsertWishListController", urlPatterns = {"/InsertWishListController"})
public class InsertWishListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        WishListDAO dao = new WishListDAO();
        String watchId = request.getParameter("watchId");
        try {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                session.setAttribute("ERROR_MESSAGE", "You must be logged in to add items to the wishlist.");
            } else {
                String userId = user.getUserID();
                    WishListDTO item = new WishListDTO(userId, watchId);
                    boolean result = dao.addWishlistItem(item);
                    if (result) {
                        session.setAttribute("SUCCESS_MESSAGE", "Item added to wishlist successfully.");
                    } else {
                        session.setAttribute("ERROR_MESSAGE", "Failed to add item to wishlist.");
                    }
            } 
        }catch (Exception e) {
            log("Error at InsertWishListController: " + e.toString());
            session.setAttribute("ERROR_MESSAGE", "Error occurred while adding item to wishlist.");
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
