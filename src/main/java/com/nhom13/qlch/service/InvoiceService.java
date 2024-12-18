
package com.nhom13.qlch.service;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.invoice;
import java.util.List;


public interface InvoiceService {
        public List<invoice> getList();
        public String Insert ( String makhachhang, String phuongthuc, float total_invoice);
        public List<invoice> getListToday();
        
}
