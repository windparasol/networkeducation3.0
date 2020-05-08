package service.teachingprocess;

import dao.CasesMapper;
import dao.QuestionReplyMapper;
import dao.ReplyRecordMapper;
import dao.UserMapper;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import po.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeachManageService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CasesMapper casesMapper;

    @Autowired
    private QuestionReplyMapper questionReplyMapper;

    @Autowired
    private ReplyRecordMapper replyRecordMapper;

    //衔接getstudentindexinfo
    public Map<String,Object> getstudentinfo(int usid){
        Map<String,Object> map = new HashMap<>();
        map.put("student",userMapper.selectByPrimaryKey(usid));
        return map;
    }

    //学生加入课堂
    public int joinclassroom(int stid,int roid){
        //校验是否已经加入课堂
        List<ClassRoom> classRoomList=userMapper.selectByPrimaryKey(stid).getClassRoomList();
        for(ClassRoom classRoom:classRoomList){
            if (classRoom.getRoId() ==roid)return 2;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("stId",stid);
        map.put("roId",roid);
        map.put("stime",new Date());
        map.put("state","0");
        return userMapper.insertstudentclassroom(map);
    }

    //更新关卡信息
    public int updataquestionstate(int ccid,int stid,int usid){
        Map<String,Integer> map = new HashMap<>();
        map.put("ccId",ccid);
        map.put("stId",stid);
        List<QuestionReply> questionReplyList=questionReplyMapper.selectBystidAndccid(map);
        if(questionReplyList.size()==0)return -1;

        int qrid = questionReplyList.get(questionReplyList.size()-1).getQrId();

        if(userMapper.selectByPrimaryKey(usid).getUserType().equals("1")){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("qrId",qrid);
            map1.put("userType","2");
            map1.put("rstate","0");
            List<ReplyRecord> replyRecordList =replyRecordMapper.selectByqridAnduserType(map1);
            for (ReplyRecord replyRecord:replyRecordList){
                replyRecord.setRstate("1");
                replyRecordMapper.updateByPrimaryKey(replyRecord);
            }
            return 1;
        }
        else if(userMapper.selectByPrimaryKey(usid).getUserType().equals("2")){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("qrId",qrid);
            map1.put("userType","1");
            map1.put("rstate","0");
            List<ReplyRecord> replyRecordList =replyRecordMapper.selectByqridAnduserType(map1);
            for (ReplyRecord replyRecord:replyRecordList){
                replyRecord.setRstate("1");
                replyRecordMapper.updateByPrimaryKey(replyRecord);
            }
            return 1;
        }
        return -1;
    }

    //更新问题回复 教师和学生通用一个service方法
    public int updataquestionreply(int usid,ReplyRecord replyRecord,String annexurl){
        if(userMapper.selectByPrimaryKey(usid).getUserType().equals("1")){
            replyRecord.setRstate("0");
            replyRecord.setUserType("1");
            replyRecord.setAnnexurl(annexurl);
            return replyRecordMapper.insert(replyRecord);
        }
        else if(userMapper.selectByPrimaryKey(usid).equals("2")){
            replyRecord.setRstate("0");
            replyRecord.setUserType("2");
            replyRecord.setAnnexurl(annexurl);
            return replyRecordMapper.insert(replyRecord);
        }
        return -1;
    }

    //学生第一次回答某个问题
    public int fristreply(ReplyRecord replyRecord,String annexurl,QuestionReply questionReply){
        questionReply.setQstate("0");
        int code = questionReplyMapper.insert(questionReply);
        if(code==1){
            Map<String,Integer> map = new HashMap<>();
            map.put("stId",questionReply.getStId());
            map.put("ccId",questionReply.getCcId());
            map.put("aqId",questionReply.getAqId());
           replyRecord.setQrId(questionReplyMapper.selectByccidAndaqidAndstid(map).getQrId());
           replyRecord.setRstate("0");
           replyRecord.setUserType("2");
           replyRecord.setAnnexurl(annexurl);
           return replyRecordMapper.insert(replyRecord);
        }
        return code;
    }

    //跳转到课程资源页面
    public Cases getcaseurl(int csid){
        return casesMapper.selectByPrimaryKey(csid);
    }
}
