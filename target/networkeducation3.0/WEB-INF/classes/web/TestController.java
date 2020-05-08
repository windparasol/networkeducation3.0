package web;

import expand.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.base.TestService;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public JsonBean test(int roid){
        return new JsonBean(1,"ok",testService.testclassroom(roid));
    }
}
