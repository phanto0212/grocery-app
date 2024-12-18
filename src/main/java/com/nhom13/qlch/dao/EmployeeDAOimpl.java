
package com.nhom13.qlch.dao;

import com.nhom13.qlch.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EmployeeDAOimpl implements EmployeeDAO {
    @Override
    public List<Employee> getList(){
        try{
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM dbo.EMPLOYEE ";
        List<Employee> list =  new ArrayList<>();
        PreparedStatement ps = cons.prepareCall(sql);
//        ps.setString(1, "000001");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Employee nhanvien = new Employee();
            nhanvien.setma_nhan_vien(rs.getString("EMP_CODE"));
            nhanvien.setFist_name(rs.getString("EMP_FNAME"));
            nhanvien.setLast_name(rs.getString("EMP_LNAME"));
            nhanvien.setNgay_sinh(rs.getDate("EMP_DOB"));
            nhanvien.setNgay_vo_lam(rs.getDate("EMP_HIREDATE"));
            nhanvien.setCong_viec(rs.getString("EMP_JOBTITLE"));
            nhanvien.setSalary(rs.getFloat("EMP_SALARY"));
            nhanvien.setemail(rs.getString("EMP_EMAIL"));
            nhanvien.setphone(rs.getString("EMP_PHONENUM"));
            nhanvien.setadress(rs.getString("EMP_ADDRESS")); 
            
            list.add(nhanvien);
        }
        ps.close();
        rs.close();
        cons.close();
       
        return list;
    }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int insert(Employee employee) {
     int result = 0;
        try {
            Connection cons = DBConnect.getConnection();

            String sql = "INSERT INTO dbo.EMPLOYEE (EMP_CODE, EMP_FNAME, "
                    + "EMP_LNAME, EMP_DOB, EMP_HIREDATE,"
                    + " EMP_JOBTITLE, EMP_SALARY, EMP_EMAIL,EMP_PHONENUM,EMP_ADDRESS)\n"
                    + "VALUES (? ,? ,?, ? ,? ,? ,? ,?, ?, ? );";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, employee.getma_nhan_vien());
            ps.setString(2, employee.getFist_name());
            ps.setString(3, employee.getLast_name());
            ps.setDate(4, new java.sql.Date(employee.getNgay_sinh().getTime()));
            ps.setDate(5, new java.sql.Date(employee.getNgay_vo_lam().getTime()));
            ps.setString(6, employee.getCong_viec());
            ps.setFloat(7, employee.getSalary());
            ps.setString(8, employee.getemail());
            ps.setString(9, employee.getphone());
            ps.setString(10, employee.getadress());
            

            result = ps.executeUpdate();
             ps.close();
             cons.close();

            return result;
        } catch (Exception ex) {
            //System.out.println("loi");
            ex.printStackTrace();
        }
        return 0;

}
     @Override
    public int Update(Employee employee) {
     int result = 0;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "UPDATE dbo.EMPLOYEE\n"
                    + "SET \n"
                    + "    EMP_FNAME = ?, \n"
                    + "    EMP_LNAME = ?, \n"
                    + "    EMP_DOB = ?, \n"
                    + "    EMP_HIREDATE = ?, \n"
                    + "    EMP_JOBTITLE = ?, \n"
                    + "    EMP_SALARY = ?, \n"
                    + "    EMP_EMAIL = ?, \n"
                    + "    EMP_PHONENUM = ?,\n"
                    + "    EMP_ADDRESS = ?\n"
                    + "WHERE \n"
                    + "    EMP_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(10, employee.getma_nhan_vien());
            ps.setString(1, employee.getFist_name());
            ps.setString(2, employee.getLast_name());
            ps.setDate(3, new java.sql.Date(employee.getNgay_sinh().getTime()));
            ps.setDate(4, new java.sql.Date(employee.getNgay_vo_lam().getTime()));
            ps.setString(5, employee.getCong_viec());
            ps.setFloat(6, employee.getSalary());
            ps.setString(7, employee.getemail());
            ps.setString(8, employee.getphone());
            ps.setString(9, employee.getadress());

            result = ps.executeUpdate();
             ps.close();
             cons.close();

            return result;
        } catch (Exception ex) {
            //System.out.println("loi");
            ex.printStackTrace();
        }
        return 0;


    }
     @Override
    public int Delete(Employee employee) {
        int result = 0;
        try {
            Connection cons = DBConnect.getConnection();

            String sql = "DELETE FROM dbo.EMPLOYEE\n"
                    + "WHERE EMP_CODE = ?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, "" + employee.getma_nhan_vien());

            result = ps.executeUpdate();
            ps.close();
             cons.close();

            return result;
        } catch (Exception ex) {
            //System.out.println("loi");
            ex.printStackTrace();
        }
        return 0;
    }

}
   

