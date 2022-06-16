package com.kag.gui;

import com.kag.entity.Ledger;
import com.kag.entity.Stock;
import com.kag.service.LedgerService;
import com.kag.service.StockService;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

/**
 * @apiNote 内部账本查询界面
 * @author KHighness
 * @since 2020/5/30
 */
public class InnerLedgerFrame extends JInternalFrame {

    public InnerLedgerFrame() {
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("账本记录");
        setBounds(300, 100, 600, 300);
        setFrameIcon(new ImageIcon("img/LedgerLogo.png"));

        LedgerService ledgerService = new LedgerService();
        List<Ledger> ledgerList = ledgerService.queryLedgerService();
        Object[] columnTitle = {"流水号", "类型", "交易金额/元"};
        Object[][] tableData = new Object[ledgerList.size()][3];
        for (int i = 0; i < ledgerList.size(); i++) {
            tableData[i][0] = ledgerList.get(i).getRecordId();
            switch (ledgerList.get(i).getType()) {
                case 1: tableData[i][1] = "进货"; break;
                case 2: tableData[i][1] = "批发"; break;
                case 3: tableData[i][1] = "零售"; break;
                default: break;
            }
           tableData[i][2] = ledgerList.get(i).getTransactionAmount();
        }

        Font Font_Head = new Font("微软雅黑", Font.BOLD, 18);
        Font Font_Table = new Font("华文楷体", Font.PLAIN, 20);
        JTable table = new JTable(tableData, columnTitle);
        table.getTableHeader().setFont(Font_Head);
        table.setFont(Font_Table);
        table.setEnabled(false);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalTextPosition(JLabel.CENTER);
        DefaultTableCellRenderer ter = new DefaultTableCellRenderer();
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
