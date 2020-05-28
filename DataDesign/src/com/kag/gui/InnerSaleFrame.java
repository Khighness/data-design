package com.kag.gui;

import com.kag.common.OrderNumberGenerator;
import com.kag.dao.SaleDetailDao;
import com.kag.entity.Ledger;
import com.kag.entity.Medicine;
import com.kag.entity.SaleDetail;
import com.kag.entity.SaleMain;
import com.kag.service.*;

import javax.security.sasl.SaslServer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Description: 内部批发界面
 * @Author: 陈子康
 * @Date: 2020/5/25
 */
public class InnerSaleFrame {

    private int sid;
    private String saleId;
    private double transactionAmount = 0;
    public final JInternalFrame InnerSaleMainFrame = new JInternalFrame();
    private final JLabel Label_MedicineKinds = new JLabel("发药种类数");
    private final JLabel Label_Cid = new JLabel("客户编号");
    private final JLabel Label_Remark = new JLabel("备注");
    private final JButton Button_Sure = new JButton("确定");
    private final JButton Button_Finish = new JButton("完成");
    private final JTextField Text_MedicineKinds = new JTextField();
    private final JTextField Text_Cid = new JTextField();
    private final JTextField Text_Remark = new JTextField();
    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/SaleMainBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/SaleLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) InnerSaleMainFrame.getContentPane();
    private final JLayeredPane LayeredPane = InnerSaleMainFrame.getLayeredPane();

    public InnerSaleFrame(int sid) {
        this.sid = sid;
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
        InnerSaleMainFrame.setBounds(300, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        InnerSaleMainFrame.setVisible(true);
        InnerSaleMainFrame.setLayout(null);
        InnerSaleMainFrame.setClosable(true);
        InnerSaleMainFrame.setIconifiable(true);
        InnerSaleMainFrame.setTitle("批发");
        InnerSaleMainFrame.setFrameIcon(LogoIcon);
        InnerSaleMainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        InnerSaleMainFrame.add(Label_MedicineKinds);
        InnerSaleMainFrame.add(Label_Cid);
        InnerSaleMainFrame.add(Label_Remark);
        Label_MedicineKinds.setFont(Font_Label);
        Label_Cid.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        int X_LABEL_FIRST = 40, Y_LABEL_FIRST = 40, Y_LABEL_DISTANCE = 60, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Label_MedicineKinds.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Cid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        InnerSaleMainFrame.add(Text_MedicineKinds);
        InnerSaleMainFrame.add(Text_Cid);
        InnerSaleMainFrame.add(Text_Remark);
        Text_MedicineKinds.setFont(Font_Text);
        Text_Cid.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_Cid.setOpaque(false);
        Text_MedicineKinds.setOpaque(false);
        Text_Remark.setOpaque(false);
        int X_TEXT_FIRST = 150, Y_TEXT_FIRST = 40, Y_TEXT_DISTANCE = 60, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Text_MedicineKinds.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Cid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_MedicineKinds.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Cid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        InnerSaleMainFrame.add(Button_Sure);
        InnerSaleMainFrame.add(Button_Finish);
        Button_Sure.setOpaque(false);
        Button_Finish.setOpaque(false);
        Button_Sure.setFont(Font_Button);
        Button_Finish.setFont(Font_Button);
        Button_Sure.setBounds(130, 220, 70, 25);
        Button_Finish.setBounds(260, 220, 70, 25);
        Button_Sure.addActionListener(new SaleMainSureAction());
        Button_Finish.addActionListener(new SaleMainFinishAction());

    }

    /**
     * @Description: 批发(SaleMain)
     * 1) 添加批发主记录
     */
    class SaleMainSureAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String medicineKinds = Text_MedicineKinds.getText();
            String cid = Text_Cid.getText();
            String remark = Text_Remark.getText();

            if (medicineKinds.equals("")) {
                JOptionPane.showMessageDialog(null, "购药种类数不能为空", "Medicine kinds Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < medicineKinds.length(); i++) {
                if (!Character.isDigit(medicineKinds.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "购药种类数非法", "Medicine kinds Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (cid.equals("")) {
                JOptionPane.showMessageDialog(null, "客户编号不能为空", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cid.length() < 8 || cid.length() > 10) {
                JOptionPane.showMessageDialog(null, "客户编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < cid.length(); i++) {
                if (!Character.isDigit(cid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "客户编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntCid = Integer.valueOf(cid);
            int IntMedicineKinds = Integer.valueOf(medicineKinds);
            saleId = OrderNumberGenerator.getSaleOrderNumber(IntCid, sid);

            ClientService clientService = new ClientService();
            if (clientService.queryClientByIdService(IntCid) == null) {
                JOptionPane.showMessageDialog(null, "客户不存在", "Factory exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SaleMain saleMain = new SaleMain(saleId, IntMedicineKinds, transactionAmount, new Date(), IntCid, sid, remark);
            SaleMainService saleMainService = new SaleMainService();
            saleMainService.addSaleMainService(saleMain);

            for (int i = IntMedicineKinds; i >= 1; i--) {
                SaleDetailDialog saleDetailDialog = new SaleDetailDialog(saleId);
                saleDetailDialog.setTitle("输入第" + i + "种药品信息");
                saleDetailDialog.Button_Sure.addActionListener(new SaleDetailDialogAction(saleDetailDialog));
            }

        }
    }

    /**
     * @Description: 批发(saleMain)
     * 1) 更新交易金额
     * 2) 添加账本记录
     */
    class SaleMainFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SaleMainService saleMainService = new SaleMainService();
            saleMainService.updateSaleTransactionService(saleId, transactionAmount);

            Ledger ledger = new Ledger(saleId, 2, transactionAmount);
            LedgerService ledgerService = new LedgerService();
            ledgerService.addLedgerService(ledger);

            InnerSaleMainFrame.setVisible(false);
        }
    }

    /**
     * @Description: 批发(SaleDetail)
     * 1) 添加批发子记录
     * 2) 更新药品库存
     */
    class SaleDetailDialogAction implements ActionListener{

        SaleDetailDialog saleDetailDialog;

        public SaleDetailDialogAction(SaleDetailDialog saleDetailDialog) {
            this.saleDetailDialog = saleDetailDialog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String mid = saleDetailDialog.Text_Mid.getText();
            String saleQuantity = saleDetailDialog.Text_SaleQuantity.getText();
            String remark = saleDetailDialog.Text_Remark.getText();

            if (mid.length() < 8 || mid.length() > 10) {
                JOptionPane.showMessageDialog(null, "药品编号非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            for (int i = 0; i < mid.length(); i++) {
                if (!Character.isDigit(mid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "药品编号非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (saleQuantity.equals("")) {
                JOptionPane.showMessageDialog(null, "批发数量不能为空", "Purchase quantity Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < saleQuantity.length(); i++) {
                if (!Character.isDigit(saleQuantity.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "批发数量非法", "Medicine quantity Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntMid = Integer.valueOf(mid);
            int IntSaleQuantity = Integer.valueOf(saleQuantity);

            MedicineService medicineService = new MedicineService();
            StockService stockService = new StockService();
            if (medicineService.queryMedicineByIdService(IntMid) == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (stockService.queryStockQuantityByIdService(IntMid) < IntSaleQuantity) {
                JOptionPane.showMessageDialog(null, "药品库存数量不足", "Stock quantity Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salePrice = medicineService.queryMedicineSalePriceService(IntMid);
            transactionAmount += salePrice * IntSaleQuantity;

            SaleDetail saleDetail = new SaleDetail(saleId, IntMid, IntSaleQuantity, remark);
            SaleDetailService saleDetailService = new SaleDetailService();
            saleDetailService.addSaleDetailService(saleDetail);

            stockService.updateDecreaseStockService(IntMid, IntSaleQuantity);

            saleDetailDialog.setVisible(false);
        }
    }
}
