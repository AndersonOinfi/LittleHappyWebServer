package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.HashMap;

@WebListener()
public class LoginListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public LoginListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    private static volatile int UserNum;

    private static volatile HashMap<String, String> UserAgents=new HashMap<>(); //static型变量也要赋值

    public static int getUserNum() {
        return UserNum;
    }

    public static HashMap<String, String> getUserAgents() {
        return UserAgents;
    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        //Session创建先于加入Attribute
        UserNum++;
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        UserNum--;
        HttpSession session=se.getSession();
        String ua;
        String username;
        if ((ua=(String) session.getAttribute("User-Agent"))!=null &&
            (username=(String) session.getAttribute("name"))!=null)
            UserAgents.remove(username, ua);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        String ua;
        if ((sbe.getName().equals("User-Agent"))&&(ua=(String) sbe.getValue())!=null)
            UserAgents.put("User-Agent", ua);
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
