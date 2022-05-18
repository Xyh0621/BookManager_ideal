package web;

import com.alibaba.fastjson.JSON;
import pojo.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/reader/*")
public class ReaderServlet extends BaseServlet{
    private ReaderService readerService = new ReaderServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reader> readers = readerService.selectAll();

        String s = JSON.toJSONString(readers);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }


    public void LoginManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String param = br.readLine();


        Reader reader = JSON.parseObject(param,Reader.class);
//        System.out.println(reader);
        //管理员类型为1
        reader.setRdType(1);

        List<Reader> readers = readerService.selectByCondition(reader);

        String s = JSON.toJSONString(readers);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void LoginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String param = br.readLine();

        Reader reader = JSON.parseObject(param,Reader.class);
        List<Reader> readers = readerService.loginUser(reader);

        String s = JSON.toJSONString(readers);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
