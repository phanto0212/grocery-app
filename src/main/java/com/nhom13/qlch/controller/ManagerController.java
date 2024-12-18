
package com.nhom13.qlch.controller;


import com.nhom13.qlch.dao.AccountDAO;
import com.nhom13.qlch.dao.AccountDAOimpl;
import com.nhom13.qlch.model.Account;
import com.nhom13.qlch.model.Customer;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.TotalCongNo;
import com.nhom13.qlch.service.CustomerService;
import com.nhom13.qlch.service.CustomerServiceimpl;
import com.nhom13.qlch.service.InvoiceService;
import com.nhom13.qlch.service.InvoiceServiceimpl;
import com.nhom13.qlch.service.LineService;
import com.nhom13.qlch.service.LineServiceimpl;
import com.nhom13.qlch.service.ManagerService;
import com.nhom13.qlch.service.ManagerServiceimpl;
import com.nhom13.qlch.service.ProductService;
import com.nhom13.qlch.service.ProductServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelJpanelView1;
import com.nhom13.qlch.unity.ClassTableModelJpanelView2;
import com.nhom13.qlch.view.BanHangJFrame;
import com.nhom13.qlch.view.CustomerJFrame;
import com.nhom13.qlch.view.DeleteProductCartJFrame;
import com.nhom13.qlch.view.LoginJFrame;
import com.nhom13.qlch.view.MainJFrame;
import com.nhom13.qlch.view.SuaSoLuongJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ManagerController {
    private int i=0,j=0;
    private float total=0,GiamGia,tienkhachtra,tongtienfloat,congno,temp;
    private float floatValue = 0.0f;
    private JPanel jpanelView1;
    private JPanel jpanelView2;
    private JTextField SearchManager;
    private JTextField jtfKhach_hang;
    private JComboBox jcbPhuong_Thuc;
    private JLabel jtfTong_Tien;
    private JButton btnThanh_Toan;
    private JButton btnHuy_Ban;
    private JButton btnIn;
    private JTextField jtfKhachTra;
    private JLabel jlbCongNo;
    private ClassTableModelJpanelView1 classTableModelJpanelView1 = null;
   

    private  String[] listcolumn  = {"STT", "MÃ SẢN PHẨM", "MÃ PHÂN LOẠI", "MÃ NHÀ CUNG CẤP",
        "MÔ TẢ", "NHÃN HÀNG", "GIÁ"};
    private String[] columnTitles = {"stt", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM","SỐ LƯỢNG","GIÁ/1"}; 
    private String[] selectPhuong_thuc  = {"CHUYEN KHOAN", "TIỀN MẶT", "CREDIT CARD"}; 
    private ProductService productService = null;
    private ManagerService managerService=null;
    private InvoiceService  invoiceService = null;
    private LineService lineService = null;
    private CustomerService customerService =null;
    private AccountDAO accountDAO = null;
    private TotalCongNo ttcn = new TotalCongNo();

    private TableRowSorter<TableModel> rowSorter = null;
    private TableRowSorter<TableModel> rowSorter1 = null;

    public ManagerController(JPanel jpanelView1, JPanel jpanelView2, JTextField SearchManager, JTextField jtfKhach_hang, JComboBox jcbPhuong_Thuc, JLabel jtfTong_Tien, JButton btnThanh_Toan, JButton btnHuy_Ban, JButton btnIn) {
        this.jpanelView1 = jpanelView1;
        this.jpanelView2 = jpanelView2;
        this.SearchManager = SearchManager;
        this.jtfKhach_hang = jtfKhach_hang;
        this.jcbPhuong_Thuc = jcbPhuong_Thuc;
        this.jtfTong_Tien = jtfTong_Tien;
        this.btnThanh_Toan = btnThanh_Toan;
        this.btnHuy_Ban = btnHuy_Ban;
        this.btnIn = btnIn;
        this.productService = new ProductServiceimpl();
        this.managerService=new ManagerServiceimpl();
        this.invoiceService = new InvoiceServiceimpl();
        this.lineService = new LineServiceimpl();
        this.customerService = new CustomerServiceimpl();
        this.accountDAO = new AccountDAOimpl();
    }

    public ManagerController(float GiamGia, JPanel jpanelView1, JPanel jpanelView2, JTextField SearchManager, JTextField jtfKhach_hang, JComboBox jcbPhuong_Thuc, JLabel jtfTong_Tien, JButton btnThanh_Toan, JButton btnHuy_Ban, JButton btnIn, JTextField jtfKhachTra, JLabel jlbCongNo) {
        this.GiamGia = GiamGia;
        this.jpanelView1 = jpanelView1;
        this.jpanelView2 = jpanelView2;
        this.SearchManager = SearchManager;
        this.jtfKhach_hang = jtfKhach_hang;
        this.jcbPhuong_Thuc = jcbPhuong_Thuc;
        this.jtfTong_Tien = jtfTong_Tien;
        this.btnThanh_Toan = btnThanh_Toan;
        this.btnHuy_Ban = btnHuy_Ban;
        this.btnIn = btnIn;
        this.jtfKhachTra = jtfKhachTra;
        this.jlbCongNo = jlbCongNo;
        this.productService = new ProductServiceimpl();
        this.managerService=new ManagerServiceimpl();
        this.invoiceService = new InvoiceServiceimpl();
        this.lineService = new LineServiceimpl();
        this.customerService = new CustomerServiceimpl();
        this.accountDAO = new AccountDAOimpl();
    }

    public ManagerController(JPanel jpanelView1, JPanel jpanelView2, JTextField SearchManager, JTextField jtfKhach_hang, JComboBox jcbPhuong_Thuc, JLabel jtfTong_Tien, JButton btnThanh_Toan, JButton btnHuy_Ban, JButton btnIn, JTextField jtfKhachTra, JLabel jlbCongNo) {
        this.jpanelView1 = jpanelView1;
        this.jpanelView2 = jpanelView2;
        this.SearchManager = SearchManager;
        this.jtfKhach_hang = jtfKhach_hang;
        this.jcbPhuong_Thuc = jcbPhuong_Thuc;
        this.jtfTong_Tien = jtfTong_Tien;
        this.btnThanh_Toan = btnThanh_Toan;
        this.btnHuy_Ban = btnHuy_Ban;
        this.btnIn = btnIn;
        this.jtfKhachTra = jtfKhachTra;
        this.jlbCongNo = jlbCongNo;
        this.productService = new ProductServiceimpl();
        this.managerService=new ManagerServiceimpl();
        this.invoiceService = new InvoiceServiceimpl();
        this.lineService = new LineServiceimpl();
        this.customerService = new CustomerServiceimpl();
        this.accountDAO = new AccountDAOimpl();
    }

 

   

    public void setDataToTable() {
        List<Product> listItem = productService.getList();
        List<Product> list  = managerService.getList();
        
//        Product sanpham = listItem.get(1 );
//        System.out.println(sanpham.getPro_Brand());
        DefaultTableModel model = new ClassTableModelJpanelView1().setTableProduct2(listItem, listcolumn );
        DefaultTableModel model1 = new DefaultTableModel();
         model1.setColumnIdentifiers(columnTitles);
        JTable table = new JTable(model);
        JTable table1 = new JTable(model1);
        
         rowSorter = new TableRowSorter<>(table.getModel());
         rowSorter1 = new TableRowSorter<>(table1.getModel());
         for (String hoang:selectPhuong_thuc){
             jcbPhuong_Thuc.addItem(hoang);
         }
//         DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
//
//        // Định dạng số float thành chuỗi với dấu phân cách hàng nghìn và hàng triệu
//        String formattedNumber = decimalFormat.format(number);
        table.setRowSorter(rowSorter);
        table1.setRowSorter(rowSorter1);
        SearchManager.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = SearchManager.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = SearchManager.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

         
         table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1 && table.getSelectedRow() != -1 ) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int selectedRowIndex = table.getSelectedRow();
            
            // Chuyển đổi chỉ số hàng hiển thị thành chỉ số hàng trong mô hình
            selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
            
            Product product = new Product();
            product.setProduct_code(model.getValueAt(selectedRowIndex, 1).toString());
            product.setPro_Description(model.getValueAt(selectedRowIndex, 2).toString());
            product.setPro_Brand(model.getValueAt(selectedRowIndex, 3).toString());
            product.setPro_Prize((float) model.getValueAt(selectedRowIndex, 4));
//            product.setPro_QIS((int) model.getValueAt(selectedRowIndex, 5));
            int temp= (int) model.getValueAt(selectedRowIndex, 5);
            product.setPro_Dimensions(model.getValueAt(selectedRowIndex, 6).toString());
             Object[] obj = new Object[2000]; // Tạo một mảng mới cho mỗi hàng
             if (list.isEmpty()  )
             {
                 if ( temp > 0){
                     
                 
            obj[0] =++i;
            obj[1] = product.getProduct_code();
            obj[2] = product.getPro_Description();
            obj[3] = 1;
            product.setPro_QIS(1);
            obj[4] = product.getPro_Prize();
            list.add(product);
            model1.addRow(obj);
                 } else{
                JOptionPane.showMessageDialog(null, "Sản Phẩm Hiện Hết Hàng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
             else{
                 boolean t = true;
                for (int k=0;k<list.size();k++){
                    Product   prod=list.get(k);
                    if (prod.getProduct_code() == product.getProduct_code()  ){
                        
                    int currentScore = (int) model1.getValueAt(k, 3);
                    
                    if(currentScore < temp){
                                             // Tăng giá trị lên 1
                    int newScore = currentScore + 1;
                    prod.setPro_QIS(newScore);
                     // Sửa giá trị của ô ở hàng 2, cột 3 (index 1, 2)
                    model1.setValueAt(newScore, k, 3);
                    t=false;
                    }
                    else {
                     JOptionPane.showMessageDialog(null, "Vượt Quá Số Lượng Cho Phép", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                      t= false;
                    }
                    
                }
                  
                
            
            } 
                if(t){
                    if (temp>0){
            obj[0] =++i;
            obj[1] = product.getProduct_code();
            obj[2] = product.getPro_Description();
            obj[3] = 1;
            product.setPro_QIS(1);
            obj[4] = product.getPro_Prize();
            list.add(product);
            model1.addRow(obj);}
                    else{
                       JOptionPane.showMessageDialog(null, "Sản Phẩm Trong Kho không Đủ Đáp Ứng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
             }
             }total=0;
             ttcn.setTotal(0);
            for (Product prods : list){
                total+=prods.getPro_Prize()*prods.getPro_QIS();
//                System.out.print( product.getPro_QIS()+" \n");
            }
            ttcn.setTotal(total);
            String Result = String.format("%.2f", ttcn.getTotal());
            
            jtfTong_Tien.setText(Result);
            
            
//            jlbCongNo.setText(String.valueOf(congno));
           
        }
    }
});
       table1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            // Xử lý sự kiện click chuột phải
            DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
            int selectedRowIndex1 = table1.getSelectedRow();
            // Chuyển đổi chỉ số hàng hiển thị thành chỉ số hàng trong mô hình
            selectedRowIndex1 = table1.convertRowIndexToModel(selectedRowIndex1);
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            DeleteProductCartJFrame frame3 = new DeleteProductCartJFrame(selectedRowIndex1, list, model1, jtfTong_Tien , jlbCongNo, ttcn);
            frame3.setLocation(x, y);
            frame3.setResizable(false);
            frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame3.setTitle("Thông tin sản phẩm");
            frame3.setVisible(true);
        } else if (e.getClickCount() == 3 && table1.getSelectedRow() != -1) {
            // Xử lý sự kiện double click chuột trái
            int selectedRowIndex = table1.getSelectedRow();
            selectedRowIndex = table1.convertRowIndexToModel(selectedRowIndex);
            SuaSoLuongJFrame JframeSoluong = new SuaSoLuongJFrame();
            JframeSoluong.setLocationRelativeTo(null);
            JframeSoluong.setResizable(false);
            JframeSoluong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JframeSoluong.setTitle("Thông tin sản phẩm");
            JframeSoluong.setVisible(true);
        
        }
    }
});


          btnThanh_Toan.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        
       if (list.size()==0){
            JOptionPane.showMessageDialog(null, "Chưa có sản phẩm để thanh toán", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
       }
       else{
             String congnoString = jlbCongNo.getText();
           float congnoFloat = Float.parseFloat(congnoString);
           if (jtfKhach_hang.getText().isEmpty() && congnoFloat > 0 ){
               JOptionPane.showMessageDialog(null, "khách mới không cho nợ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
               return;
           }
           String MaKhachHang = jtfKhach_hang.getText();
           List<Customer> listkhach = customerService.getList();
           boolean c = true;
           for (Customer khachhang:listkhach){
               if (khachhang.getMa_khach_hang().equals(MaKhachHang)){
                   c=false;
           }}
           if (c ){
               if(showDialogtaokhach()){
                 CustomerJFrame JFRame = new CustomerJFrame(new Customer());
            JFRame.setLocationRelativeTo(null);
            JFRame.setResizable(false);
            JFRame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JFRame.setTitle("Thông tin sản phẩm");
            JFRame.setVisible(true); 
            return;   
               }
               else{
                   return;
               }
             
           }
           
           
         
            while (model1.getRowCount() > 0) {
            model1.removeRow(0);
        }
            for (Product sanpham : list){
                productService.BanHang(sanpham);
            }
        String TienNoString =jlbCongNo.getText();
        String phuongthuc = jcbPhuong_Thuc.getSelectedItem().toString();
        String tongTienText = jtfTong_Tien.getText();
        if (tongTienText.isEmpty()) {
            jtfTong_Tien.setText("0.0");
            return; // Không làm gì nếu giá trị tổng tiền rỗng
        }
        float totalTongHoaDon;
        try {
            totalTongHoaDon = Float.parseFloat(tongTienText);
        } catch (NumberFormatException ex) {
            ex.printStackTrace(); // Xử lý ngoại lệ nếu giá trị không phải số
            return; // Dừng việc thực hiện nếu có lỗi xảy ra
        }
        
        String MaHoaDon = invoiceService.Insert(MaKhachHang, phuongthuc, totalTongHoaDon);
//        System.out.println(list.size());
        int tongsodonhang=0;
        for (int i = 0; i < list.size(); i++) {
            Product sanpham = list.get(i);
            tongsodonhang+=sanpham.getPro_QIS();
            int ok = lineService.Insert(sanpham, MaHoaDon, i + 1);
        }
        float TienNoFloat = Float.parseFloat(TienNoString);
        
        if(!MaKhachHang.isEmpty()){
            customerService.muaHang(total, MaKhachHang);
            customerService.setRank();
            customerService.CongNo(MaKhachHang,TienNoFloat );
        }
        List<Account> account = accountDAO.getTaiKhoan();
        accountDAO.ThemTaiKhoanThongKe(account.get(0).getTen_dang_nhap(), tongsodonhang, totalTongHoaDon);
//        customerService.muaHang(total, MaKhachHang);
        DecimalFormat decimalFormat = new DecimalFormat("###,###.000");
        String formated = decimalFormat.format(totalTongHoaDon);
        BanHangJFrame frame = new BanHangJFrame(list, MaKhachHang, MaHoaDon, formated);
        jtfKhachTra.setText("");
        jtfTong_Tien.setText("0.0");
        jtfKhach_hang.setText("");
        jlbCongNo.setText("");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Thông tin sản phẩm");
        frame.setVisible(true);
        list.clear();
        ttcn.setTotal(0);
        ttcn.setCongno(0);
        
        
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
});
          btnHuy_Ban.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        while (model1.getRowCount() > 0) {
            model1.removeRow(0);
        }
        list.clear();
        congno=0;
          
        ttcn.setCongno(0);
        ttcn.setTotal(0);
        jtfKhach_hang.setText("");
        jtfTong_Tien.setText("0");
        jlbCongNo.setText("0");
        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
             

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
});
           btnIn.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
   
        JOptionPane.showMessageDialog(null, "In thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
});

//         design

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

       

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(600, 400));
        jpanelView1.removeAll();
        jpanelView1.setLayout(new CardLayout());
        jpanelView1.add(scroll);
        jpanelView1.validate();
        jpanelView1.repaint();
     


    
     
    
    
    
        table1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table1.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table1.setRowHeight(50);
        table1.validate();
        table1.repaint();
    
       

        JScrollPane scroll1 = new JScrollPane();
        scroll1.getViewport().add(table1);
        scroll1.setPreferredSize(new Dimension(500, 600));
        jpanelView2.removeAll();
        jpanelView2.setLayout(new CardLayout());
        jpanelView2.add(scroll1);
        jpanelView2.validate();
        jpanelView2.repaint();

    }
public void setEvent(){
    jtfKhachTra.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        

            if (!jtfKhachTra.getText().isEmpty()) {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                String khachtra = jtfKhachTra.getText();
                tienkhachtra = Float.parseFloat(khachtra);
                total = Float.valueOf(ttcn.getTotal());
                congno = total - tienkhachtra;
           ttcn.setCongno(congno);
                jlbCongNo.setText(decimalFormat.format(ttcn.getCongno()));
                if (jtfKhachTra.getText().length() == 1){
                    temp = Float.valueOf(jtfKhachTra.getText());
                }
            }
            
              
            
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (!jtfKhachTra.getText().isEmpty()) {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
                String khachtra = jtfKhachTra.getText();
                tienkhachtra = Float.parseFloat(khachtra);
                congno = total - tienkhachtra;
                ttcn.setCongno(congno);
                jlbCongNo.setText(decimalFormat.format(ttcn.getCongno()));
                if (jtfKhachTra.getText().length() == 1){
                    temp = Float.valueOf(jtfKhachTra.getText());
                }
            }
        else{
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
           jlbCongNo.setText(decimalFormat.format(ttcn.getCongno()+temp)); 
        }
           
//                jlbCongNo.setText(String.valueOf(total));   
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
//        jlbCongNo.setText(String.valueOf(total));  
    }
});
   
    jtfTong_Tien.addPropertyChangeListener(new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
//            tienkhachtra = Float.parseFloat(jtfKhachTra.getText());
           if(!jtfKhachTra.getText().isEmpty()){
               tienkhachtra = Float.parseFloat(jtfKhachTra.getText());
           }
           else{
               tienkhachtra=0;
           }
             congno = ttcn.getTotal() -tienkhachtra;
             ttcn.setCongno(congno);
            if ("text".equals(evt.getPropertyName())) {
                jlbCongNo.setText(decimalFormat.format(ttcn.getCongno()));
            }
        }
    });


    
}



     
 public boolean showDialogquasoluong() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Sản phẩm trong kho không đủ!!", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
 public boolean showDialogtaokhach() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Khach chua ton tai ban co muon them khach??", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
}
             

