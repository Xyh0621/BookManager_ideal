import mapper.BorrowMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.Book;
import pojo.Borrow;
import service.BookService;
import service.BorrowService;
import service.impl.BookServiceImpl;
import service.impl.BorrowServiceImpl;
import util.SqlSessionFactoryUtils;

import java.util.Date;
import java.util.List;

public class BorrowTest {
    @Test
    public void borrowSelectAll()
    {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);

        List<Borrow> borrows = borrowMapper.selectAll();

        System.out.println(borrows);
    }

    @Test
    public void borrowSelectByCondition()
    {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);

        Borrow borrow = new Borrow();
        int BorrowID = 1;
        borrow.setBorrowID(BorrowID);

        List<Borrow> borrows = borrowMapper.selectByCondition(borrow);


        System.out.println(borrows);
    }

    @Test
    public void Date(){
        System.out.println(new Date());
    }


    @Test
    public void LendBook(){
        Borrow borrow = new Borrow();
        borrow.setRdID(201901001);
        borrow.setBkID(2);

        BorrowService bookService = new BorrowServiceImpl();

        bookService.LendBook(borrow);


    }

    @Test
    public void RendBook(){
        Borrow borrow = new Borrow();
        borrow.setRdID(201901001);
        borrow.setBkID(2);

        BorrowService bookService = new BorrowServiceImpl();

        bookService.RentBook(borrow);


    }

    @Test
    public void selectBook(){
        Borrow borrow = new Borrow();
        borrow.setRdID(201901001);

        BookService  bookService= new BookServiceImpl();

        List<Book> books = bookService.selectInBorrow(borrow);

        System.out.println(books);
    }

    @Test
    public void test(){
        Borrow borrow = new Borrow();
        borrow.setIsHasReturn(1);

        System.out.println(borrow);
    }

}
