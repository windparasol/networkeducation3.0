package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import po.PlanDetail;
import po.PlanDetailExample;
@Repository
public interface PlanDetailMapper {
    long countByExample(PlanDetailExample example);

    int deleteByPrimaryKey(Integer pdId);

    int insert(PlanDetail record);

    int insertSelective(PlanDetail record);

    List<PlanDetail> selectByExample(PlanDetailExample example);

    PlanDetail selectByPrimaryKey(Integer pdId);

    int updateByExampleSelective(@Param("record") PlanDetail record, @Param("example") PlanDetailExample example);

    int updateByExample(@Param("record") PlanDetail record, @Param("example") PlanDetailExample example);

    int updateByPrimaryKeySelective(PlanDetail record);

    int updateByPrimaryKey(PlanDetail record);

    List<PlanDetail> selectBycpId(int cpId);

    List<PlanDetail> selectBycpIdAndstate(Map map);
}