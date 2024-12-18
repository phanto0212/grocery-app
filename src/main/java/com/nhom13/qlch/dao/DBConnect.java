
package com.nhom13.qlch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    // Hàm getConnection() trả về một đối tượng Connection
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Chuỗi kết nối đến cơ sở dữ liệu SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Storeco";
            String username = "sa";
            String password = "12345";
            
            // Thiết lập kết nối
            connection = DriverManager.getConnection(url, username, password);
            
            // In ra thông báo nếu kết nối thành công
//            System.out.println("Kết nối đến cơ sở dữ liệu thành công.");
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi kết nối
            System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
            throw e;
        }
        return connection;
    }
}

