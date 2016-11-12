package service;

import dao.VoucherDAO;
import entity.Voucher;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class VoucherService {
    
    @Autowired
    VoucherDAO voucherDAO;
    
    public ArrayList<Voucher> getAllVoucher() {
        return voucherDAO.getAllVoucher();
    }
    
    public int getVoucherValue(String code){
        return voucherDAO.getVoucherValue(code);
    }
    
    public void deleteVoucher(String code){
        voucherDAO.deleteVoucher(code);
    }
    
    public void addVoucher(Voucher voucher){
        voucherDAO.addVoucher(voucher);
    }
    
    public String createCode(){
        return voucherDAO.createCode();
    }
}
