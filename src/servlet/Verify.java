package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

@WebServlet(name = "Verify", urlPatterns = "/servlet.Verify")
public class Verify extends HttpServlet{
    private String defaultCode="3154";
    private Font defaultFont=new Font(null,Font.ITALIC,20);
    private int defaultHeight=40;
    private int defaultWidth=100;
    private String imagePath="images/VerifyImage.jpg";
    private Random rander=new Random();

    public Verify(){
        //todo
    }

    public BufferedImage createImage(){
        return createImage(defaultCode,defaultFont,defaultWidth,defaultHeight);
    }
    public BufferedImage createImage(String code,Font font,int width,int height){
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics=image.createGraphics();
        graphics.setFont(font);
        graphics.setBackground(Color.BLACK);
        graphics.setPaint(Color.WHITE);
        graphics.clearRect(0,0,width,height);
        FontRenderContext context=graphics.getFontRenderContext();
        Rectangle2D bounds=font.getStringBounds(code,context);
        int x=(int)(width-bounds.getWidth())/2;
        int y=(int)(height+bounds.getHeight())/2;

        graphics.drawString(code,x,y);
        try {
            FileOutputStream stream=new FileOutputStream("/home/asuka/Tool/apache-tomcat-9.0.8/webapps/ROOT/"+imagePath); //todo imagePath;
            ImageIO.write(image,"JPG",stream);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        long time=req.getDateHeader(HttpServletRequest.FORM_AUTH);
        rander.setSeed(time);
        String code=Integer.toString(rander.nextInt()%10000);
        BufferedImage image=createImage(code,defaultFont,defaultWidth,defaultHeight);
        writer.println("<h1>一个并没有什么卵用的验证码</h1>");
        writer.println("<img src=\""+imagePath+"\">");
        writer.println("<form action=\"servlet.Test\">" +
                "请输入验证码: <input type=\"text\" name=\"code\">" +
                "<input type=\"submit\">\n" +
                "</form>");
        writer.close();
    }
}
