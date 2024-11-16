package controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.WatchDAO;
import sample.product.WatchDTO;

@WebServlet(name = "AddNewWatchController", urlPatterns = {"/AddNewWatchController"})
public class AddNewWatchController extends HttpServlet {
    
    public static final String ERROR = "InsertWatch.jsp";
    public static final String SUCCESS = "InsertWatch.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String watchId = request.getParameter("watchId");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean notSale = Boolean.parseBoolean(request.getParameter("sale"));
        BigDecimal discount = new BigDecimal(request.getParameter("discount"));
        String image = request.getParameter("image");
        String imagePath = "img/"+image;

        WatchDTO newWatch = new WatchDTO(watchId, name, brand, description, type, imagePath, price, quantity, notSale, discount);
        WatchDAO dao = new WatchDAO();
        String url = ERROR;

        try {
            boolean checkDuplicate = dao.checkDuplicate(watchId);
            if (!checkDuplicate) {
                boolean checkInsert = dao.insertWatch(newWatch);
                if (checkInsert) {
                    request.setAttribute("SUCCESS", "Watch added successfully.");
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Failed to add watch.");
                    url = ERROR;
                }
            } else {
                request.setAttribute("ERROR", "Duplicate ID! This watch ID already exists.");
                url = ERROR;
            }
        } catch (Exception e) {
            request.setAttribute("ERROR", "An error occurred: " + e.getMessage());
            log("Error at AddNewWatchController: " + e.toString());
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
        return "AddNewWatchController";
    }
}
