package web;

import dao.ClassRoomMapper;
import expand.Code;
import expand.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import po.ClassRoom;
import po.QuestionReply;
import po.ReplyRecord;
import service.courseconstruction.ClassRoomManageService;
import service.teachingprocess.TeachManageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class TeachManageController {
    @Autowired
    private TeachManageService teachManageService;

    @Autowired
    private ClassRoomManageService classRoomManageService;

    //学生进入学生主页后获取相关信息
    @RequestMapping("/studentindex")
    @ResponseBody
    public JsonBean getstudentindexinfo(HttpSession session){
        return session.getAttribute("usid")==null ? new JsonBean(2,"fasle",null):
        new JsonBean(1,"ok",teachManageService.getstudentinfo((int)session.getAttribute("usid")));
    }

    //学生加入课堂
    @PostMapping("/joinclassroom")
    @ResponseBody
    public Code joinclassroom(HttpSession session,int secretkey) {
        int usid = (int)session.getAttribute("usid");
        int state =teachManageService.joinclassroom(usid,secretkey);
        return session.getAttribute("usid") != null ||state ==1?
                new Code(state,"ok"):new Code(state,"fasle");
    }
    //教师和学生更新关卡消息未读
    @RequestMapping("/updataquestionstate")
    @ResponseBody
    public Code updataquestionstate(HttpSession session,int stid,int ccid){
        if(session.getAttribute("usid")==null)return new Code(2,"fasle");


        return new Code(teachManageService.updataquestionstate(ccid,stid,(int)session.getAttribute("usid")),"ok");
    }
    //教师和学生提交问题引导或答案
    @RequestMapping("/updataquestionreply")
    @ResponseBody
    public Code updataquestionreply(HttpSession session, ReplyRecord replyRecord, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(replyRecord);
        /**当session过期时的校验**/
        if(session.getAttribute("usid")==null){
            return new Code(0,"fasle");
        }
        String annexurl="/networkeducation3.0/Uploads/teacher/teaching/"+session.getAttribute("usid")+"/";
        if(file!=null) {
            String filename = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("/Uploads/teacher/teaching");
            /**
             File filepath = new File(path, filename);
             上传文件是是文件夹时用到
             if (!filepath.getParentFile().exists()) {
             filepath.getParentFile().mkdirs();
             }**/
            String annexpath=path + File.separator +session.getAttribute("usid")+ File.separator +filename;
            File file1 = new File(annexpath);
            file1.mkdirs();
            file.transferTo(file1);
            annexurl +=filename;
            return new Code(teachManageService.updataquestionreply((int)session.getAttribute("usid"),replyRecord,annexurl),"ok");
        }
        else return new Code(teachManageService.updataquestionreply((int)session.getAttribute("usid"),replyRecord,null),"ok");
    }
    //学生第一次回答某个问题
    @RequestMapping("/fristquestionreply")
    @ResponseBody
    public Code updataquestionreply(HttpSession session, ReplyRecord replyRecord, QuestionReply questionReply, MultipartFile file, HttpServletRequest request) throws IOException {
        if(session.getAttribute("usid")==null){
            return new Code(0,"fasle");
        }
        questionReply.setStId((int)session.getAttribute("usid"));
        String annexurl="/networkeducation3.0/Uploads/teacher/teaching/"+session.getAttribute("usid")+"/";
        if(file!=null) {
            String filename = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("/Uploads/teacher/teaching");
            /**
             File filepath = new File(path, filename);
             上传文件是是文件夹时用到
             if (!filepath.getParentFile().exists()) {
             filepath.getParentFile().mkdirs();
             }**/
            String annexpath=path + File.separator +session.getAttribute("usid")+ File.separator +filename;
            File file1 = new File(annexpath);
            file1.mkdirs();
            file.transferTo(file1);
            annexurl +=filename;
            return new Code(teachManageService.fristreply(replyRecord,annexurl,questionReply),"ok");
        }
        return new Code(teachManageService.fristreply(replyRecord,null,questionReply),"ok");
    }


    //学生进入课堂后
    @RequestMapping("/getclassroomstudentinfo")
    @ResponseBody
    public JsonBean getclassroominfo(HttpSession session){
        return session.getAttribute("usid")!=null&&session.getAttribute("roid")!=null
                ?new JsonBean(1,"ok",classRoomManageService.queryonestudent((int)session.getAttribute("roid"),(int)session.getAttribute("usid")))
                :new JsonBean(2,"fasle",null);
    }

    //跳转到课程资源页面
    @RequestMapping("/jumpTocourseresource")
    public ModelAndView jumpTocourseresourcepage(int csid,HttpSession session,ModelAndView modelAndView){
        if(session.getAttribute("usid")==null){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        session.setAttribute("csid",csid);
        modelAndView.setViewName(teachManageService.getcaseurl(csid).getPageUrl());
        return modelAndView;
    }
    //学生跳转到某个实际的课堂页面
    @RequestMapping("/jumptostudentclassroom")
    public ModelAndView jumptostudentclassroom(HttpSession session,int roid,ModelAndView modelAndView){
        if(session.getAttribute("usid")==null){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        session.setAttribute("roid",roid);
        modelAndView.setViewName("student/studentclassroom");
        return modelAndView;
    }

    //进入相对应课程的资源页面获取对应case的所有资源caseresources.do
    @RequestMapping("/caseresources")
    @ResponseBody
    public JsonBean getcaseresource(HttpSession session){
        if(session.getAttribute("csid")==null){
            return new JsonBean(0,"fasle",null);
        }
        return new JsonBean(1,"ok",classRoomManageService.getonecase((int)session.getAttribute("csid")));

    }


}
