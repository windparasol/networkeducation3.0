package service.courseconstruction;

import dao.CasePlanMapper;
import dao.PlanDetailMapper;
import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CasePlan;
import po.PlanDetail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseApplicationService {
    @Autowired
    private CasePlanMapper casePlanMapper;
    @Autowired
    private PlanDetailMapper planDetailMapper;
    @Autowired
    private UserMapper userMapper;
    /**测试**/
    public CasePlan applicationquery(int cpid){
        return casePlanMapper.selectByPrimaryKey(cpid);
    }

    /**查询当前教师的课程申请情况
    public List<CasePlan> querycaseplanbytcid(int tcid){
        return casePlanMapper.selectBytcId(tcid);
    }**/
    /**申请表以及附件录入**/
    public int courseapplication(String path,CasePlan casePlan){
        casePlan.setAnnexUrl(path);
        casePlan.setStime(new Date());
        casePlan.setState("0");
        casePlan.setPass("0");
        return casePlanMapper.insert(casePlan);
    }

    /**查询申请表中所有没有浏览的内容**/
    public List<CasePlan> querycaseplanbystate(){
        return casePlanMapper.selectBystate();
    }

    /**更新申请记录表**/
    public int updatacourseapplication(String path, PlanDetail planDetail){
        planDetail.setAnnexUrl(path);
        planDetail.setState("0");
        planDetail.setStime(new Date());
        return planDetailMapper.insert(planDetail);
    }
    /**查询caseplan表里的state**/
    public int judgecaseplanstate(int cpid){
        CasePlan casePlan = casePlanMapper.selectByPrimaryKey(cpid);
        if(casePlan.getState().equals("0")){
            casePlan.setState("1");
            return casePlanMapper.updateByPrimaryKey(casePlan);
        }
        return 0;
    }
    //更新申请信息是否被读
    public int updataread(int cpid,int usid){
        Map<String,Object> map = new HashMap();
        map.put("cpId",cpid);
        map.put("state","0");
        if(userMapper.selectByPrimaryKey(usid).getUserType().equals("3")){
            System.out.println(usid);
            map.put("cpType","2");
        }
        else map.put("cpType","1");
        for(PlanDetail planDetail:planDetailMapper.selectBycpIdAndstate(map)){
            System.out.println(usid);
            planDetail.setState("1");
            planDetailMapper.updateByPrimaryKey(planDetail);
        }
        return 1;
    }

    //给予通过
    public int casepass(int cpid){
        CasePlan casePlan = casePlanMapper.selectByPrimaryKey(cpid);
        casePlan.setPass("1");
        casePlan.setState("2");
        return casePlanMapper.updateByPrimaryKey(casePlan);
    }
}
