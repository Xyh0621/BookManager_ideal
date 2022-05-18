package service;

import pojo.Book;
import pojo.Borrow;
import pojo.PageBean;

import java.util.List;

public interface BookService {

    List<Book> selectAll();

    void addBook(Book book);

    void delBookByid(int id);

    void delBooksByids(int[] ids);

    List<Book> selectByCondition(Book book);

    void updateBook(Book book);

    PageBean<Book> selectByPage(int currentPage,int pageSize);

    List<Book> selectInBorrow (Borrow borrow);
}
