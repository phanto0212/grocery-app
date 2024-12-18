
package com.nhom13.qlch.controller;

import com.nhom13.qlch.bean.DanhMucBean;
import com.nhom13.qlch.view.CongNoJPanel;
import com.nhom13.qlch.view.CustomerJPanel;
import com.nhom13.qlch.view.InvoiceJPanel;
import com.nhom13.qlch.view.LaiLoJPanel;
import com.nhom13.qlch.view.LoginJFrame;
import com.nhom13.qlch.view.MainJFrame;

import com.nhom13.qlch.view.ManagerJPanel1;
import com.nhom13.qlch.view.NhapHangJPanel;
import com.nhom13.qlch.view.ProductJPanel;
import com.nhom13.qlch.view.SettingAccountJPanel;
import com.nhom13.qlch.view.StaffJPanel;
import com.nhom13.qlch.view.THONGKEJPanel;
import com.nhom13.qlch.view.ThongKeDonHangJPanel;
import com.nhom13.qlch.view.TrangChuJPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChuyenManHinhController {
    
    private JPanel root;
    private JPanel frame;
    private JLabel jlbDangXuat;
    private String kindSelected = "";
    private List<DanhMucBean> listItem;
    

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public ChuyenManHinhController(JPanel root, JPanel frame, JLabel jlbDangXuat) {
        this.root = root;
        this.frame = frame;
        this.jlbDangXuat = jlbDangXuat;
    }

    


    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(72, 157, 242));
        jlbItem.setBackground(new Color(72, 157, 242));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
        
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
        
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;
        
        
        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                node = new TrangChuJPanel();
                    break;
                case "SanPham":
                node =new ProductJPanel("SanPham");
                    break;
                case "BanHang":
                    node = new ManagerJPanel1("BanHang");
                    break;
                case "NhanVien":
                    node = new StaffJPanel("NhanVien");
                    break;
                case "HoaDon":
                    node = new InvoiceJPanel("HoaDon");
                    break;
                case "khachHang":
                    node= new CustomerJPanel("KhachHang");
                    break;
                case "ThongKe":
                    node =  new THONGKEJPanel("ThongKe");
                    break;
                case "NhapHang" :
                    node = new NhapHangJPanel("NhapHang");
                    break;
                case "Sold":
                    node = new ThongKeDonHangJPanel("Sold");
                    break;
                case "LaiLo":
                    node = new LaiLoJPanel("LaiLO");
                    break;
                case "setting":
                    node = new SettingAccountJPanel();
                    break;
                case "CongNo":
                    node = new CongNoJPanel();
                default:
                    break;
               
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(72, 157, 242));
            jlbItem.setBackground(new Color(72, 157, 242));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground(new Color(71, 131, 191));
//            jlbItem.setBackground(new Color(71, 131, 191));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(25, 118, 211));
                jlbItem.setBackground(new Color(25, 118, 211));

            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(72, 157, 242));
                item.getJlb().setBackground(new Color(72, 157, 242));

            } else {
                item.getJpn().setBackground(new Color(25, 118, 211));
                item.getJlb().setBackground(new Color(25, 118, 211));

            }
        }
    }
    
}
