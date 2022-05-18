package mapper;

import pojo.Borrow;

import java.util.List;

public interface BorrowMapper {
    List<Borrow> selectAll();

    void add(Borrow borrow);

    void update(Borrow borrow);

    List<Borrow> selectByCondition(Borrow borrow);
}
