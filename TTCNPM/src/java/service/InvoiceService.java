package service;

import dao.InvoiceDAO;
import entity.Invoice;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceService {
    @Autowired
    InvoiceDAO invoiceDAO;
    
    @Autowired
    InvoiceItemService invoiceItemService;
    
    public ArrayList<Invoice> getAllInvoice(int page){
        return invoiceDAO.getAllInvoice(page);
    }
    
    public ArrayList<Invoice> getAllInvoiceByUserName(int page, String userName){
        return invoiceDAO.getAllInvoiceByUserName(page, userName);
    }
    
    public Invoice getInvoiceByID(int invoiceID){
        return invoiceDAO.getInvoiceByID(invoiceID);
    }
    
    public void deleteInvoice(Invoice invoice){
        invoiceDAO.deleteInvoice(invoice);
    }
    
    public void insertInvoice(Invoice invoice){
        invoiceDAO.insertInvoice(invoice);
    }
    
    public void updateInvoice(Invoice invoice){
        invoiceDAO.updateInvoice(invoice);
    }
    
    public String createCode(){
        return invoiceDAO.createCode();
    }
}
