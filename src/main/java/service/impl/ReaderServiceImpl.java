package service.impl;

import mapper.ReaderMapper;
import mapper.ReaderTypeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Reader;
import pojo.ReaderType;
import service.ReaderService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    //创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Reader> selectAll() {
        SqlSession sqlSession = factory.openSession();
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);
        ReaderTypeMapper readerTypeMapper = sqlSession.getMapper(ReaderTypeMapper.class);


        List<Reader> readers = readerMapper.selectAll();

        for(Reader reader: readers){
            ReaderType readerType = readerTypeMapper.selectByrdTypeID(reader.getRdType());
            reader.setRdTypeStr(readerType.getRdTypeName());
        }

        sqlSession.close();

        return  readers;
    }

    @Override
    public List<Reader> selectByCondition(Reader reader) {
        SqlSession sqlSession = factory.openSession();
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);

        List<Reader> readers = readerMapper.selectByCondition(reader);

        sqlSession.close();

        return readers;
    }

    @Override
    public List<Reader> loginUser(Reader UserReader) {

        SqlSession sqlSession = factory.openSession();
        ReaderMapper readerMapper = sqlSession.getMapper(ReaderMapper.class);
        ReaderTypeMapper readerTypeMapper = sqlSession.getMapper(ReaderTypeMapper.class);

        List<Reader> readers = readerMapper.selectByCondition(UserReader);

        for(Reader reader: readers){
            ReaderType readerType = readerTypeMapper.selectByrdTypeID(reader.getRdType());
            reader.setRdTypeStr(readerType.getRdTypeName());
        }

        sqlSession.close();

        return readers;
    }
}
