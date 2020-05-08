package web;

import expand.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.User;
import service.base.LoginRegisterService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {
    @Autowired
    private LoginRegisterService loginRegisterService;

    /**注册**/
    @PostMapping("/register")
    @ResponseBody
    public Code register(User user){
        System.out.println(user);
       if(loginRegisterService.register(user)==1);
        return user.getUserType().equals("1")?new Code(1,"ok"):new Code(2,"ok");
    }

    /**判断邮箱是否被注册**/
    @RequestMapping("/judgemail")
    @ResponseBody
    public int judgemail(String email){
        return loginRegisterService.emailjudge(email)?1:0;
    }

    /**登录**/
    /**跳转**/
    @PostMapping("/login")
    public ModelAndView userlogin(String email, String password, HttpSession session,ModelAndView modelAndView){
        switch (loginRegisterService.loginjudge(email,password,session)){
            case 1: modelAndView.setViewName("teacher/teacherindex");return modelAndView;
            case 2: modelAndView.setViewName("student/studentindex");return modelAndView;
            case 3: modelAndView.setViewName("leader/leaderindex");return modelAndView;
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping("/jumptologin")
    public ModelAndView jumptologin(HttpSession session,ModelAndView modelAndView){
        if (session.getAttribute("usid")!=null){
            session.removeAttribute("usid");
        }
        if(session.getAttribute("roid")!=null){
            session.removeAttribute("roid");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
