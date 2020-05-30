package com.kag.gui;

import com.kag.entity.Factory;
import com.kag.entity.Medicine;
import com.kag.entity.Stock;
import com.kag.service.MedicineService;
import com.kag.service.StockService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

/**
 * @Description: 内部库存查询界面(根据ID)
 * @Author: 陈子康
 * @Date: 2020/5/26
 */
public class InnerSearchStockByIdFrame extends JInternalFrame{

    public final JTextField Text_Search = new JTextField();
    public final JTextArea Area_Result = new JTextArea();
    public final JButton Button_Search = new JButton();
    public final JButton Button_Return = new JButton();
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Area = new Font("华文楷体", Font.PLAIN, 18);

    private final ImageIcon BackIcon = new ImageIcon("img/SearchStockBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/SearchLogo.png");
    private final ImageIcon SearchIcon = new ImageIcon("img/SearchButton.png");
    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();


    public InnerSearchStockByIdFrame() {
        initInnerFrameBackground();
        initInnerFrameProperty();
        initInnerFrameComponent();
    }

    private void initInnerFrameBackground() {
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
    }

    private void initInnerFrameProperty() {
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(false);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("输入药品编号查询库存");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {

        add(Text_Search);
        Text_Search.setFont(Font_Text);
        Text_Search.setOpaque(false);
        Text_Search.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Search.setBounds(80 - 3, 30, 195, 30);
        Text_Search.addActionListener(new SearchAction());
        add(Area_Result);
        Area_Result.setFont(Font_Area);
        Area_Result.setOpaque(false);
        Area_Result.setEditable(false);
        Area_Result.setSelectedTextColor(Color.BLUE);
        Area_Result.setBounds(50 - 3, 80, 255, 200);

        add(Button_Search);
        add(Button_Return);
        Button_Search.setIcon(SearchIcon);
        Button_Return.setIcon(ReturnIcon);
        Button_Return.setBounds(50, 30, 30, 30);
        Button_Search.setBounds(275 - 3, 30, 30, 30);
        Button_Search.addActionListener(new SearchAction());

        JScrollPane Scroll_Result = new JScrollPane(Area_Result);
        Scroll_Result.setOpaque(false);
        Scroll_Result.getViewport().setOpaque(false);
        getContentPane().add(Scroll_Result);
        Scroll_Result.setBounds(50 - 3, 80, 255, 200);
        Scroll_Result.setViewportView(Area_Result);
        TitledBorder SearchBorder = new TitledBorder("Search");
        SearchBorder.setTitleFont(new Font("微软雅黑", Font.PLAIN, 10));
        Scroll_Result.setBorder(SearchBorder);

    }

    class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Area_Result.setText(null);
            String mid = Text_Search.getText();
            if (mid.length() < 8 || mid.length() > 10) {
                Area_Result.setText("药品编号应该在8~10位之间");
                return;
            }
            for (int i = 0; i < mid.length(); i++) {
                if (!Character.isDigit(mid.charAt(i))) {
                    Area_Result.setText("药品编号非法");
                    return;
                }
            }

            int IntMid = Integer.valueOf(mid);
            MedicineService medicineService = new MedicineService();
            Medicine medicine = medicineService.queryMedicineByIdService(IntMid);
            if (medicine == null) {
                Area_Result.setText("药品不存在");
                return;
            }
            StockService stockService = new StockService();
            Stock stock = stockService.queryStockByIdService(IntMid);
            StringBuffer result = new StringBuffer();
            result.append("————查询结果如下————" + "\r\n")
                    .append("▶药品编号：" + medicine.getMid() + "\r\n")
                    .append("▶药品名称：" + medicine.getMedicineName() + "\r\n")
                    .append("▶库存数量：" + stock.getStockQuantity() + "\r\n")
                    .append("▶备注：" + stock.getRemark());
            Area_Result.setText(result.toString());
        }
    }

}
