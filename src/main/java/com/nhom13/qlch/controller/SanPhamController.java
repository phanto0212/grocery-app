
package com.nhom13.qlch.controller;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SanPhamController {
    private JButton btnLUUprod;
    private JTextField jtfma_san_pham;
    private JTextField jtfma_phan_loai;
    private JTextField jtfma_nha_cung_cap;
    private JTextField jtfname_product;
    private JTextField jtfBrand_product;
    private JTextField jtfprice_product;
    private JTextField jtfprice_import_product;
    private JTextField jtfweight;
    private JTextField jtfsoluong;
    private JDateChooser jdED;
    private JDateChooser jdEXD;
    private JLabel jlbreact;
    private JButton btnUpdateprod;
    private JButton btnDleteprod;
    Product product = null;
    private ProductService productService =null;

    public SanPhamController(JButton btnLUUprod, JTextField jtfma_san_pham, JTextField jtfma_phan_loai, JTextField jtfma_nha_cung_cap, JTextField jtfname_product, JTextField jtfBrand_product, JTextField jtfprice_product, JTextField jtfprice_import_product, JTextField jtfweight, JTextField jtfsoluong, JDateChooser jdED, JDateChooser jdEXD, JLabel jlbreact, JButton btnUpdateprod, JButton btnDleteprod) {
        this.btnLUUprod = btnLUUprod;
        this.jtfma_san_pham = jtfma_san_pham;
        this.jtfma_phan_loai = jtfma_phan_loai;
        this.jtfma_nha_cung_cap = jtfma_nha_cung_cap;
        this.jtfname_product = jtfname_product;
        this.jtfBrand_product = jtfBrand_product;
        this.jtfprice_product = jtfprice_product;
        this.jtfprice_import_product = jtfprice_import_product;
        this.jtfweight = jtfweight;
        this.jtfsoluong = jtfsoluong;
        this.jdED = jdED;
        this.jdEXD = jdEXD;
        this.jlbreact = jlbreact;
        this.btnUpdateprod = btnUpdateprod;
        this.btnDleteprod = btnDleteprod;
        this.productService = new ProductServiceimpl();
    }

   
    public void setView(Product product){
        this.product = product;
        jtfma_san_pham.setText(product.getProduct_code());
        jtfma_phan_loai.setText(product.getCategory_code());
        jtfma_nha_cung_cap.setText(product.getSupplier_code());
        jtfname_product.setText(product.getPro_Description());
        jtfBrand_product.setText(product.getPro_Brand());
        String priceText = String.valueOf(product.getPro_Prize());
        jtfprice_product.setText(priceText);
        String price_ip_Text =String.valueOf(product.getPro_Import_Prize());
        jtfprice_import_product.setText(price_ip_Text);
        String soluongText = String.valueOf(product.getPro_QIS());
        jtfweight.setText(product.getPro_Dimensions());
        jtfsoluong.setText(soluongText);

        
    }
   public void setEvent() {
    btnLUUprod.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jtfma_san_pham.getText().isEmpty() || jtfname_product.getText().isEmpty() || jtfBrand_product.getText().isEmpty()
                || jtfprice_product.getText().equals("0.0") || jtfprice_import_product.getText().equals("0.0")|| jtfsoluong.getText().equals("0") || jtfweight.getText().isEmpty() || jdED.getDate() == null) {
                jlbreact.setText("VUI LÒNG NHẬP DỮ LIỆU BẮT BUỘC ");
                return; // Kết thúc phương thức nếu dữ liệu không hợp lệ
            }

            Product product = new Product();
            product.setProduct_code(jtfma_san_pham.getText());
            product.setCategory_code(jtfma_phan_loai.getText());
            product.setSupplier_code(jtfma_nha_cung_cap.getText());
            product.setPro_Description(jtfname_product.getText());
            product.setPro_Brand(jtfBrand_product.getText());

            if (StringUtils.isNumeric(jtfprice_product.getText()) || StringUtils.isNumeric(jtfprice_product.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfprice_product.getText());
                product.setPro_Prize(floatValue);
            } else {
                jlbreact.setText("GIÁ KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
             if (StringUtils.isNumeric(jtfprice_import_product.getText()) || StringUtils.isNumeric(jtfprice_import_product.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfprice_import_product.getText());
                product.setPro_Import_Prize(floatValue);
            } else {
                jlbreact.setText("GIÁ KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
            if (StringUtils.isNumeric(jtfsoluong.getText())) {
                int soLuong = Integer.parseInt(jtfsoluong.getText());
                product.setPro_QIS(soLuong);
            } else {
                jlbreact.setText("SỐ LƯỢNG KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }

            product.setPro_Dimensions(jtfweight.getText());
            product.setPro_MD(jdED.getDate());
            product.setPro_EXD(jdEXD.getDate());

            int lastid = productService.insert(product);
            if (lastid > 0) {
                jlbreact.setText("Thêm sản phẩm thành công");
                 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnLUUprod);
                        frame.dispose();
            } else {
                jlbreact.setText("Có lỗi xảy ra, vui lòng thử lại");
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });

    btnUpdateprod.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jtfma_san_pham.getText().isEmpty() || jtfname_product.getText().isEmpty() || jtfBrand_product.getText().isEmpty()
                || jtfprice_product.getText().equals("0.0")|| jtfprice_import_product.getText().equals("0.0") || jtfsoluong.getText().equals("0") || jtfweight.getText().isEmpty() || jdED.getDate() == null) {
                jlbreact.setText("VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN");
                return;
            }

            Product product = new Product();
            product.setProduct_code(jtfma_san_pham.getText());
            product.setCategory_code(jtfma_phan_loai.getText());
            product.setSupplier_code(jtfma_nha_cung_cap.getText());
            product.setPro_Description(jtfname_product.getText());
            product.setPro_Brand(jtfBrand_product.getText());

            if (StringUtils.isNumeric(jtfprice_product.getText()) || StringUtils.isNumeric(jtfprice_product.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfprice_product.getText());
                product.setPro_Prize(floatValue);
            } else {
                jlbreact.setText("GIÁ KHÔNG HỢP LỆ");
                return;
            }
            if (StringUtils.isNumeric(jtfprice_import_product.getText()) || StringUtils.isNumeric(jtfprice_import_product.getText().replace(".", ""))) {
                float floatValue = Float.parseFloat(jtfprice_import_product.getText());
                product.setPro_Import_Prize(floatValue);
            } else {
                jlbreact.setText("GIÁ KHÔNG HỢP LỆ");
                return; // Ngăn chặn việc tiếp tục thực hiện thêm sản phẩm nếu dữ liệu không hợp lệ
            }
            if (StringUtils.isNumeric(jtfsoluong.getText())) {
                int soLuong = Integer.parseInt(jtfsoluong.getText());
                product.setPro_QIS(soLuong);
            } else {
                jlbreact.setText("SỐ LƯỢNG KHÔNG HỢP LỆ");
                return;
            }

            product.setPro_Dimensions(jtfweight.getText());
            product.setPro_MD(jdED.getDate());
            product.setPro_EXD(jdEXD.getDate());

            int result = productService.Update(product);
            if (result > 0) {
                jlbreact.setText("Cập nhật sản phẩm thành công");
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnUpdateprod);
                        frame.dispose();
            } else {
                jlbreact.setText("Có lỗi xảy ra, vui lòng thử lại");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });
    btnDleteprod.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jtfma_san_pham.getText().isEmpty() 
              ) {
                jlbreact.setText("NHẬP MÃ ĐỂ XÓA SẢN PHẨM");
                return;
            }

            Product product = new Product();
            product.setProduct_code(jtfma_san_pham.getText());
            

            int result = productService.Delete(product);
            if (result > 0) {
                jlbreact.setText("XÓA THÀNH CÔNG!");
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnDleteprod);
                        frame.dispose();
            } else {
                jlbreact.setText("Có lỗi xảy ra, vui lòng thử lại");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });
    
}}


