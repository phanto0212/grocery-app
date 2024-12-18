
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.Sold;
import com.nhom13.qlch.model.invoice;
import java.util.Date;
import java.util.List;


public interface LineDAO {
        public List<Line> getList();
        public int Insert (Product product, String Ma_hoa_don, int i);
        public List<Sold> getLit(Date TimeStart, Date TimeEnd);
}
