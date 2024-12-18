
package com.nhom13.qlch.controller;

import com.nhom13.qlch.model.Sold;
import com.nhom13.qlch.service.LineService;
import com.nhom13.qlch.service.LineServiceimpl;
import com.nhom13.qlch.unity.ClassTableModelSold;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class SoldController {
   private  JDateChooser jdcTimeStart;
   private  JDateChooser jdcTimeEnd;
   private JButton btnSearchList;
   private JLabel jlbReact;
   private JPanel jpnView;
   private LineService lineService = null;
    private  String[] listcolumn  = {"STT", "MÃ SẢN PHẨM", "SỐ LƯỢNG ĐÃ BÁN"
        };
    private TableRowSorter<TableModel> rowSorter = null;

    public SoldController(JDateChooser jdcTimeStart, JDateChooser jdcTimeEnd, JButton btnSearchList, JLabel jlbReact, JPanel jpnView) {
        this.jdcTimeStart = jdcTimeStart;
        this.jdcTimeEnd = jdcTimeEnd;
        this.btnSearchList = btnSearchList;
        this.jlbReact = jlbReact;
        this.jpnView = jpnView;
        this.lineService = new LineServiceimpl();
    }
  public Date[] setEvent() {
    Date[] selectedDates = new Date[2]; // Mảng chứa TimeStart và TimeEnd
    
    btnSearchList.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (jdcTimeStart.getDate() != null && jdcTimeEnd.getDate() != null) {
                selectedDates[0] = jdcTimeStart.getDate();
                selectedDates[1] = jdcTimeEnd.getDate();
                LocalDate startDate = selectedDates[0].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate endDate = selectedDates[1].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                List<Sold> listItem = lineService.getLit(selectedDates[0], selectedDates[1]);
                DefaultTableModel model = new ClassTableModelSold().setTableSold(listItem, listcolumn);
                JTable table = new JTable(model);
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);
                table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
                table.getTableHeader().setPreferredSize(new Dimension(100, 50));
                table.setRowHeight(50);
                table.validate();
                table.repaint();

                JScrollPane scroll = new JScrollPane();
                scroll.getViewport().add(table);
                scroll.setPreferredSize(new Dimension(1350, 400));
                jpnView.removeAll();
                jpnView.setLayout(new CardLayout());
                jpnView.add(scroll);
                jpnView.validate();
                jpnView.repaint();
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                  String dateStringStart = startDate.format(formatter);
                  String dateStringEnd = endDate.format(formatter);
                jlbReact.setText("Danh sách sản phẩm đã bán từ ngày "+dateStringStart+" đến ngày "+dateStringEnd+" là:");
            } else {
                jlbReact.setText("Hãy chọn cả ngày bắt đầu và kết thúc để tìm kiếm.");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    });

    return selectedDates;
}

   
}
