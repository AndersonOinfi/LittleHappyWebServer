package servlet;

import cons.Constant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Test", urlPatterns = "/servlet.Test")
public class Test extends HttpServlet{
    // Login Test
    private Map<String,String>UserInf;

    public Test() {
        UserInf =new HashMap<>();
        UserInf.put("zhonghuaremistinker","123456");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        /**
         * Get请求取得参数表
         * String[] queryStr=request.getQueryString().split("&");
         * String username=queryStr."get(***)"
         * String password=queryStr."get(***)"
         * Int num=Integer.parseInt(queryStr."get(***)") // 字符串为null或""均报错
         */
        Cookie cookies[]=request.getCookies();
        if (cookies!=null){
            for (Cookie ck:cookies
                 ) {
                String name=ck.getValue();
                if (UserInf.containsKey(name)) {
                    ck.setMaxAge(Constant.COOKIE_MAX_AGE);
                    response.addCookie(ck);
                    writer.print("<h1>Login Success!</h1>");
                    writer.print("<p>" + name + "</p>");
                    request.getRequestDispatcher("user.jsp").forward(request, response);
                }
            }
            //request.getRequestDispatcher("login.jsp").forward(request,response);
        }

        String username=request.getParameter("username");
        /**
         * 对多个相同的参数使用
         * String[] tmp=request.getParameterValues("***")
         */
        String password=request.getParameter("password");
        String autoLogin=request.getParameter("auto");
        String test=UserInf.get(username);

        String userAgent=request.getHeader("User-Agent");

        if (test!=null&&test.equals(password)){
            HttpSession session=request.getSession(true);
            session.setAttribute("name",username);
            session.setAttribute("User-Agent",userAgent);
            Cookie cookie=new Cookie("name",username);
            cookie.setMaxAge(-1);
            if (autoLogin!=null)
                cookie.setMaxAge(Constant.COOKIE_MAX_AGE);
            response.addCookie(cookie);
            response.sendRedirect(request.getRequestURL()+"?"+System.currentTimeMillis());
        }
        else
            //todo 登陆失败时
            request.getRequestDispatcher("login.jsp").forward(request,response);

        writer.close();
    }
}
