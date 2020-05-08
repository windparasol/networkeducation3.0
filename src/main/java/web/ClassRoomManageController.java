package web;

import domain.AddCourseDomain;
import expand.Code;
import expand.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.ClassRoom;
import service.courseconstruction.ClassRoomManageService;

import javax.servlet.http.HttpSession;

@Controller
public class ClassRoomManageController{

    @Autowired
    private ClassRoomManageService classRoomManage;

    //测试
    @RequestMapping("/testclassroom")
    @ResponseBody
    public JsonBean test(){
        return new JsonBean(1,"ok",classRoomManage.test(1,2));
    }

    //教师进入主界面后获取课程申请最新信息，以及课堂创建等信息，用map传出
    @RequestMapping("/getteacherindexpageinfo")
    @ResponseBody
    public JsonBean getteacherindexinfo(HttpSession session){
        if(session.getAttribute("usid")==null) return new JsonBean(2,"fasle",null);
        int tcid = (int)session.getAttribute("usid");
        return new JsonBean(1,"ok",classRoomManage.teacherindexinfox(tcid));
    }
    //教师进入课堂管理页面后进行信息获取
    @RequestMapping("/getclassroomdetail")
    @ResponseBody
    public JsonBean getclassroomdetail(HttpSession session){
        return session.getAttribute("usid")!=null&&session.getAttribute("roid")!=null
                ?new JsonBean(1,"ok",classRoomManage.queryclassroomdetail((int)session.getAttribute("roid")))
                :new JsonBean(2,"fasle",null);
    }


    //创建课堂页面
    @RequestMapping("/createclassroom")
    @ResponseBody
    public Code crateclassroom(ClassRoom classRoom, HttpSession session){
        if(session.getAttribute("usid")==null) return new Code(2,"fasle");
        classRoom.setTcId((int)session.getAttribute("usid"));
        return new Code(classRoomManage.createclassroom(classRoom),"ok");
    }

    //进入课程详情页面后，没有案例课程进行的情况下获取众多案例课程资源
    @RequestMapping("/getcaselist")
    @ResponseBody
    public JsonBean getcaselist(HttpSession session){
        return session.getAttribute("usid")!=null
                ?new JsonBean(1,"ok",classRoomManage.getAllcase())
                :new JsonBean(2,"fasle",null);
    }

    //教师跳转进入具体的某个课堂的管理页面
    @RequestMapping("/jumptoclassroomdetail")
    public ModelAndView jumpToclassroomdetail(HttpSession session,int roid,ModelAndView modelAndView){
        if(session.getAttribute("usid")==null){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        session.setAttribute("roid",roid);
        modelAndView.setViewName("teacher/classroomdetail");
        return modelAndView;
    }

    //添加案例课堂时的问题上传
    @PostMapping("/uploadcasequestions")
    @ResponseBody
    public Code addcasecourse(HttpSession session,@RequestBody AddCourseDomain addcoursedomain){
        return session.getAttribute("usid")==null&&session.getAttribute("roid")==null
                ?new Code(2,"fasle")
                :new Code(classRoomManage.addcasecourse((int)session.getAttribute("roid"),addcoursedomain),"ok");
    }

    //进入创建课堂页面
   /** @RequestMapping("/createclassroom")
    public ModelAndView createclassroom(ModelAndView modelAndView){
        modelAndView.setViewName("teacher/createclassroom");
        return modelAndView;
    }**/

}
