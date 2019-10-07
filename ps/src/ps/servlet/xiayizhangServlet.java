package ps.servlet;

import ps.dao.impl.ImageDaoImpl;
import ps.service.IImageService;
import ps.service.impl.ImageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/ps/xiayizhang.do")
public class xiayizhangServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public xiayizhangServlet(){
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("xiyizhang");
        String value=null;
        Integer bianhao=0;
        IImageService im=new ImageServiceImpl();
        String bh=request.getParameter("bh");
        Integer bianh=0;
        bianh =Integer.parseInt(bh);
        Map<Integer,String> result=im.xiayizhang(bianh);
        Set keySet=result.keySet();
        Iterator it=keySet.iterator();
        while(it.hasNext()){
            bianhao= (Integer) it.next();
            value=result.get(bianhao);
        }
        System.out.println(bianhao+"====="+value);
        request.setAttribute("bianhao",bianhao);
        request.setAttribute("imageName",value);
        request.getRequestDispatcher("/WEB-INF/jsp/index2.jsp").forward(request,response);
    }

}
