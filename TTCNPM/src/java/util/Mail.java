package util;

import entity.Invoice;
import java.io.StringWriter;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Mail {
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private VelocityEngine velocityEngine;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
    
    public void sendSignUpMail(String to, String password){
        sendMail("Đăng ký thành công với BKBook", to, password, "signup_template.vm");
    }
    
    public void sendForgetMail(String to){
        sendMail("Thông tin tài khoản BKBook", to, "123456", "forget_template.vm");
    }
    
    public void sendForgetMail(String to, String password){
        sendMail("Thông tin tài khoản BKBook", to, password, "forget_template.vm");
    }
    
    public void sendInvoiceMail(String to, Invoice invoice){
        MimeMessagePreparator preparator =  new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setSubject("Thông tin đơn hàng", "UTF-8");
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom("contact.bkbook@gmail.com");
                
                Template template = velocityEngine.getTemplate("invoice_template.vm", "UTF-8");
                VelocityContext velocityContext = new VelocityContext();
                velocityContext.put("code", invoice.getCode());
                velocityContext.put("name", invoice.getCustomerName());
                velocityContext.put("phone", invoice.getCustomerPhone());
                velocityContext.put("address", invoice.getCustomerAddress());
                velocityContext.put("boughtAt", invoice.getStringBoughtAt());
                velocityContext.put("payment", invoice.getPayment()?"Thanh toán khi nhận hàng":"Chuyển khoản");
                velocityContext.put("totalPrice", invoice.getTotalPrice());
                velocityContext.put("items", invoice.getInvoiceItems());
                

                StringWriter stringWriter = new StringWriter();
                template.merge(velocityContext, stringWriter);
                
                mimeMessage.setContent(stringWriter.toString(), "text/html;charset=UTF-8");
            }
        };       
        mailSender.send(preparator);
    }
    
    public void sendMail(String subject, String to, String password, String templateName){
        MimeMessagePreparator preparator =  new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setSubject(subject, "UTF-8");
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom("contact.bkbook@gmail.com");
                
                Template template = velocityEngine.getTemplate(templateName, "UTF-8");
                VelocityContext velocityContext = new VelocityContext();
                velocityContext.put("email", to);
                velocityContext.put("password", password);

                StringWriter stringWriter = new StringWriter();
                template.merge(velocityContext, stringWriter);
                
                mimeMessage.setContent(stringWriter.toString(), "text/html;charset=UTF-8");
            }
        };       
        mailSender.send(preparator);
    }
}
