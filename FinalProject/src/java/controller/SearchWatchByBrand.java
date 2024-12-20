/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchWatchByBrand", urlPatterns = {"/SearchWatchByBrand"})
public class SearchWatchByBrand extends HttpServlet {
    private static final String USER_PAGE = "shopping.jsp";
    private static final String ADMIN_PAGE = "ManageWatch.jsp";
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
        String url = USER_PAGE;
        HttpSession session = request.getSession();
        try {
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            String search = request.getParameter("Brand");      
            WatchDAO dao = new WatchDAO();
            List<WatchDTO> listWatch = dao.searchWatchByBrand(search);
            if(listWatch.size()>0){
                request.setAttribute("LIST_WATCH", listWatch);
                if(user.getRole().equals("AD")){
                    url=ADMIN_PAGE;
                }
            }else {
                request.setAttribute("ERROR", "Not found any phone");
            }
        } catch (Exception e) {
            log("Error at SearchPhoneServlet:"+ e.toString());
        }finally{
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
