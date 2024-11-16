/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.WatchDAO;
import sample.product.WatchDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateWatchInfoController", urlPatterns = {"/UpdateWatchInfoController"})
public class UpdateWatchInfoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "UpdateWatch.jsp";
    private static final String SUCCESS = "getAllWatchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            String watchId = request.getParameter("watchId");
            String name = request.getParameter("name");
            String brand = request.getParameter("brand");
            String description = request.getParameter("description");
            String type = request.getParameter("type");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            boolean notSale = request.getParameter("sale").equals("Yes");
            BigDecimal discount = new BigDecimal(request.getParameter("discount"));
            String image = request.getParameter("image");
            String imageCurrent = request.getParameter("imageCurrent");
            String imagePath = "";
            if(image=="" && image.trim().equals("")){
                imagePath = imageCurrent;
            }else{
                imagePath = "img/" + image;
            }
            
            WatchDTO watch = new WatchDTO(watchId, name, brand, description, type, imagePath, price, quantity, notSale, discount);
            WatchDAO dao = new WatchDAO();
            boolean isUpdated = dao.updateWatch(watch);

            if (isUpdated) {
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_MESSAGE", "Update failed!");
            }
        } catch (Exception e) {
            log("Error at UpdateWatchInfoController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
