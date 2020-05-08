package dao;

import org.springframework.stereotype.Repository;
import po.ReplyRecord;

import java.util.List;
import java.util.Map;

@Repository
public interface ReplyRecordMapper {
    int deleteByPrimaryKey(Integer rrId);

    int insert(ReplyRecord record);

    int insertSelective(ReplyRecord record);

    ReplyRecord selectByPrimaryKey(Integer rrId);

    int updateByPrimaryKeySelective(ReplyRecord record);

    int updateByPrimaryKey(ReplyRecord record);

    List<ReplyRecord> selectByqrid(int qrId);

    List<ReplyRecord> selectByqridAnduserType(Map<String,Object> map);
}