package controller.site;

import static controller.site.BaseController.VIEW;
import entity.CartItem;
import entity.Invoice;
import entity.InvoiceItem;
import entity.Member;
import entity.User;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import service.CartItemService;
import service.InvoiceItemService;
import service.InvoiceService;
import service.MemberService;
import util.Mail;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController extends BaseController{
    private SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
    
    @Autowired
    CartItemService cartItemService;
    
    @Autowired
    InvoiceService invoiceService;
    
    @Autowired
    InvoiceItemService invoiceItemService;
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping(value = "/initCheckout")
    public String initCheckout(HttpServletRequest request, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        
        ArrayList<CartItem> cart = null;
        
        if((User)request.getSession().getAttribute("user") != null){
            cart = ((User)request.getSession().getAttribute("user")).getMember().getCartItems();
        }
        
        request.getSession().setAttribute("invoice", new Invoice());
        
        mm.put("cart", cart);
        mm.put("totalPrice", cartItemService.totalPrice(cart));
        mm.put("content", "thongtinmuahang1");
        return VIEW;
    }
    
    @RequestMapping(value = "/checkoutStep1", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String checkoutStep1(HttpServletRequest request, @ModelAttribute("invoice")Invoice invoice, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        ArrayList<CartItem> cart = null;
        
        if((User)request.getSession().getAttribute("user") != null){
            cart = ((User)request.getSession().getAttribute("user")).getMember().getCartItems();
        }
        
        Invoice oldInvoice = (Invoice) request.getSession().getAttribute("invoice");
        oldInvoice.setCustomerEmail(invoice.getCustomerEmail());
      
        request.getSession().setAttribute("invoice", oldInvoice);
        
        mm.put("cart", cart);
        mm.put("totalPrice", cartItemService.totalPrice(cart));
        mm.put("content", "thongtinmuahang2");
        return VIEW;
    }
    
    @RequestMapping(value = "/checkoutStep2", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String checkoutStep2(HttpServletRequest request, @ModelAttribute("invoice")Invoice invoice, ModelMap mm) throws UnsupportedEncodingException{   
        mm = super.getDefaultAttribute(mm);
        ArrayList<CartItem> cart = null;
        
        if((User)request.getSession().getAttribute("user") != null){
            cart = ((User)request.getSession().getAttribute("user")).getMember().getCartItems();
        }
        
        Invoice oldInvoice = (Invoice) request.getSession().getAttribute("invoice");
        oldInvoice.setCustomerName(invoice.getCustomerName());
        oldInvoice.setCustomerPhone(invoice.getCustomerPhone());
        oldInvoice.setCustomerAddress(invoice.getCustomerAddress());
      
        request.getSession().setAttribute("invoice", oldInvoice);
        
        mm.put("cart", cart);
        mm.put("totalPrice", cartItemService.totalPrice(cart));
        mm.put("content", "thongtinmuahang3");
        return VIEW;
    }
    
    @RequestMapping(value = "/finalStep", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String finalStep(HttpServletRequest request, @ModelAttribute("invoice")Invoice invoice, ModelMap mm) throws ParseException{
        mm = super.getDefaultAttribute(mm);
        
        Invoice oldInvoice = (Invoice) request.getSession().getAttribute("invoice");
        oldInvoice.setCode(invoiceService.createCode());
        oldInvoice.setBoughtAt(formatter.parse(formatter.format(new Date())));
        oldInvoice.setPayment(invoice.getPayment());
        
        ArrayList<CartItem> cart;
        
        if((User)request.getSession().getAttribute("user") != null){
            cart = ((User)request.getSession().getAttribute("user")).getMember().getCartItems();
            Member member = memberService.updatePoint(((User)request.getSession().getAttribute("user")).getMember(), cartItemService.totalPrice(cart));
            member = memberService.updateTotalPoint(member, cartItemService.totalPrice(cart));
            memberService.updateMember(member);
            
            ArrayList<InvoiceItem> items = invoiceItemService.cartItemToInvoiceItem(cart, oldInvoice);
            oldInvoice.setInvoiceItems(items);
            
            cartItemService.deleteCart(cart);
            cart.clear();
            member.setCartItems(cart);
            
            ((User)request.getSession().getAttribute("user")).setMember(member);
            invoiceService.insertInvoice(oldInvoice);
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Mail.xml");
        Mail mailSender = (Mail) context.getBean("mail");
        mailSender.sendInvoiceMail(oldInvoice.getCustomerEmail(), oldInvoice);
      
        request.getSession().setAttribute("invoice", null);
        
        return "redirect:/site/index";
    }
}
