
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.InvoiceDAO;
import com.nhom13.qlch.dao.InvoiceDAOimpl;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.invoice;
import java.util.List;

public class InvoiceServiceimpl implements InvoiceService{
       private InvoiceDAO invoiceDAO = null;

    public InvoiceServiceimpl() {
        this.invoiceDAO = new InvoiceDAOimpl();
    }

    @Override
    public List<invoice> getList() {
        return invoiceDAO.getList();
    }

    @Override
    public String Insert( String makhachhang, String phuongthuc, float total_invoice) {
    return invoiceDAO.Insert( makhachhang, phuongthuc, total_invoice);
    }

    @Override
    public List<invoice> getListToday() {
       return invoiceDAO.getListToday();
    }
    
}
