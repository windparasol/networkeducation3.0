package dao;

import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Case;
import org.springframework.stereotype.Repository;
import po.ClassRoom;
import po.ClassRoomCase;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassRoomCaseMapper {
    int deleteByPrimaryKey(Integer ccId);

    int insert(ClassRoomCase record);

    int insertSelective(ClassRoomCase record);

    ClassRoomCase selectByPrimaryKey(Integer ccId);

    int updateByPrimaryKeySelective(ClassRoomCase record);

    int updateByPrimaryKey(ClassRoomCase record);

    List<ClassRoomCase> selectByroid(int roId);

    List<ClassRoomCase> selectByroidAll(int roId);

    List<ClassRoomCase> selectByroidAndcsid(Map map);

    List<ClassRoomCase> selectByroidtwo(int roId);
}