package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Cases;
import po.CasesExample;
@Repository
public interface CasesMapper {
    long countByExample(CasesExample example);

    int deleteByPrimaryKey(Integer csId);

    int insert(Cases record);

    int insertSelective(Cases record);

    List<Cases> selectByExample(CasesExample example);

    Cases selectByPrimaryKey(Integer csId);

    int updateByExampleSelective(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByExample(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByPrimaryKeySelective(Cases record);

    int updateByPrimaryKey(Cases record);
}