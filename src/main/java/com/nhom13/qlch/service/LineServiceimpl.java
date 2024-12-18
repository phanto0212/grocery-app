
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.LineDAO;
import com.nhom13.qlch.dao.LineDAOimpl;
import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.Sold;
import com.nhom13.qlch.model.invoice;
import java.util.Date;
import java.util.List;


public class LineServiceimpl implements LineService {
    private LineDAO lineDAO = null;

    public LineServiceimpl() {
        this.lineDAO = new LineDAOimpl();
    }

    @Override
    public List<Line> getList() {
        return lineDAO.getList();
    }

  

    @Override
    public int Insert(Product product, String Ma_hoa_don, int i) {
        return lineDAO.Insert(product, Ma_hoa_don, i);
    }

    @Override
    public List<Sold> getLit(Date TimeStart, Date TimeEnd) {
        return lineDAO.getLit(TimeStart, TimeEnd);
    }
    
    
    
}
