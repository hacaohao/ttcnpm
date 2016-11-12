package dao;

import entity.CartItem;
import entity.Invoice;
import entity.InvoiceItem;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class InvoiceItemDAO {
    public ArrayList<InvoiceItem> cartItemToInvoiceItem(ArrayList<CartItem> cart, Invoice invoice){
        ArrayList<InvoiceItem> items = new ArrayList<>();
        for(CartItem cartItem : cart){
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setPrice(cartItem.getPrice());
            invoiceItem.setQuantity(cartItem.getQuantity());
            invoiceItem.setBook(cartItem.getBook());
            invoiceItem.setInvoice(invoice);
            
            items.add(invoiceItem);
        }
        
        return items;
    }
    
    public void addInvoiceItem(InvoiceItem invoiceItem){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(invoiceItem);
        transaction.commit();
    }
}
