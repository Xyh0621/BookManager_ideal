package service;

import pojo.Reader;

import java.util.List;

public interface ReaderService {
    /*
    *
    * 查询所有读者
    *
    * */
    List<Reader> selectAll();



    //根据不同类型的用户进行登录
    List<Reader> selectByCondition(Reader reader);


    List<Reader> loginUser(Reader reader);
}
