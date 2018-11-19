package com.maomao2.databasesharding.mapper.pkg2;
 
import com.maomao2.databasesharding.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
 
@Mapper
public interface UserMapper {
 
    User selectUserById(@Param("id") Long id);

    void insertSelective(User record);
}
