package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.CaseQuestion;
import po.CaseQuestionExample;
@Repository
public interface CaseQuestionMapper {
    long countByExample(CaseQuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(CaseQuestion record);

    int insertSelective(CaseQuestion record);

    List<CaseQuestion> selectByExample(CaseQuestionExample example);

    CaseQuestion selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") CaseQuestion record, @Param("example") CaseQuestionExample example);

    int updateByExample(@Param("record") CaseQuestion record, @Param("example") CaseQuestionExample example);

    int updateByPrimaryKeySelective(CaseQuestion record);

    int updateByPrimaryKey(CaseQuestion record);

    List<CaseQuestion> selectBycsid(int csId);
}