package service;

import dao.InvoiceItemDAO;
import entity.CartItem;
import entity.Invoice;
import entity.InvoiceItem;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceItemService {
   @Autowired
   InvoiceItemDAO invoiceItemDAO;
   
   public ArrayList<InvoiceItem> cartItemToInvoiceItem(ArrayList<CartItem> cart, Invoice invoice){
       return invoiceItemDAO.cartItemToInvoiceItem(cart, invoice);
   }
   
   public void addInvoiceItem(InvoiceItem invoiceItem){
       invoiceItemDAO.addInvoiceItem(invoiceItem);
   }
}
