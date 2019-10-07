package ps.servlet;

import ps.bean.ImageBean;
import ps.service.IImageService;
import ps.service.impl.ImageServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/ps/index.do")
public class indexServlet extends HttpServlet {
private static final long serialVersionUID=1L;
public indexServlet(){
    super();
}
protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    System.out.println("=====index.do======");
    String value=null;
    Integer bianhao=0;
    request.setCharacterEncoding("utf-8");
    IImageService imageService=new ImageServiceImpl();
    List<ImageBean> im=null;
    im=imageService.findImages();
    System.out.println(im);
    request.setAttribute("images",im);
    Map<Integer,String> show1=imageService.findTotal();
    Set keySet=show1.keySet();
    Iterator it=keySet.iterator();
    while(it.hasNext()){
        bianhao= (Integer) it.next();
        value=show1.get(bianhao);
    }

    System.out.println(bianhao+"====="+value);
    request.setAttribute("bianhao",bianhao);
    request.setAttribute("imageName",value);
    request.getRequestDispatcher("/WEB-INF/jsp/index2.jsp").forward(request,response);


}
}
