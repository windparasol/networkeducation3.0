package service.base;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.User;

import javax.servlet.http.HttpSession;

@Service
public class LoginRegisterService {
    @Autowired
    private UserMapper userMapper;

    //注册
    public int register(User user){
        return userMapper.insert(user)==1?1:0;
    }

    //邮箱校验
    public boolean emailjudge(String email){
        return userMapper.selectemailcount(email)!=0 ? true :false;
    }

    /**登录校验**/
    public int loginjudge(String email, String password,HttpSession session){
        User user =userMapper.selectByemail(email);
        if(user==null)return 0;
        if(password.equals(user.getPwd())){
            if(session.getAttribute("username")!=null){
                session.removeAttribute("username");
            }
            session.setAttribute("username",user.getNickname());
            session.setAttribute("usid",user.getUsId());
            if (user.getUserType().equals("1"))return 1;
            else if (user.getUserType().equals("2"))return 2;
            else if (user.getUserType().equals("3"))return 3;
        }
        return -1;
    }
}
