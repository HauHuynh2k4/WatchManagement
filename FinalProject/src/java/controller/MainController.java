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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "loginController";

    private static final String LOGOUT = "Log Out";
    private static final String LOGOUT_CONTROLLER = "logoutController";

    private static final String REGISTER = "Register";
    private static final String REGISTER_CONTROLLER = "registerController";

    private static final String VIEW_CART = "View Cart";
    private static final String VIEW_CART_CONTROLLER = "viewCart.jsp";

    private static final String REMOVE = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveCartServlet";

    private static final String Buy = "Buy";
    private static final String Buy_CONTROLLER = "BuyServlet";

    private static final String BACK_MENU = "Back Menu";
    private static final String BACK_MENU_CONTROLLER = "admin.jsp";

    private static final String CONTINUE_SHOPPING = "Continue shopping";
    private static final String CONTINUE_SHOPPING_CONTROLLER = "user.jsp";


    private static final String Search_Watch = "Search";
    private static final String Search_Watch_CONTROLLER = "SearchWatchByIdOrName";
    
    private static final String Search_Invoice = "Search Invoice";
    private static final String Search_Invoice_CONTROLLER = "SearchInvoiceByUserID";

    private static final String Search_Watch_Price = "SEARCH";
    private static final String Search_Watch_Price_CONTROLLER = "SearchWatchByPrice";

    private static final String Search_Watch_BY_BRAND = "Find";
    private static final String Search_Watch_BY_BRAND_CONTROLLER = "SearchWatchByBrand";

    private static final String Search_Watch_BY_TYPE = "FIND";
    private static final String Search_Watch_BY_TYPE_CONTROLLER = "SearchWatchByType";

    private static final String Insert_Watch = "Insert new Watch";
    private static final String Insert_Watch_CONTROLLER = "InsertWatch.jsp";

    private static final String Insert_New_Watch = "Insert";
    private static final String Insert_New_Watch_CONTROLLER = "AddNewWatchController";

    private static final String Update_User = "UpdateUser";
    private static final String Update_User_CONTROLLER = "UpdateUserController";
    
    private static final String Update_User_BY_ADMIN = "Update";
    private static final String Update_User_BY_ADMIN_CONTROLLER = "UpdateUserByAdminController";
    
    private static final String Update_Watch = "Update Watch";
    private static final String Update_Watch_CONTROLLER = "UpdateWatchController";
    
    private static final String Update_Watch_INFO = "Update Info";
    private static final String Update_Watch_INFO_CONTROLLER = "UpdateWatchInfoController";
    
    private static final String Delete_Phone = "Delete";
    private static final String Delete_Phone_CONTROLLER = "DeletePhoneServlet";

    private static final String ADD_CART = "Add";
    private static final String ADD_CART_CONTROLLER = "AddToCartController";

    private static final String ADD_WISHLIST = "ADD";
    private static final String ADD_WISHLIST_CONTROLLER = "AddToWishListController";

    private static final String UPDATE_CART = "Update cart";
    private static final String UPDATE_CART_CONTROLLER = "UpdateCartController";
    
    private static final String Search_USER = "SearchUser";
    private static final String SEARCH_CONTROLLER = "SearchController";
    
    private static final String CHECKOUT = "Check out";
    private static final String CHECKOUT_CONTROLLER = "CheckOutController";
    
    private static final String GET_INFO = "GetInfo";
    private static final String GET_INFO_CONTROLLER = "GetInformationController";
    
    private static final String DELETE_USER = "DeleteUser";
    private static final String DELETE_USER_CONTROLLER = "DeleteController";
    
    private static final String DELETE_WATCH = "Delete Watch";
    private static final String DELETE_WATCH_CONTROLLER = "DeleteWatchController";
    
    private static final String INSERT_WISHLIST = "InsertWishList";
    private static final String INSERT_WISHLIST_CONTROLLER = "InsertWishListController";
    
    private static final String DELETE_WISHLIST = "DeleteWishList";
    private static final String DELETE_WISHLIST_CONTROLLER = "DeleteWishListController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String url = ERROR;
    try {
        String action = request.getParameter("action");
        if (LOGIN.equals(action)) {
            url = LOGIN_CONTROLLER;
        } else if (LOGOUT.equals(action)) {
            url = LOGOUT_CONTROLLER;
        } else if (REGISTER.equals(action)) {
            url = REGISTER_CONTROLLER;
        } else if (VIEW_CART.equals(action)) {
            url = VIEW_CART_CONTROLLER;
        } else if (REMOVE.equals(action)) {
            url = REMOVE_CONTROLLER;
        } else if (Buy.equals(action)) {
            url = Buy_CONTROLLER;
        } else if (BACK_MENU.equals(action)) {
            url = BACK_MENU_CONTROLLER;
        } else if (Search_Watch.equals(action)) {
            url = Search_Watch_CONTROLLER;
        } else if (Insert_Watch.equals(action)) {
            url = Insert_Watch_CONTROLLER;
        } else if (Update_User.equals(action)) {
            url = Update_User_CONTROLLER;
        } else if (Delete_Phone.equals(action)) {
            url = Delete_Phone_CONTROLLER;
        } else if (Insert_New_Watch.equals(action)) {
            url = Insert_New_Watch_CONTROLLER;
        } else if (Search_Watch_Price.equals(action)) {
            url = Search_Watch_Price_CONTROLLER;
        } else if (ADD_CART.equals(action)) {
            url = ADD_CART_CONTROLLER;
        } else if (ADD_WISHLIST.equals(action)) {
            url = ADD_WISHLIST_CONTROLLER;
        } else if (CONTINUE_SHOPPING.equals(action)) {
            url = CONTINUE_SHOPPING_CONTROLLER;
        } else if (UPDATE_CART.equals(action)) {
            url = UPDATE_CART_CONTROLLER;
        } else if (Search_Watch_BY_BRAND.equals(action)) {
            url = Search_Watch_BY_BRAND_CONTROLLER;
        } else if (Search_Watch_BY_TYPE.equals(action)) {
            url = Search_Watch_BY_TYPE_CONTROLLER;
        } else if (Search_USER.equals(action)) {
            url = SEARCH_CONTROLLER;
        } else if (DELETE_USER.equals(action)) {
            url = DELETE_USER_CONTROLLER;
        } else if (CHECKOUT.equals(action)) {
            url = CHECKOUT_CONTROLLER;
        } else if (GET_INFO.equals(action)) {
            url = GET_INFO_CONTROLLER;
        } else if (Update_User_BY_ADMIN.equals(action)) {
            url = Update_User_BY_ADMIN_CONTROLLER;
        } else if (Search_Invoice.equals(action)) {
            url = Search_Invoice_CONTROLLER;
        } else if (Update_Watch.equals(action)) {
            url = Update_Watch_CONTROLLER;
        } else if (DELETE_WATCH.equals(action)) {
            url = DELETE_WATCH_CONTROLLER;
        } else if (Update_Watch_INFO.equals(action)) {
            url = Update_Watch_INFO_CONTROLLER;
        } else if (INSERT_WISHLIST.equals(action)) {
            url = INSERT_WISHLIST_CONTROLLER;
        }else if (DELETE_WISHLIST.equals(action)) {
            url = DELETE_WISHLIST_CONTROLLER;
        } else {
            request.setAttribute("ERROR", "Action is not supported");
        }
    } catch (Exception e) {
        log("Error at MainController: " + e.toString());
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
