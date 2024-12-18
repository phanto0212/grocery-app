
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Employee;
import java.util.List;


public interface EmployeeDAO {
     public List<Employee> getList();
     public int insert (Employee employee);
    public int Update(Employee employee);
    public int Delete(Employee employee);
}
