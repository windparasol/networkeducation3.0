package service.courseconstruction;

import dao.*;
import domain.AddCourseDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.*;

import java.util.*;

@Service
public class ClassRoomManageService {
    @Autowired
    private CasesMapper casesMapper;
    @Autowired
    private ClassRoomMapper classRoomMapper;
    @Autowired
    private CasePlanMapper casePlanMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  ClassRoomCaseMapper classRoomCaseMapper;
    @Autowired
    private  ActualQuestionMapper actualQuestionMapper;
    @Autowired
    private  QuestionReplyMapper questionReplyMapper;

    //测试方法
    public User test(int stid, int roid){

        System.out.println(userMapper.selectByPrimaryKey(stid));
        System.out.println(classRoomMapper.selectByPrimaryKey(roid));
        return userMapper.selectByPrimaryKey(stid);
    }

    //教师进入主页面后获取相关信息
   public Map<String,Object> teacherindexinfox(int tcid){
        Map<String,Object> map = new HashMap<>();
        map.put("listcaseplan",casePlanMapper.selectBytcId(tcid));
        map.put("listclassroom",classRoomMapper.selectBytcid(tcid));
        return map;
    }

    //教师进入课堂管理页面后的信息获取
    public Map<String ,Object> queryclassroomdetail(int roid){
        Map<String,Object> map = new HashMap<>();

        ClassRoom classRoom =classRoomMapper.selectByPrimaryKey(roid);
        if(classRoom.getClassRoomCaseList().size()>0){
            List<User> studentList=classRoom.getStudentList();
            int ccid = classRoom.getClassRoomCaseList().get(classRoom.getClassRoomCaseList().size() - 1).getCcId();
            for(int i =0;i<studentList.size();i++){
                List<QuestionReply>  questionReplyList = new ArrayList<>();
                for(int a=0;a<studentList.get(i).getQuestionReplyList().size();a++){
                    if(studentList.get(i).getQuestionReplyList().get(a).getCcId()==ccid)
                        questionReplyList.add(studentList.get(i).getQuestionReplyList().get(a));
                }
                studentList.get(i).setQuestionReplyList(questionReplyList);
            }
        }
        map.put("classroom",classRoom);
        return map;
    }
    //学生进入课堂页面后的信息获取
    public Map<String ,Object> queryonestudent(int roid,int usid){
        Map<String,Object> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap<>();
        ClassRoom classRoom =classRoomMapper.selectByroid(roid);
        if(classRoom.getClassRoomCaseList().size()>0){
            List<User> studentList=classRoom.getStudentList();
            int ccid = classRoom.getClassRoomCaseList().get(classRoom.getClassRoomCaseList().size() - 1).getCcId();

            map1.put("stId",usid);
            map1.put("ccId",ccid);
            List<QuestionReply> questionReplyList = questionReplyMapper.selectBystidAndccid(map1);
            map.put("questionreplylist",questionReplyList);
        }
        map.put("classroom",classRoom);
        return map;
    }

    public Cases getonecase(int csid){
        return casesMapper.selectByPrimaryKey(csid);
    }

    //教室创建课堂
    public int createclassroom(ClassRoom classRoom){
        return classRoomMapper.insert(classRoom);
    }

    //教室进入课堂详情页面后
    public List<Cases> getAllcase(){
        return casesMapper.selectByExample(new CasesExample());
    }

    //教师在教室中添加课程
    public int addcasecourse(int roid, AddCourseDomain addCourseDomain){
        int csid=addCourseDomain.getCsid();
        ClassRoomCase classRoomCase = new ClassRoomCase();
        classRoomCase.setCsId(csid);
        classRoomCase.setRoId(roid);
        classRoomCase.setStartTime(new Date());
        if(classRoomCaseMapper.insert(classRoomCase)!=1){return -1;}
        else {
            Map<String,Integer> map = new HashMap<>();
            map.put("csId",csid);
            map.put("roId",roid);
            List<ClassRoomCase> classRoomCaseList=classRoomCaseMapper.selectByroidAndcsid(map);
            System.out.println(classRoomCaseList);
            int ccid = classRoomCaseList.get(classRoomCaseList.size()-1).getCcId();
            for(int i =0;i<addCourseDomain.getActualQuestionList().size();i++){
                ActualQuestion actualQuestion= addCourseDomain.getActualQuestionList().get(i);
                actualQuestion.setCcId(ccid);
                System.out.println(actualQuestionMapper.insert(actualQuestion));
            }
        }
        return 1;
    }
}
