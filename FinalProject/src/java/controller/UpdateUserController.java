/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.user.UserDao;
import sample.user.UserDTO;


@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {

    public static final String ERROR = "Account.jsp";
    public static final String SUCCESS = "Account.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String pass = request.getParameter("Password");
            String confirmPass = request.getParameter("confirmPassword");
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            // Check if passwords match
            if (!pass.equals(confirmPass)) {
                request.setAttribute("ERROR_MESS", "Passwords do not match.");
            } else {
                // Input validation can be added here
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("LOGIN_USER") != null) {
                    UserDao dao = new UserDao();
                    UserDTO dto = new UserDTO(userID, pass, fullName, "", email, address);
                    boolean check = dao.update_User(dto);
                    if (check) {
                        url = SUCCESS;
                        request.setAttribute("SUCCESS_MESS", "Update Successfully");
                        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                        if (loginUser.getUserID().equals(userID)) {
                            session.setAttribute("LOGIN_USER", dto);
                        }
                    } else {
                        request.setAttribute("ERROR_MESS", "Update Failed");
                    }
                } else {
                    request.setAttribute("ERROR_MESS", "User is not logged in");
                }
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
