package dao;

import org.springframework.stereotype.Repository;
import po.QuestionReply;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionReplyMapper {
    int deleteByPrimaryKey(Integer qrId);

    int insert(QuestionReply record);

    int insertSelective(QuestionReply record);

    QuestionReply selectByPrimaryKey(Integer qrId);

    int updateByPrimaryKeySelective(QuestionReply record);

    int updateByPrimaryKey(QuestionReply record);

    List<QuestionReply> selectByccid(int ccId);

    List<QuestionReply> selectBystid(int stId);

    List<QuestionReply> selectBystidAndccid(Map<String,Integer> map);


    QuestionReply selectByccidAndaqidAndstid(Map<String,Integer> map);
}