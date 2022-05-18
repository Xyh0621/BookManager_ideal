import mapper.BorrowMapper;
import mapper.ReaderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.Borrow;
import pojo.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ReaderTest {
    @Test
    public void selectAll(){
        ReaderService readerService = new ReaderServiceImpl();
        List<Reader> readers = readerService.selectAll();
        System.out.println(readers);

    }
}
