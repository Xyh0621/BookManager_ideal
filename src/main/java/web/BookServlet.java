package web;

import com.alibaba.fastjson.JSON;
import pojo.Book;
import pojo.Borrow;
import pojo.PageBean;
import service.BookService;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/*")
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.selectAll();

        String s = JSON.toJSONString(books);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串

        Book book = JSON.parseObject(params,Book.class);

        System.out.println(book);
        bookService.addBook(book);

        response.getWriter().write("success");
    }

    public void delBookbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串

        int id = JSON.parseObject(params,Integer.class);

        bookService.delBookByid(id);

        System.out.println(id);
        response.getWriter().write("success");
    }

    public void delBooksbyids(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串

        int ids[] = JSON.parseObject(params,int[].class);

        bookService.delBooksByids(ids);

        response.getWriter().write("success");
    }

    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串


        Book book = JSON.parseObject(params,Book.class);

        List<Book> books=bookService.selectByCondition(book);

//        System.out.println(books);

        String s = JSON.toJSONString(books);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串

        Book book = JSON.parseObject(params,Book.class);

        System.out.println(book);
        bookService.updateBook(book);

        response.getWriter().write("success");
    }

    public void selectAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Book> pageBean = bookService.selectByPage(currentPage,pageSize);

        String s = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectInBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串
        Borrow borrow = JSON.parseObject(params, Borrow.class);

        List<Book> books=bookService.selectInBorrow(borrow);

//        System.out.println(books);

        String s = JSON.toJSONString(books);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
