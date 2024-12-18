
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.ProductDAO;
import com.nhom13.qlch.dao.ProductDAOimpl;
import com.nhom13.qlch.model.Product;
import java.util.List;


public class ProductServiceimpl implements ProductService{
     private ProductDAO productDAO = null;

    public ProductServiceimpl() {
        this.productDAO = new ProductDAOimpl();
    }

    @Override
    public List<Product> getList() {
        return productDAO.getList();
    }

    

    @Override
    public int insert(Product product) {
       return productDAO.insert(product);
}
        @Override
    public int Update(Product product) {
       return productDAO.Update(product);
}
            @Override
    public int Delete(Product product) {
       return productDAO.Delete(product);
}

    @Override
    public int NhapHang(Product product) {
     return productDAO.NhapHang(product);
    }

    @Override
    public int BanHang(Product product) {
       return productDAO.BanHang(product);
    }
}
//    @Override
//    public int createOrUpdate(Product product) {
//        return ProductDAO.createOrUpdate(product);
//    }
//}
