
package com.nhom13.qlch.service;

import com.nhom13.qlch.dao.EmployeeDAO;
import com.nhom13.qlch.dao.EmployeeDAOimpl;
import com.nhom13.qlch.model.Employee;
import java.util.List;


public class EmployeeServiceimpl implements EmployeeService{
     private EmployeeDAO employeeDAO = null;

    public EmployeeServiceimpl() {
        this.employeeDAO = new EmployeeDAOimpl();
    }

    @Override
    public List<Employee> getList() {
        return employeeDAO.getList();
    }
        @Override
    public int insert(Employee employee) {
       return employeeDAO.insert(employee);
}
    @Override
    public int Update(Employee employee) {
       return employeeDAO.Update(employee);
}
       @Override
    public int Delete(Employee employee) {
       return employeeDAO.Delete(employee);
}
}