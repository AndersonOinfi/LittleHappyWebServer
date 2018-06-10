package servlet;

import listeners.LoginListener;
import module.GetAddressByIP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "HelloServlet", urlPatterns = "/servlet.Hello")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        writer.print("<h1>I'm just a little happy web server!</h>");
        String address=GetAddressByIP.Get(request.getRemoteAddr());
        writer.print("<h2>your location is: "+address+"</h2>");
        int userNum=LoginListener.getUserNum();
        writer.print("<h2>Online Users: "+userNum+"</h2>");
        Map<String, String> userAgents=LoginListener.getUserAgents();
        for (String agent:
                userAgents.values()) {
            writer.print("<p>"+agent+"</p></br>");
        }
        /* Lambda
        userAgents.forEach((key, value)->{
            //Code
        });
        */
        writer.close();
    }
}
