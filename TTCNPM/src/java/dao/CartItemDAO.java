package dao;

import entity.Book;
import entity.CartItem;
import entity.Member;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import service.BookService;
import util.HibernateUtil;

public class CartItemDAO {
    private static final String TABLE = "thanh_phan_gio_hang";
    
    @Autowired
    BookService bookService;
    
    public ArrayList<CartItem> addToCart(int bookID, Member member){
        Book book = bookService.getBookByID(bookID);
        
        CartItem item = new CartItem();
        item.setBook(book);
        item.setPrice(book.getSalePrice());
        item.setQuantity(1);
        item.setMember(member);
        
        ArrayList<CartItem> cart = member.getCartItems();
        
        for(CartItem cartItem : cart){
            if(cartItem.getBook().getName().equalsIgnoreCase(book.getName())){
                int quantity = cartItem.getQuantity() + 1;
                cartItem.setQuantity(quantity);
                updateCartItem(cartItem);
                return cart;
            }
        }
        
        cart.add(item);
        addCartItem(item);
        
        return cart;
    }
    
    public int totalPrice(ArrayList<CartItem> cart){
        int totalPrice = 0;
            
        for(CartItem cartItem : cart){
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        
        return totalPrice;
    }
    
    public CartItem getCartItemByID(int itemID){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        Query query = (Query) session.createQuery("from " + TABLE + " where id = :id");
        query.setInteger("id", itemID);
        
        CartItem book = (CartItem) query.uniqueResult();
        transaction.commit();
        return book;
    }
    
    public void addCartItem(CartItem cartItem){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(cartItem);
        transaction.commit();
    }
    
    public void deleteCart(ArrayList<CartItem> cart){
        for(CartItem item : cart){
            deleteCartItem(item);
        }
    }
    
    public void deleteCartItem(CartItem cartItem){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(cartItem);
        transaction.commit();
    }
    
    public void updateCartItem(CartItem cartItem){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(cartItem);
        transaction.commit();
    }
}
