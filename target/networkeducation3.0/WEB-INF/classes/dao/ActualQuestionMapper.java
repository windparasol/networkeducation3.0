package dao;

import org.springframework.stereotype.Repository;
import po.ActualQuestion;

import java.util.List;

@Repository
public interface ActualQuestionMapper {
    int deleteByPrimaryKey(Integer aqId);

    int insert(ActualQuestion record);

    int insertSelective(ActualQuestion record);

    ActualQuestion selectByPrimaryKey(Integer aqId);

    int updateByPrimaryKeySelective(ActualQuestion record);

    int updateByPrimaryKey(ActualQuestion record);

    List<ActualQuestion>  selectByccid(int ccid);
}