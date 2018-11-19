package com.maomao2.databasesharding.dao;
 
import com.maomao2.databasesharding.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
 
@Component
public class UserDao {
 
    private final SqlSession sqlSession;
 
    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
 
    public User findUserById(Long id) {
        return this.sqlSession.selectOne("selectUserById", id);
    }
}
