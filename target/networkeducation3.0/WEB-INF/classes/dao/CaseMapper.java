package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.Case;
import po.CaseExample;
@Repository
public interface CaseMapper {
    long countByExample(CaseExample example);

    int deleteByPrimaryKey(Integer csId);

    int insert(Case record);

    int insertSelective(Case record);

    List<Case> selectByExample(CaseExample example);

    Case selectByPrimaryKey(Integer csId);

    int updateByExampleSelective(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByExample(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}