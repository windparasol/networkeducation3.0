package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.CasePlan;
import po.CasePlanExample;
@Repository
public interface CasePlanMapper {
    long countByExample(CasePlanExample example);

    int deleteByPrimaryKey(Integer cpId);

    int insert(CasePlan record);

    int insertSelective(CasePlan record);

    List<CasePlan> selectByExample(CasePlanExample example);

    CasePlan selectByPrimaryKey(Integer cpId);

    int updateByExampleSelective(@Param("record") CasePlan record, @Param("example") CasePlanExample example);

    int updateByExample(@Param("record") CasePlan record, @Param("example") CasePlanExample example);

    int updateByPrimaryKeySelective(CasePlan record);

    int updateByPrimaryKey(CasePlan record);

    List<CasePlan> selectBytcId(int tcId);

    List<CasePlan> selectBystate();
}