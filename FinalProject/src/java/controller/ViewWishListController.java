/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ViewWishListController", urlPatterns = {"/ViewWishListController"})
public class ViewWishListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            String userId = user.getUserID(); 
            if (userId != null && !userId.isEmpty()) {
                WishListDAO wishListDAO = new WishListDAO();
                List<WishListDTO> wishList = wishListDAO.getWishlistByUserId(userId);

                List<WatchDTO> listWatch = new ArrayList<>();
                WatchDAO watchDAO = new WatchDAO();

                for (WishListDTO item : wishList) {
                    WatchDTO watch = watchDAO.getWatchById(item.getWatchId());
                    if (watch != null) {
                        listWatch.add(watch);
                    }
                }

                request.setAttribute("LIST_WATCH", listWatch);
            } else {
                // Redirect or handle if userId is not available
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            log("Error at getAllWatchController: " + e.toString());
        } finally {
            request.getRequestDispatcher("shopping.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
