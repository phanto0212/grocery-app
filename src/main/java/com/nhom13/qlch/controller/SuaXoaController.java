
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Product;
import com.nhom13.qlch.model.TotalCongNo;
import com.nhom13.qlch.view.SuaSoLuongJFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class SuaXoaController {
    private JButton jlbDelete;


    public SuaXoaController(JButton jlbDelete) {
        this.jlbDelete = jlbDelete;

    }

   
    public void setEvent(int selectedindex, List <Product> list, DefaultTableModel table,JLabel jlbTongTien  , JLabel jlbCongNo, TotalCongNo ttcn  ){
        jlbDelete.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        Product sanpham = list.get(selectedindex);
        float trutien = sanpham.getPro_Prize()*sanpham.getPro_QIS();
        String totalString = jlbTongTien.getText();
        float totalfloat = Float.parseFloat(totalString);
        float result = totalfloat-trutien;
        float total = result;
        ttcn.setTotal(total);
        String tienno = jlbCongNo.getText();
        float tiennofloat = Float.parseFloat(tienno);
        float result2 = tiennofloat - trutien;
        ttcn.setCongno(result2);
        
        jlbTongTien.setText(String.valueOf(result));
        list.remove(selectedindex);
        table.removeRow(selectedindex);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jlbDelete);
        frame.dispose();
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
