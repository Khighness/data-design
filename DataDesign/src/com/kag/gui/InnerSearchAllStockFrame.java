package com.kag.gui;

import com.kag.entity.Stock;
import com.kag.service.StockService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.peer.FontPeer;
import java.util.List;

/**
 * @Description: 内部库存查询界面(查询所有)
 * @Author: 陈子康
 * @Date: 2020/5/26
 */
public class InnerSearchAllStockFrame extends JInternalFrame {

    public InnerSearchAllStockFrame() {
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setTitle("查询所有药品库存");
        setBounds(700, 100, 300, 200);
        setFrameIcon(new ImageIcon("img/StockLogo.png"));

        StockService stockService = new StockService();
        List<Stock> stockList = stockService.queryStockService();
        Object[] columnTitle = {"药品编号", "库存数量"};
        Object[][] tableData = new Object[stockList.size()][2];
        for (int i = 0; i < stockList.size(); i++) {
            tableData[i][0] = stockList.get(i).getMid();
            tableData[i][1] = stockList.get(i).getStockQuantity();
        }

        Font font = new Font("华文楷体", Font.PLAIN, 18);
        JTable table = new JTable(tableData, columnTitle);
        table.setFont(font);
        table.setEnabled(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        setTableHeaderColor(table, 0, new Color(200, 200, 169));
        setTableHeaderColor(table, 1, new Color(200, 200, 169));
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        DefaultTableCellRenderer ter = new DefaultTableCellRenderer()// 设置表格间隔色
        {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                if (row % 2 == 0)
                    setBackground(Color.WHITE);
                else if (row % 2 == 1)
                    setBackground(new Color(174, 221, 129));
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        ter.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, ter);

    }

    public static void setTableHeaderColor(JTable table, int columnIndex, Color c) {
        TableColumn column = table.getTableHeader().getColumnModel().getColumn(columnIndex);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            /** serialVersionUID */
            private static final long serialVersionUID = 43279841267L;
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
                setHorizontalAlignment(JLabel.CENTER);// 表格内容居中
                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                        .setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// 列头内容居中

                return super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
            }
        };
        cellRenderer.setBackground(c);
        column.setHeaderRenderer(cellRenderer);
    }
}
