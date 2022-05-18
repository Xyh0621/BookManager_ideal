package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String URI = req.getRequestURI();
        //2.获取最后一段路径
        int index = URI.lastIndexOf('/');
        String methodName = URI.substring(index+1);

        //3执行方法
        //3.1 获取Servlet字节码对象
        Class<? extends BaseServlet> aClass = this.getClass();
        //3.2获取方法对象
        Method method = null;
        try {
            method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (InvocationTargetException e) {
                e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
