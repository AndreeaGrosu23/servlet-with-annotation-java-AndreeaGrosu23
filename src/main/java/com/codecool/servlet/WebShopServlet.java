package com.codecool.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet(name="WebShopServlet", urlPatterns={"/webshop"}, loadOnStartup=1)
public class WebShopServlet extends HttpServlet {

    Stock currentStock = new Stock();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String title = "WebShop";

        out.println("<html>\n"+"<head><title>"+title+"</title>"+
                "</head>\n"+
                "<body>\n"+
                "<h1>"+title+"</h1>\n"+
                "<table>"+
                "<thead>"+
                "<tr>"+
                "<th>ID</th>"+
                "<th>Name</th>"+
                "<th>Price</th>"+
                "<th></th>"+
                "<th></th>"+
                "</tr>"+
                "</thead>"+
                "</tbody>");

        Iterator<Item> it = currentStock.stockSet.iterator();
        Item currentProduct;
        while(it.hasNext()) {

            currentProduct = it.next();

            out.println("<tr>"+
                    "<td>"+currentProduct.getId()+"</td>"+
                    "<td>"+currentProduct.getName()+"<td>"+
                    "<td>"+currentProduct.getPrice()+"USD"+"<td>"+
                    "<td>"+
                    "<form action=\"cart\" method=\"post\"> " +
                    "<input type=\"hidden\" name=\"item_id\" value=\"add_"+ currentProduct.getId() +"\" >"+
                    "<input type=\"submit\" value=\"Add\">"+
                    "</form>" +
                    "</td>"+
                    "<td>" +
                    "<form action=\"cart\" method=\"post\"> " +
                    "<input type=\"hidden\" name=\"item_id\" value=\"remove_"+ currentProduct.getId() +"\" >"+
                    "<input type=\"submit\" value=\"Remove\">"+
                    "</form>" +
                    "</td>" +
                    "</tr");
        }

        out.println(
                "</tbody>"+
                        "</table>"+
                        "<div><a href=\"/cart\"><button type=\"button\">Check Shopping Cart</button></a></div>"+
                        "</body></html>");

    }
}
