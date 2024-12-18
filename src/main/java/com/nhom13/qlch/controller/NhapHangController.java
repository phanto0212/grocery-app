
package com.nhom13.qlch.controller;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class NhapHangController {
    private JButton btnNhap_hang;
    private JTextField jtfMa_san_pham;
    private JTextField jtfSo_luong;
    private JTextField jtfGia;
    private JDateChooser jdcNgay_san_xuat;
    private JDateChooser jdcNgay_het_han;
    private JLabel jlbReact;
    private ProductService productService =null;

   

    public NhapHangController(JButton btnNhap_hang, JTextField jtfMa_san_pham, JTextField jtfSo_luong, JTextField jtfGia, JDateChooser jdcNgay_san_xuat, JDateChooser jdcNgay_het_han, JLabel jlbReact) {
        this.btnNhap_hang = btnNhap_hang;
        this.jtfMa_san_pham = jtfMa_san_pham;
        this.jtfSo_luong = jtfSo_luong;
        this.jtfGia = jtfGia;
        this.jdcNgay_san_xuat = jdcNgay_san_xuat;
        this.jdcNgay_het_han = jdcNgay_het_han;
        this.jlbReact = jlbReact;
        this.productService = new ProductServiceimpl();
    }



  
    public void setEvent(){
         btnNhap_hang.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jtfMa_san_pham.getText().isEmpty()  
                || jtfGia.getText().equals("0.0") || jtfSo_luong.getText().equals("0") || jdcNgay_san_xuat.getDate() == null ||jdcNgay_het_han.getDate() == null) {
                jlbReact.setText("VUI LÒNG NHẬP DỮ LIỆU BẮT BUỘC ");
                return; // Kết thúc phương thức nếu dữ liệu không hợp lệ
            }

            Product product = new Product();
            product.setProduct_code(jtfMa_san_pham.getText());


            if (StringUtils.isNumeric(jtfGia.getText()) || StringUtils.isNumeric(jtfGia.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfGia.getText());
                product.setPro_Import_Prize (floatValue);
            } else {
                jlbReact.setText("GIÁ KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
             
            if (StringUtils.isNumeric(jtfSo_luong.getText())) {
                int soLuong = Integer.parseInt(jtfSo_luong.getText());
                product.setPro_QIS(soLuong);
            } else {
                jlbReact.setText("SỐ LƯỢNG KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
            product.setPro_MD(jdcNgay_san_xuat.getDate());
            product.setPro_EXD(jdcNgay_het_han.getDate());

            int lastid = productService.NhapHang(product);
            if (lastid > 0) {
                jlbReact.setText("Nhập Thành Công");
            } else {
                jlbReact.setText("Có lỗi xảy ra, vui lòng thử lại");
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });

    }
    
    
}
