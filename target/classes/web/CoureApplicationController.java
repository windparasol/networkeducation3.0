package web;

import expand.Code;
import expand.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import po.CasePlan;
import po.PlanDetail;
import service.courseconstruction.CourseApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CoureApplicationController {
    @Autowired
    private CourseApplicationService courseApplication;

    /**测试**/
    @RequestMapping("/testcourseapplication")
    @ResponseBody
    public JsonBean testcourseapplication(int cpid){
        return new JsonBean(1,"ok",courseApplication.applicationquery(cpid));
    }

    /**获取当前教师的课程申请情况
    @PostMapping("/applicationstatus")
    @ResponseBody
    public JsonBean queryapplicationstatus(HttpSession session){
        if(session.getAttribute("usid")==null){
            return new JsonBean(0,"fasle",null);
        }
        List<CasePlan> casePlanList = courseApplication.querycaseplanbytcid((Integer)session.getAttribute("usid"));
        return casePlanList.size()==0?new JsonBean(1,"ok",null):new JsonBean(1,"ok",casePlanList);
    }**/

    /**案例课堂申请表填写**/
    @PostMapping("/courseapplication")
    @ResponseBody
    public Code courseapplication(HttpSession session, CasePlan caseplan, MultipartFile file, HttpServletRequest request) throws IOException {
        /**当session过期时的校验**/
        if(session.getAttribute("usid")==null){
            return new Code(0,"fasle");
        }
        String annexurl="/networkeducation3.0/Uploads/teacher/apply/"+session.getAttribute("usid")+"/";
        caseplan.setTcId((int)session.getAttribute("usid"));
        if(file!=null) {
            String filename = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("/Uploads/teacher/apply");
            String annexpath=path + File.separator +session.getAttribute("usid")+ File.separator +filename;
            File file1 = new File(annexpath);
            file1.mkdirs();
            file.transferTo(file1);
            annexurl +=filename;
            return new Code(courseApplication.courseapplication(annexurl,caseplan),"ok");
        }
        else return new Code(courseApplication.courseapplication(null,caseplan),"ok");
    }

    /**管理员进入课程申请管理页面后立即获取未批改的数据，与申请进度已经更新的数据**/
    @RequestMapping("/courseapplicationmanage")
    @ResponseBody
    public JsonBean managequeryapplication(){
        return courseApplication.querycaseplanbystate().size()==0?new JsonBean(2,"ok",null)
                : new JsonBean(1,"ok",courseApplication.querycaseplanbystate());
    }

    /**更新课程申请进度，教师和管理员通用一个controller**/
    @PostMapping("/updatacourseapplication")
    @ResponseBody
    public Code updatecourseapplication(MultipartFile file, PlanDetail planDetail,HttpSession session, HttpServletRequest request) throws IOException {
        /**当session过期时的校验**/
        if(session.getAttribute("usid")==null){
            return new Code(0,"fasle");
        }
        /**进行校验是否第一次修改 第一次修改会改变caseplan表里的state**/
        courseApplication.judgecaseplanstate(planDetail.getCpId());
        String annexurl="/networkeducation3.0/Uploads/coursemanage/";
        if(file!=null) {
            String filename = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("/Uploads/coursemanage");
            /**
             File filepath = new File(path, filename);
             上传文件是是文件夹时用到
             if (!filepath.getParentFile().exists()) {
             filepath.getParentFile().mkdirs();
             }**/
            String annexpath=path + File.separator +filename;
            File file1 = new File(annexpath);
            file1.mkdirs();
            file.transferTo(file1);
            annexurl +=filename;
            return new Code(courseApplication.updatacourseapplication(annexurl,planDetail),"ok");
        }
        else return new Code(courseApplication.updatacourseapplication(null,planDetail),"ok");
    }
    //更新是否被读
    @PostMapping("/updataread")
    @ResponseBody
    public Code updataread(@RequestParam("cpid")int cpid,HttpSession session){
        if(session.getAttribute("usid")==null)return new Code(2,"fasle");
        int usid =(int)session.getAttribute("usid");
        return new Code(courseApplication.updataread(cpid,usid),"ok");
    }

    //通过审查
    @RequestMapping("/applicationpass")
    @ResponseBody
    public Code applicationpass(@RequestParam("cpid")int cpid,HttpSession session) {

        if(session.getAttribute("usid")==null)return new Code(2,"fasle");
        if(courseApplication.casepass(cpid)==1) return new Code(1,"ok");
        return new Code(2,"ok");
    }

    
    /**教师跳转到课程申请页面
    @RequestMapping("/courseapplicationpage")
    public ModelAndView jumpTocoursemanage(ModelAndView modelAndView){
        modelAndView.setViewName("teacher/courseapplication");
        return modelAndView;
    }**/

    /**管理员跳转到课程批复页面
    @RequestMapping("/courseapplicationmanagementpage")
    public ModelAndView jumpTocourseapplicationmanagement(ModelAndView modelAndView,HttpSession session){
        if(session==null){
            modelAndView.setViewName("logoutofdate");
        }
        modelAndView.setViewName("leader/courseapplicationmanage");
        return modelAndView;
    }**/

}
