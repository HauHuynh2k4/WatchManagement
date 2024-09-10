package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user_watch.watchDTO;
import user_watch.DAO;
import wishlist.WishList;
import product.CartDTO;
import java.util.List;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Page</title>\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"images/logo.png\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/853d2cd4f0.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                font-family: serif;\n");
      out.write("            }\n");
      out.write("            .animated-gradient-text {\n");
      out.write("                margin-top: 350px;\n");
      out.write("                margin-bottom: -300px;\n");
      out.write("                font-size: 30px;\n");
      out.write("                font-weight: 900;\n");
      out.write("                background: linear-gradient(270deg, #ff6ec4, #7873f5, #7bdff2, #f7f881);\n");
      out.write("                background-size: 800% 800%;\n");
      out.write("                -webkit-background-clip: text;\n");
      out.write("                -webkit-text-fill-color: transparent;\n");
      out.write("                animation: gradientAnimation 8s ease infinite;\n");
      out.write("                text-transform: capitalize;        \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @keyframes gradientAnimation {\n");
      out.write("                0% {\n");
      out.write("                    background-position: 0% 50%;\n");
      out.write("                }\n");
      out.write("                50% {\n");
      out.write("                    background-position: 100% 50%;\n");
      out.write("                }\n");
      out.write("                100% {\n");
      out.write("                    background-position: 0% 50%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            .navbar{\n");
      out.write("                background-color: blueviolet;\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: #660066;\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("                font-weight: 100;\n");
      out.write("            }\n");
      out.write("            a:hover {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #dc3545;\n");
      out.write("            }\n");
      out.write("            ul{\n");
      out.write("                list-style: none;\n");
      out.write("            }\n");
      out.write("            ul.product{\n");
      out.write("                text-align: center;\n");
      out.write("                display: flex;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("                justify-content: space-between;\n");
      out.write("            }\n");
      out.write("            header{\n");
      out.write("                background-color: #660066;;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .search-bar{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .search-bar {\n");
      out.write("                margin-top: 30px;\n");
      out.write("                padding: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .search-bar h3 {\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .search-bar input[type=\"number\"] {\n");
      out.write("                width: 230px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .search-bar input[type=\"submit\"] {\n");
      out.write("                margin-top: 10px;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                background-color: #28a745;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .search-bar input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #218838;\n");
      out.write("            }\n");
      out.write("            .logo{\n");
      out.write("                width: 70px;\n");
      out.write("                height: 40px;\n");
      out.write("            }\n");
      out.write("            .banner{\n");
      out.write("                margin-top: 10px;\n");
      out.write("                width: 1200px;\n");
      out.write("                height: 40px;\n");
      out.write("                background-color: black;\n");
      out.write("            }\n");
      out.write("            .img-banner{\n");
      out.write("                width: 1518px;\n");
      out.write("                height: 350px;\n");
      out.write("            }\n");
      out.write("            img.watchimg {\n");
      out.write("                width: 300px;\n");
      out.write("                height: 300px;\n");
      out.write("            }\n");
      out.write("            .span{\n");
      out.write("                margin-left: 100px;\n");
      out.write("            }\n");
      out.write("            img{\n");
      out.write("                width: 230px;\n");
      out.write("                height: 230px;\n");
      out.write("            }\n");
      out.write("            .shop{\n");
      out.write("                margin-top: 330px;\n");
      out.write("            }\n");
      out.write("            .cart-icon{\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-content: center;\n");
      out.write("                font-size: 40px;\n");
      out.write("                color: #333;\n");
      out.write("                margin-top: 50px;\n");
      out.write("            }\n");
      out.write("            .your-cart{\n");
      out.write("                font-family: serif;\n");
      out.write("                font-size: 28px;\n");
      out.write("                color: #333;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .your-wishlist{\n");
      out.write("                font-family: serif;\n");
      out.write("                font-size: 28px;\n");
      out.write("                color: #333;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .section{\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                background-color: #cccccc;\n");
      out.write("                max-width: 1200px;\n");
      out.write("                margin: auto;\n");
      out.write("                padding: 20px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                opacity: 0.9;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #quantity{\n");
      out.write("                display: inline;\n");
      out.write("                width: 25px;\n");
      out.write("                height: 30px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                background-color: red;\n");
      out.write("                opacity: 0.9;\n");
      out.write("                border-radius: 15px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .product {\n");
      out.write("                list-style: none;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product li {\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 23%;\n");
      out.write("                margin: 1%;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                padding: 10px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-item {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-img img {\n");
      out.write("                width: 230px;\n");
      out.write("                height: 230px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-name {\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin: 10px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-price {\n");
      out.write("                color: #28a745;\n");
      out.write("                font-size: 14px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            .addcart a {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: white;\n");
      out.write("                background-color: #007bff;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .addcart a:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("            }\n");
      out.write("            .addtowishlist a {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: white;\n");
      out.write("                background-color: red;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .addtowishlist a:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("            }\n");
      out.write("            footer {\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .form-container {\n");
      out.write("                text-align: center;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-container input[type=\"submit\"] {\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                background-color: #dc3545;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .social ul{\n");
      out.write("                margin-top: 20px;\n");
      out.write("                display: flex; \n");
      out.write("                justify-content: space-around;\n");
      out.write("            }\n");
      out.write("            .col-md-6{\n");
      out.write("                border-bottom: 1px solid #ff9a9e;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .sold-out{\n");
      out.write("                color: red;\n");
      out.write("                text-decoration: line-through;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String user = (String) session.getAttribute("user");
            DAO dao = new DAO();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            List<WishList> wishlist = dao.showWishList(user);
            String min = "0";
            String max = "0";
            if (session.getAttribute("min") != null) {
                min = (String) session.getAttribute("min");
            }
            if (session.getAttribute("max") != null) {
                max = (String) session.getAttribute("max");
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headershop.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <img class=\"img-banner\"  src=\"images/Logo-The-Gioi-Dong-Ho-Dep-Desktop.jpg\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\"> \n");
      out.write("            <div class=\"col-12\">\n");
      out.write("                <h4 class=\"animated-gradient-text\"> <p> Welcome ");
      out.print( user);
      out.write(" <i class=\"fa-regular fa-user\"></i> </p></h4> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"shop\">\n");
      out.write("<!--        <h1 style=\"color: green\"> Welcome user ");
      out.print( user);
      out.write(" </h1> <br>-->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"section\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"search-bar col-md-6\">\n");
      out.write("                            <h3> Search Price <i class=\"fa-solid fa-hand-holding-dollar\"></i> </h3>\n");
      out.write("                            <form action=\"MainController\" method=\"post\">\n");
      out.write("                                From <input type=\"number\" name=\"min\" value=\"");
      out.print( min);
      out.write("\"> <br>\n");
      out.write("                                To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"number\" name=\"max\" value=\"");
      out.print( max);
      out.write("\"> <br>\n");
      out.write("                                <input type=\"submit\" name=\"action\" value=\"Search price\"> &nbsp; <i class=\"fa-solid fa-magnifying-glass\"></i> <br> <br><br>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"cart-icon\" >\n");
      out.write("                                <a class=\"your-cart\" href=\"viewcart.jsp\"> Your cart </a> &nbsp; <i class=\"fa-solid fa-cart-shopping\"></i>\n");
      out.write("                                ");

                                    if (cart != null) {
                                
      out.write("\n");
      out.write("                                <span id=\"quantity\"> &nbsp; ");
      out.print( cart.getCart().size());
      out.write(" &nbsp; </span>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cart-icon\">\n");
      out.write("                                <a class=\"your-wishlist\" href=\"WistListController?uId=");
      out.print(user);
      out.write("\"> Your wishlist </a> &nbsp; <i class=\"fa-brands fa-gratipay\"></i>\n");
      out.write("                                ");

                                    if (wishlist!=null && wishlist.size()!=0) {
                                
      out.write("\n");
      out.write("                                <span id=\"quantity\"> &nbsp; ");
      out.print( wishlist.size());
      out.write(" &nbsp; </span>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h3 style=\"color: green\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${done}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h3>\n");
      out.write("                            <h3 style=\"color: red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h3>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <ul class=\"product\">\n");
      out.write("                        ");

                            List<watchDTO> list2 = null;
                            if (request.getAttribute("data") != null) {
                                list2 = (List<watchDTO>) request.getAttribute("data");
                                for (watchDTO i : list2) {
                        
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"product-item\">\n");
      out.write("                                <div class=\"product-img\">\n");
      out.write("                                    <img class=\"product-img-src\" src=\"images/");
      out.print(i.getImg());
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"product-name\">\n");
      out.write("                                    ");
      out.print(i.getWatchName());
      out.write(" \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"product-price\">\n");
      out.write("                                    ");
      out.print(i.getPrice());
      out.write("$\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"product-name\">\n");
      out.write("                                   Stock: ");
      out.print(i.getQuantity());
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                    ");

                                        if(i.getQuantity()>0 && i.isNotSale()){
                                    
      out.write("\n");
      out.write("                                <div class=\"addcart\">\n");
      out.write("                                    <a href=\"AddToCartController?watchId=");
      out.print(i.getWatchId());
      out.write("\" > Add to cart </a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"addtowishlist\">\n");
      out.write("                                    <a href=\"AddToWishlistController?watchId=");
      out.print(i.getWatchId());
      out.write("&userId=");
      out.print(user);
      out.write("\" > Add to wishlist </a>\n");
      out.write("                                </div>\n");
      out.write("                                ");
 
                                    }else{
                                
      out.write("\n");
      out.write("                                <h4 class=\"sold-out\"> Sold Out !! </h4>\n");
      out.write("                                ");
 
                                    }
                                
      out.write("\n");
      out.write("                            </div>        \n");
      out.write("                            <form>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <form action=\"LoginController\" method=\"get\">\n");
      out.write("                <input type=\"submit\" value=\"Loggout\" > &nbsp; <i class=\"fa-solid fa-right-from-bracket\"></i>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div  class=\"social\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-facebook\"></i> &nbsp; Facebook </a> </li>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-square-instagram\"></i> &nbsp; Instagram </a> </li>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-square-x-twitter\"></i> &nbsp; X(Twitter) </a> </li>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-square-threads\"></i> &nbsp; Thread </a> </li>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-tiktok\"></i> &nbsp; Tiktok </a> </li>\n");
      out.write("                            <li> <a href=\"#\"><i class=\"fa-brands fa-square-threads\"></i> &nbsp; Thread </a> </li>\n");
      out.write("                        </ul> \n");
      out.write("                    </div>   \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer\"> \n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write(" \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
