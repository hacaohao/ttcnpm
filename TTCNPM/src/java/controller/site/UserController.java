package controller.site;

import entity.Member;
import entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;
import util.EncodeUtil;
import util.Mail;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    private SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/info")
    public String info(ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
               
        mm.put("user", new User());
        mm.put("member", new Member());
        mm.put("content", "thongtincanhan");
        return VIEW;
    }
    
    @RequestMapping(value = "/updateInfoMember", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String updateInfoMember(HttpServletRequest request, @ModelAttribute("Member")Member member){  
        Member oldMemberInfo = ((User) request.getSession().getAttribute("user")).getMember();
        User oldUserInfo = (User) request.getSession().getAttribute("user");
        
        if(member.getName() != null){
            oldMemberInfo.setName(member.getName());
        }
        
        if(member.getPhone() != null){
            oldMemberInfo.setPhone(member.getPhone());
        }
        
        oldUserInfo.setMember(oldMemberInfo);
        userService.updateUser(oldUserInfo);
        
        return "redirect:/user/info";
    }
    
    @RequestMapping(value = "/updateInfoUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String updateInfoUser(HttpServletRequest request, @ModelAttribute("User")User user) throws ParseException{  
        User oldUserInfo = (User) request.getSession().getAttribute("user");
        
        if(user.getPassword() != null){
            String encodedPassword = EncodeUtil.md5Formatter(user.getPassword());
            oldUserInfo.setPassword(encodedPassword);
            oldUserInfo.setUpdatedPasswordAt(formatter.parse(formatter.format(new Date())));
        }
        
        userService.updateUser(oldUserInfo);
              
        ApplicationContext context = new ClassPathXmlApplicationContext("Mail.xml");
        Mail mailSender = (Mail) context.getBean("mail");
        mailSender.sendForgetMail(oldUserInfo.getEmail(), user.getPassword());
        
        request.getSession().setAttribute("user", oldUserInfo);
        
        return "redirect:/user/info";
    }
}
