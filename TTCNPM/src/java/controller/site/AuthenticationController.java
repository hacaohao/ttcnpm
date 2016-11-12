package controller.site;

import entity.Member;
import entity.User;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MemberService;
import service.UserService;
import util.EncodeUtil;
import util.Mail;

@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController extends BaseController{
    private static final int MEMBER = 4;
    private SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
    
    @Autowired
    UserService userService;
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public void signup(HttpServletRequest request, HttpServletResponse respone) throws ParseException, IOException{
        String result;
        
        String name = request.getParameter("name");
        String phone = request.getParameter("contactnumber");
        String dob = request.getParameter("bdate");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String sex = request.getParameter("sex");
        
        if(userService.checkUniqueEmail(email) && password.equalsIgnoreCase(confirm)){
            User user = new User();
            Member member = new Member();
            
            user.setEmail(email);
            user.setPassword(EncodeUtil.md5Formatter(password));
            user.setRole(MEMBER);
            user.setMember(member);
            user.setUpdatedPasswordAt(formatter.parse(formatter.format(new Date())));
            
            member.setAvatar("defaultUser.png");
            member.setCode(memberService.createCode());
            member.setDoB(formatter.parse(dob));
            member.setSex(Boolean.parseBoolean(sex));
            member.setName(name);
            member.setPhone(phone);
            member.setCreatedAt(formatter.parse(formatter.format(new Date())));
            
            userService.addUser(user);
            
            ApplicationContext context = new ClassPathXmlApplicationContext("Mail.xml");
            Mail mailSender = (Mail) context.getBean("mail");
            mailSender.sendSignUpMail(email, password);
            
            result =  "Đăng ký thành công, vui lòng kiểm tra mail để kiểm tra thông tin.";
        }else{
            result = "Có lỗi, vui lòng kiểm tra!";
        }
        
        OutputStream outputStream = respone.getOutputStream();
        outputStream.write(result.getBytes("UTF-8"));
        outputStream.close();
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public void signin(HttpServletRequest request, HttpServletResponse respone) throws IOException{
        String result;
    
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = userService.checkAccount(email, password);
        
        if(user != null){
            request.getSession().setAttribute("user", user);
            
            result =  "Đăng nhập thành công.";
        }else{
            result = "Có lỗi, vui lòng kiểm tra!";
        }
        
        OutputStream outputStream = respone.getOutputStream();
        outputStream.write(result.getBytes("UTF-8"));
        outputStream.close();
    }
    
    @RequestMapping(value = "/forget", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public void forget(HttpServletRequest request, HttpServletResponse respone) throws IOException{
        String result;
    
        String email = request.getParameter("email");
        
        if(userService.checkExistEmail(email)){
            userService.updatePassword(email);
            
            ApplicationContext context = new ClassPathXmlApplicationContext("Mail.xml");
            Mail mailSender = (Mail) context.getBean("mail");
            mailSender.sendForgetMail(email);
            
            result =  "Password mới đã được gửi vào email.";
        }else{
            result = "Email không tồn tại!";
        }
        
        OutputStream outputStream = respone.getOutputStream();
        outputStream.write(result.getBytes("UTF-8"));
        outputStream.close();
    }
    
    @RequestMapping(value = "/logout")
    public String forget(HttpServletRequest request){
        request.getSession().removeAttribute("user");     
        return "redirect:/site/index";
    }
}
