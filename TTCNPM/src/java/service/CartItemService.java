package service;

import dao.CartItemDAO;
import entity.CartItem;
import entity.Member;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class CartItemService {
    @Autowired
    CartItemDAO cartItemDAO;
    
    public ArrayList<CartItem> addToCart(int itemID, Member member){
        return cartItemDAO.addToCart(itemID, member);
    }
    
     public int totalPrice(ArrayList<CartItem> cart){
         return cartItemDAO.totalPrice(cart);
     }
     
     public void updateCartItem(CartItem cartItem){
         cartItemDAO.updateCartItem(cartItem);
     }
     
     public void deleteCartItem(CartItem cartItem){
         cartItemDAO.deleteCartItem(cartItem);
     }
     
     public void deleteCart(ArrayList<CartItem> cart){
         cartItemDAO.deleteCart(cart);
     }
}
