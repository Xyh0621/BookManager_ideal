package mapper;

import pojo.ReaderType;

import java.util.List;

public interface ReaderTypeMapper {
    List<ReaderType> selectAll();

    ReaderType selectByrdTypeID(int rdTypeID);
}
