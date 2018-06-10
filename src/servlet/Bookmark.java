package servlet;

import cons.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Bookmark", urlPatterns = "/servlet.Bookmark")
public class Bookmark extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer=response.getWriter();

        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("name");
        String method=request.getParameter("method");
        String result="";
        HashMap<String,String> bookmark=checkBookmark(username);
        if (method.equals("check")){
            result+="<ul>";
            for (Map.Entry<String,String> entry:
                    bookmark.entrySet()) {
                result+="<li><a href=\""+entry.getValue()+"\">"+entry.getKey()+"</a></li><br>";
            }
            result+="</ul>";
        }
        else if (method.equals("add")){
            String name=(String) request.getParameter("name");
            String url=(String) request.getParameter("url");
            if (name!=null&&url!=null){
                if (name.isEmpty()||url.isEmpty()){
                    result="<p>添加失败!</p>";
                }
                else {
                    bookmark.put(name, url);
                    addBookmark(username,bookmark);
                    result="<p>添加成功!</p>";
                }
            }
            else
                request.getRequestDispatcher("bookmark/add.jsp").forward(request,response);
            //todo
        }
        writer.println(result);
        writer.close();
    }

    private HashMap<String,String> checkBookmark(String username){
        HashMap<String,String> bookmark;
        if ((bookmark=Constant.BOOK_MARKS.get(username))==null){
            bookmark=new HashMap<>();
            Constant.BOOK_MARKS.put(username,bookmark);
        }
        return bookmark;
    }

    private boolean addBookmark(String username,HashMap<String,String> bookmark){
        checkBookmark(username).putAll(bookmark);
        return true;
    }
}
