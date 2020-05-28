package com.kag.gui;

import com.kag.common.OrderNumberGenerator;
import com.kag.entity.Ledger;
import com.kag.entity.Retail;
import com.kag.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Description: 内部零售界面
 * @Author: 陈子康
 * @Date: 2020/5/25
 */
public class InnerRetailFrame extends JInternalFrame {

    private int sid;
    private String retailId;
    private double transactionAmount;
    private Date retailDate;
    private final JLabel Label_Cid = new JLabel("客户编号");
    private final JLabel Label_Mid = new JLabel("药品编号");
    private final JLabel Label_RetailQuantity = new JLabel("购买数量");
    private final JLabel Label_Remark = new JLabel("备注");

    private final JTextField Text_Cid = new JTextField();
    private final JTextField Text_Mid = new JTextField();
    private final JTextField Text_RetailQuantity = new JTextField();
    private final JTextField Text_Remark = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("取消");

    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/RetailBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/RetailLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerRetailFrame(int sid) {
        this.sid = sid;
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    private void initFrameBackground() {
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
    }

    private void initFrameProperty() {
        setBounds(300, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setTitle("新增客户");
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initFrameComponent() {
        add(Label_Cid);
        add(Label_Mid);
        add(Label_RetailQuantity);
        add(Label_Remark);
        Label_Cid.setFont(Font_Label);
        Label_Mid.setFont(Font_Label);
        Label_RetailQuantity.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        int X_LABEL_FIRST = 40, Y_LABEL_FIRST = 40, Y_LABEL_DISTANCE = 50, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_Cid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Mid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_RetailQuantity.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_Cid);
        add(Text_Mid);
        add(Text_RetailQuantity);
        add(Text_Remark);
        Text_Cid.setFont(Font_Text);
        Text_Mid.setFont(Font_Text);
        Text_RetailQuantity.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_Cid.setOpaque(false);
        Text_Mid.setOpaque(false);
        Text_RetailQuantity.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_Cid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Mid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_RetailQuantity.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int X_TEXT_FIRST = 150, Y_TEXT_FIRST = 40, Y_TEXT_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Text_Cid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Mid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_RetailQuantity.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
        Button_Finish.setBounds(130, 260, 70, 30);
        Button_Return.setBounds(260, 260, 70, 30);
        Button_Finish.addActionListener(new RetailFinishAction());
        Button_Return.addActionListener(new RetailReturnAction());

    }

    /**
     * @Description: 零售(Retail)
     * 1) 添加零售记录
     * 2) 添加账本记录
     * 3) 更新药品库存
     */
    class RetailFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cid = Text_Cid.getText();
            String mid = Text_Mid.getText();
            String retailQuantity = Text_RetailQuantity.getText();
            String remark = Text_Remark.getText();

            if (cid.equals("")) {
                JOptionPane.showMessageDialog(null, "厂家编号不能为空", "Client id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cid.length() < 8 || cid.length() > 10) {
                JOptionPane.showMessageDialog(null, "厂家编号应该在8~10位之间", "Client id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (mid.length() < 8 || mid.length() > 10) {
                JOptionPane.showMessageDialog(null, "药品编号应该在8~10位之间", "Medicine id Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            for (int i = 0; i < mid.length(); i++) {
                if (!Character.isDigit(mid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "药品编号非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            for (int i = 0; i < retailQuantity.length(); i++) {
                if (!Character.isDigit(retailQuantity.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "销售数量非法", "Retail quantity Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntCid = Integer.valueOf(cid);
            int IntMid = Integer.valueOf(mid);
            int IntRetailQuantity = Integer.valueOf(retailQuantity);
            ClientService clientService = new ClientService();
            MedicineService medicineService = new MedicineService();
            StockService stockService = new StockService();
            RetailService retailService = new RetailService();
            LedgerService ledgerService = new LedgerService();

            if (clientService.queryClientByIdService(IntCid) == null) {
                JOptionPane.showMessageDialog(null, "客户不存在", "Client Exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (medicineService.queryMedicineByIdService(IntMid) == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine Exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (stockService.queryStockQuantityByIdService(IntMid) < IntRetailQuantity) {
                JOptionPane.showMessageDialog(null, "药品库存数量不足不存在", "Stock Quantity Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            retailId = OrderNumberGenerator.getRetailOrderNumber(IntCid, sid);
            double retailPrice = medicineService.queryMedicineRetailPriceService(IntMid);
            transactionAmount = retailPrice * IntRetailQuantity;

            Retail retail = new Retail(retailId, IntMid, IntRetailQuantity, transactionAmount, new Date(), IntCid, sid, remark);
            retailService.addRetailService(retail);

            Ledger ledger = new Ledger(retailId, 3, transactionAmount);
            ledgerService.addLedgerService(ledger);

            stockService.updateDecreaseStockService(IntMid, IntRetailQuantity);
            setVisible(false);

        }
    }

    class RetailReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }


}
