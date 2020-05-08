package dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.User;
import po.UserExample;
@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByPrimaryKey(Integer usId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer usId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectemailcount(String email);

    User selectByemail(String email);

    User selectByroid(int roId);

    int insertstudentclassroom(Map<String,Object> map);

    int selectBytcid(int tcId);
}