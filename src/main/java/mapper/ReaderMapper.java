package mapper;

import pojo.Reader;

import java.util.List;

public interface ReaderMapper {
    List<Reader> selectAll();

    void add(Reader reader);

    void deleteById(int id);

    void update(Reader reader);

    List<Reader> selectByCondition(Reader reader);

    Reader selectByrdID(int id);
}
