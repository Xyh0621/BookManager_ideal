package service;

import pojo.Borrow;
import pojo.Reader;

import java.util.List;

public interface BorrowService {
    void LendBook(Borrow borrow);

    void RentBook(Borrow borrow);

    List<Borrow> SelectAll();
}
