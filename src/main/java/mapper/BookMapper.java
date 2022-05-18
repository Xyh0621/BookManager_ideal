package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Book;

import java.util.List;

public interface BookMapper {
//    查询总记录数
    int selectTotalCount();

    List<Book> selectAll();

    Book selectBookByID(int bkID);

//    分页查询
    List<Book> selectAllByPage(@Param("begin") int begin,@Param("size") int size);

    void add(Book book);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);

    void update(Book book);

    List<Book> selectByCondition(Book book);
}
