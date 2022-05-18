package service.impl;

import mapper.BookMapper;
import mapper.BorrowMapper;
import mapper.ReaderMapper;
import mapper.ReaderTypeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Book;
import pojo.Borrow;
import pojo.Reader;
import pojo.ReaderType;
import service.BorrowService;
import util.SqlSessionFactoryUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    //创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public void LendBook(Borrow borrow) {
        SqlSession sqlSession = factory.openSession();

//       通过rdID获得用户信息,并将已借书籍数加一更新
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);
        Reader user = readerMapper.selectByrdID(borrow.getRdID());
        user.setRdBorrowQty(user.getRdBorrowQty()+1);
        readerMapper.update(user);

//        通过rdType获得readerType的信息
        ReaderTypeMapper readerTypeMapper = sqlSession.getMapper(ReaderTypeMapper.class);
        ReaderType readerType = readerTypeMapper.selectByrdTypeID(user.getRdType());

//      通过用户类型计算出应该在几月几号还书
        Date dateNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNow);
        calendar.add(Calendar.DAY_OF_YEAR,readerType.getCanLendDay());

        Date DateRetPlan = calendar.getTime();

        borrow.setIdDateOut(dateNow);
        borrow.setIdDateRetPlan(DateRetPlan);
        borrow.setIsHasReturn(0);

        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        borrowMapper.add(borrow);

        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.selectBookByID(borrow.getBkID());
        book.setBkStatus(0);
        bookMapper.update(book);


        sqlSession.commit();
        sqlSession.close();
    }


    @Override
    public void RentBook(Borrow borrow) {
        SqlSession sqlSession = factory.openSession();


//        通过rdID查找用户并将用户借书数减一
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);
        Reader user = readerMapper.selectByrdID(borrow.getRdID());
        user.setRdBorrowQty(user.getRdBorrowQty()-1);
        readerMapper.update(user);

//        更新书籍的状态为在馆
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.selectBookByID(borrow.getBkID());
        book.setBkStatus(1);
        bookMapper.update(book);

//        获得还书的时间
        Date rentDay = new Date();


        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
//        只需要查询没有还书的记录
        borrow.setIsHasReturn(0);
        List<Borrow> borrows =  borrowMapper.selectByCondition(borrow);

        Borrow borrowDown = borrows.get(0);
        borrowDown.setIdDateRetAct(rentDay);
        Date DateRetPlan = borrowDown.getIdDateRetPlan();
//        如果还书时间小于预计还书时间，则设置超过还书天数为0
        if (rentDay.getTime()<DateRetPlan.getTime()){
            borrowDown.setIdOverDay(0);
        }else {
            long diff = rentDay.getTime()-DateRetPlan.getTime();
            int days =  (int) (diff/(1000*3600*24));
            System.out.println(days);
            borrowDown.setIdOverDay(days);
        }
        borrowDown.setIsHasReturn(1);

        borrowMapper.update(borrowDown);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Borrow> SelectAll() {
        SqlSession sqlSession = factory.openSession();
        BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);

        List<Borrow> borrows = borrowMapper.selectAll();
//        为每一个记录添加书籍名称和用户名称
        for (Borrow borrow:borrows) {
            Book book = bookMapper.selectBookByID(borrow.getBkID());
            Reader reader = readerMapper.selectByrdID(borrow.getRdID());
            if (1 == borrow.getIsHasReturn()){
                borrow.setIsHasReturnStr("已还书");
            }else {
                borrow.setIsHasReturnStr("未还书");
            }

            borrow.setBkName(book.getBkName());
            borrow.setRdName(reader.getRdName());
        }


        return borrows;
    }
}
