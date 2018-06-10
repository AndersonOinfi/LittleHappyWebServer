package filters;

import cons.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;;

@WebFilter(filterName = "KeywordsFilter", urlPatterns = {"/servlet.MessageBoard", "/servlet.Bookmark"})
public class KeywordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;

        HttpServletRequest requestWrapper=new CharacterRequestWrapper(request, Constant.KEYWORDS);
        chain.doFilter(requestWrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}

class CharacterRequestWrapper extends HttpServletRequestWrapper{
    private Map<String, String> keywords;

    public CharacterRequestWrapper(HttpServletRequest request, Map<String, String> keywords) {
        super(request);
        this.keywords=keywords;
    }

    @Override
    public String getParameter(String name){
        return doKeywordsInterception(getRequest().getParameter(name));
    }

    private String doKeywordsInterception(String str) {
        if (str!=null)
            for (String key:
                keywords.keySet()) {
                str = str.replaceAll(key, keywords.get(key));
            }
        return str;
    }
}