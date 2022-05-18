package service.impl;

import mapper.BookMapper;
import mapper.BorrowMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Book;
import pojo.Borrow;
import pojo.PageBean;
import service.BookService;
import util.SqlSessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    //创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Book> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.selectAll();

        sqlSession.close();

        return books;
    }

    @Override
    public void addBook(Book book) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.add(book);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delBookByid(int id) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.deleteById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delBooksByids(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = bookMapper.selectByCondition(book);

        sqlSession.close();

        return books;
    }

    @Override
    public void updateBook(Book book) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.update(book);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Book> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        int begin = (currentPage-1)*pageSize;

        List<Book> books = bookMapper.selectAllByPage(begin, pageSize);

        int totalCount = bookMapper.selectTotalCount();

        PageBean<Book> pageBean = new PageBean<>();
        pageBean.setRows(books);
        pageBean.setTotalCount(totalCount);


        return pageBean;
    }

    @Override
    public List<Book> selectInBorrow(Borrow borrow) {
        SqlSession sqlSession = factory.openSession();

        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
//        只需查询未还的记录
        borrow.setIsHasReturn(0);
        List<Borrow> borrows = borrowMapper.selectByCondition(borrow);

        List<Book> books = new ArrayList<>();

        for (Borrow value : borrows) {
            books.add(bookMapper.selectBookByID(value.getBkID()));
        }

        return books;
    }
}
