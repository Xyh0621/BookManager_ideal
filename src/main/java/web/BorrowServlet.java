package web;

import com.alibaba.fastjson.JSON;
import pojo.Book;
import pojo.Borrow;
import service.BorrowService;
import service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrow/*")
public class BorrowServlet extends BaseServlet{
    private BorrowService borrowService = new BorrowServiceImpl();

    public void LendBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串
        Borrow borrow = JSON.parseObject(params, Borrow.class);

        borrowService.LendBook(borrow);

        response.getWriter().write("success");
    }

    public void RentBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BufferedReader br = request.getReader();
        String params = br.readLine();//转换为json字符串
        Borrow borrow = JSON.parseObject(params, Borrow.class);

        borrowService.RentBook(borrow);

        response.getWriter().write("success");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Borrow> borrows =  borrowService.SelectAll();

        String s = JSON.toJSONString(borrows);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
