package servlet;

import cons.Constant;
import cons.MessageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "MessageBoard",urlPatterns = "/servlet.MessageBoard")
public class MessageBoard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        String message=request.getParameter("message");
        String username=request.getParameter("username");
        int avatar=Integer.parseInt(request.getParameter("useravatar"));
        //todo
        if (!Constant.MASSAGE_BOARD.isEmpty()) {
            // iterator遍历
            MessageInfo ms;
            for (Iterator iter=Constant.MASSAGE_BOARD.iterator();iter.hasNext();){
                ms=(MessageInfo) iter.next();
                writer.println(ms.toString());
            }
            /* foreach遍历，普通for循环便利linkedlist效率很低
            for (MessageInfo ms:Constant.MASSAGE_BOARD
                 ) {
                writer.println(ms.toString());
            }
            */
        }
        if (!username.equals("")&&!message.equals("")) {
            MessageInfo info=new MessageInfo(username,avatar,message);
            Constant.MASSAGE_BOARD.add(info);
            writer.println(info.toString());
        }
        writer.close();
    }
}
