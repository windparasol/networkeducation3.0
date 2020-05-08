package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.ClassRoom;
import po.ClassRoomExample;
@Repository
public interface ClassRoomMapper {
    long countByExample(ClassRoomExample example);

    int deleteByPrimaryKey(Integer roId);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    List<ClassRoom> selectByExample(ClassRoomExample example);

    ClassRoom selectByPrimaryKey(Integer roId);

    int updateByExampleSelective(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByExample(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);

    List<ClassRoom> selectBystid(int stId);

    List<ClassRoom> selectBytcid(int tcId);

    ClassRoom selectByroid(int roId);
}