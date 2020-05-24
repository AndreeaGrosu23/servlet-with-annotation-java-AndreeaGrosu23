package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ShoppingCartServlet", urlPatterns = {"/cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet{

    Cart myCart = new Cart();

    Item item1 = Stock.item1;
    Item item2 = Stock.item2;
    Item item3 = Stock.item3;

    int sum = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("Welcome to the shopping cart!");

        String item_id = request.getParameter("item_id");
        System.out.println(item_id);

        if (item_id.substring(0,3).equals("add")) {
            if (item_id.substring(4).equals("1")) {
                myCart.add(item1);
                sum += item1.getPrice();
            } else if (item_id.substring(4).equals("2")) {
                myCart.add(item2);
                sum += item2.getPrice();
            } else if (item_id.substring(4).equals("3")) {
                myCart.add(item3);
                sum += item3.getPrice();
            }
        } else if (item_id.substring(0,3).equals("rem")) {
            if (item_id.substring(7).equals("1")) {
                myCart.remove(item1);
                sum -= item1.getPrice();
            } else if (item_id.substring(7).equals("2")) {
                myCart.remove(item2);
                sum -= item2.getPrice();
            } else if (item_id.substring(7).equals("3")) {
                myCart.remove(item3);
                sum -= item3.getPrice();
            }
        }

        response.sendRedirect("webshop");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String title = "Shopping Cart";

        out.println("<html>\n"+"<head><title>"+title+"</title></head>\n"+
                "<body>\n"+
                "<h1>"+title+"</h1>\n"+
                "<table>"+
                "<thead>"+
                "<tr>"+
                "<th>Name</th>"+
                "<th>Price</th>"+
                "</tr>"+
                "</thead>"+
                "<tbody>");
        for (Item i : myCart.list) {
            out.println(
                    "<tr>"+
                    "<td>"+i.getName()+"</td>"+
                    "<td>"+i.getPrice()+"USD</td>"+
                    "</tr>");
        }
        out.println("</tbody>"+
                    "</table>"+
                    "<div>Total: " + sum + " USD</div>"+
                    "<div><a href=\"/webshop\"><button type=\"button\">Shop</button></a></div>"+
                    "</body></html>");
    }

}
