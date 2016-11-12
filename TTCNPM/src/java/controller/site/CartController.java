package controller.site;

import entity.CartItem;
import entity.Member;
import entity.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pagination.Page;
import service.CartItemService;
import service.UserService;

@Controller
@RequestMapping(value = "/cart")
public class CartController extends BaseController{
    
    @Autowired
    UserService userService;
    
    @Autowired
    CartItemService cartItemService;
    
    @RequestMapping(value = "/seeCart")
    public String seeCart(HttpServletRequest request, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        
        int currentPage = Integer.parseInt(request.getParameter("page"));
        ArrayList<CartItem> cart = null;
        
        if((User)request.getSession().getAttribute("user") != null){
            cart = ((User)request.getSession().getAttribute("user")).getMember().getCartItems();
        }
        
        Page page = new Page(cart);
        page.setCurrentIndex(currentPage);
        page.setBaseUrl("cart/seeCart");
        
        mm.put("page", page);
        mm.put("cart", cart);
        mm.put("totalPrice", cartItemService.totalPrice(cart));
        mm.put("content", "giohang");
        
        return VIEW;
    }
    
    @RequestMapping(value = "/addToCart")
    public String addToCart(HttpServletRequest request, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        
        int itemId = Integer.parseInt(request.getParameter("id"));
        
        if(request.getSession().getAttribute("user") != null){
            Member member = ((User)request.getSession().getAttribute("user")).getMember();
            ArrayList<CartItem> newCart = cartItemService.addToCart(itemId, member);
            
            ((User)request.getSession().getAttribute("user")).getMember().setCartItems(newCart);
        }
               
        return "redirect:/cart/seeCart?page=1";
    }
    
    @RequestMapping(value = "/updateQuantity", method = RequestMethod.POST)
    public String updateQuantity(HttpServletRequest request, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        
        int index = Integer.parseInt(request.getParameter("index"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        if(request.getSession().getAttribute("user") != null){
            Member member = ((User)request.getSession().getAttribute("user")).getMember();
            ArrayList<CartItem> cart = member.getCartItems();
            CartItem item = cart.get(index);
            item.setQuantity(quantity);
            
            cartItemService.updateCartItem(item);
            
            ((User)request.getSession().getAttribute("user")).getMember().setCartItems(cart);
        }
               
        return "redirect:/cart/seeCart?page=1";
    }
    
    @RequestMapping(value = "/deleteItem")
    public String deleteItem(HttpServletRequest request, ModelMap mm){   
        mm = super.getDefaultAttribute(mm);
        
        int index = Integer.parseInt(request.getParameter("index"));
        
        if(request.getSession().getAttribute("user") != null){
            Member member = ((User)request.getSession().getAttribute("user")).getMember();
            ArrayList<CartItem> cart = member.getCartItems();
            CartItem item = cart.get(index);
            
            cartItemService.deleteCartItem(item);
            cart.remove(index);
            
            ((User)request.getSession().getAttribute("user")).getMember().setCartItems(cart);
        }
               
        return "redirect:/cart/seeCart?page=1";
    }
}
