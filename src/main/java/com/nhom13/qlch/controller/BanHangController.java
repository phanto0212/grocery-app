
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Line;
import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.service.LineService;
import com.nhom13.qlch.service.LineServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelBanHang;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class BanHangController {
    private JPanel jpanelViewHoadon;
    private JButton SubmitHoaDon;
    private JLabel jlbMa_khach_hang;
    private JLabel jlbMa_hoa_don;
    private JLabel jlbTotal;
    private LineService lineService= null;
    private  String[] listcolumn  = {"STT" , "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền",
        };
 private TableRowSorter<TableModel> rowSorter = null;
 private ClassTableModelBanHang classTableModelBanHang = null;
    public BanHangController(JPanel jpanelViewHoadon, JButton SubmitHoaDon) {
        this.jpanelViewHoadon = jpanelViewHoadon;
        this.SubmitHoaDon = SubmitHoaDon;
        this.lineService = new LineServiceimpl(); 
    }

    public BanHangController(JPanel jpanelViewHoadon, JButton SubmitHoaDon, JLabel jlbMa_khach_hang, JLabel jlbMa_hoa_don, JLabel jlbTotal) {
        this.jpanelViewHoadon = jpanelViewHoadon;
        this.SubmitHoaDon = SubmitHoaDon;
        this.jlbMa_khach_hang = jlbMa_khach_hang;
        this.jlbMa_hoa_don = jlbMa_hoa_don;
        this.jlbTotal = jlbTotal;
        this.lineService = new LineServiceimpl();
    }

    public void SetDataToTable(List<Product> list, String MaKhachHang , String MaHoaDon, String TotalTien){
        DefaultTableModel model = new ClassTableModelBanHang().setTableProduct(list, listcolumn );
        JTable table = new JTable(model);

         rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jlbMa_khach_hang.setText(MaKhachHang);
        jlbMa_hoa_don.setText(MaHoaDon);
        jlbTotal.setText(TotalTien);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpanelViewHoadon.removeAll();
        jpanelViewHoadon.setLayout(new CardLayout());
        jpanelViewHoadon.add(scroll);
        jpanelViewHoadon.validate();
        jpanelViewHoadon.repaint();
       
        } 
    public void setEvent(){
    SubmitHoaDon.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubmitHoaDon);
            frame.dispose();

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
});
}}
