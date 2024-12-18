
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Product;
import java.util.List;


public interface  ProductDAO {
    public List<Product> getList();
    public int insert (Product product);
    public int Update(Product product);
    public int Delete(Product product);
    public int NhapHang(Product product);
    public int BanHang(Product product);
}
