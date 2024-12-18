
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.ManagerDAO;
import com.nhom13.qlch.dao.ManagerDAOimpl;
import com.nhom13.qlch.model.Product;
import java.util.List;

public class ManagerServiceimpl implements ManagerService {
       private ManagerDAO managerDAO = null;

    public ManagerServiceimpl() {
        this.managerDAO = new ManagerDAOimpl();
    }

    @Override
    public List<Product> getList() {
        return managerDAO.getList();
    }
}
