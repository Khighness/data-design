package com.kag.gui;

import com.kag.common.OrderNumberGenerator;
import com.kag.entity.Ledger;
import com.kag.entity.Medicine;
import com.kag.entity.PurchaseDetail;
import com.kag.entity.PurchaseMain;
import com.kag.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @apiNote 内部进货界面
 * @author KHighness
 * @since 2020/5/25
 */
public class InnerPurchaseFrame {

    private int sid;
    private String purchaseId;
    private double transactionAmount = 0;
    public final JInternalFrame InnerPurchaseMainFrame = new JInternalFrame();
    private final JLabel Label_MedicineKinds = new JLabel("购药种类数");
    private final JLabel Label_Fid = new JLabel("厂家编号");
    private final JLabel Label_Remark = new JLabel("备注");
    private final JButton Button_Sure = new JButton("确定");
    private final JButton Button_Finish = new JButton("完成");
    private final JTextField Text_MedicineKinds = new JTextField();
    private final JTextField Text_Fid = new JTextField();
    private final JTextField Text_Remark = new JTextField();
    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/PurchaseMainBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/PurchaseLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) InnerPurchaseMainFrame.getContentPane();
    private final JLayeredPane LayeredPane = InnerPurchaseMainFrame.getLayeredPane();

    public InnerPurchaseFrame(int sid) {
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
        InnerPurchaseMainFrame.setBounds(300, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        InnerPurchaseMainFrame.setVisible(true);
        InnerPurchaseMainFrame.setLayout(null);
        InnerPurchaseMainFrame.setClosable(true);
        InnerPurchaseMainFrame.setIconifiable(true);
        InnerPurchaseMainFrame.setTitle("进货");
        InnerPurchaseMainFrame.setFrameIcon(LogoIcon);
        InnerPurchaseMainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        InnerPurchaseMainFrame.add(Label_MedicineKinds);
        InnerPurchaseMainFrame.add(Label_Fid);
        InnerPurchaseMainFrame.add(Label_Remark);
        Label_MedicineKinds.setFont(Font_Label);
        Label_Fid.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        int X_LABEL_FIRST = 40, Y_LABEL_FIRST = 40, Y_LABEL_DISTANCE = 60, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Label_MedicineKinds.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Fid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        InnerPurchaseMainFrame.add(Text_MedicineKinds);
        InnerPurchaseMainFrame.add(Text_Fid);
        InnerPurchaseMainFrame.add(Text_Remark);
        Text_MedicineKinds.setOpaque(false);
        Text_Fid.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_MedicineKinds.setFont(Font_Text);
        Text_Fid.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        int X_TEXT_FIRST = 150, Y_TEXT_FIRST = 40, Y_TEXT_DISTANCE = 60, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Text_MedicineKinds.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Fid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_MedicineKinds.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Fid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        InnerPurchaseMainFrame.add(Button_Sure);
        InnerPurchaseMainFrame.add(Button_Finish);
        Button_Sure.setOpaque(false);
        Button_Finish.setOpaque(false);
        Button_Sure.setFont(Font_Button);
        Button_Finish.setFont(Font_Button);
        Button_Sure.setBounds(130, 220, 70, 25);
        Button_Finish.setBounds(260, 220, 70, 25);
        Button_Sure.addActionListener(new PurchaseMainSureAction());
        Button_Finish.addActionListener(new PurchaseMainFinishAction());
    }

    /**
     * @Description：进货(PurchaseMain)
     * 1) 添加进货主记录
     */
    class PurchaseMainSureAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String medicineKinds = Text_MedicineKinds.getText();
            String fid = Text_Fid.getText();
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
            if (fid.equals("")) {
                JOptionPane.showMessageDialog(null, "厂家编号不能为空", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (fid.length() < 8 || fid.length() > 10) {
                    JOptionPane.showMessageDialog(null, "厂家编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            for (int i = 0; i < fid.length(); i++) {
                if (!Character.isDigit(fid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "厂家编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntFid = Integer.valueOf(fid);
            int IntMedicineKinds = Integer.valueOf(medicineKinds);
            purchaseId = OrderNumberGenerator.getPurchaseOrderNumber(IntFid, sid);

            FactoryService factoryService = new FactoryService();
            if (factoryService.queryFactoryByIdService(IntFid) == null) {
                JOptionPane.showMessageDialog(null, "厂家不存在", "Factory exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PurchaseMain purchaseMain = new PurchaseMain(purchaseId, IntMedicineKinds, transactionAmount, new Date(), IntFid, sid, remark);
            PurchaseMainService purchaseMainService = new PurchaseMainService();
            purchaseMainService.addPurchaseMainService(purchaseMain);

            for (int i = IntMedicineKinds; i >= 1; i--) {
                PurchaseDetailDialog purchaseDetailDialog = new PurchaseDetailDialog(purchaseId);
                purchaseDetailDialog.setTitle("输入第" + i + "种药品信息");
                purchaseDetailDialog.Button_Sure.addActionListener(new PurchaseDetailDialogAction(purchaseDetailDialog));
            }

        }
    }

    /**
     * @Description：进货(PurchaseMain)
     * 1) 更新交易金额
     * 2) 添加账本记录
     */
    class PurchaseMainFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PurchaseMainService purchaseMainService = new PurchaseMainService();
            purchaseMainService.updatePurchaseTransactionService(purchaseId, transactionAmount);

            Ledger ledger = new Ledger(purchaseId, 1, transactionAmount);
            LedgerService ledgerService = new LedgerService();
            ledgerService.addLedgerService(ledger);

            InnerPurchaseMainFrame.setVisible(false);
        }
    }

    /**
     * @apiNote 进货(PurchaseDetail)
     * 1) 添加进货子记录
     * 2）更新药品库存
     */
    class PurchaseDetailDialogAction implements ActionListener {

        PurchaseDetailDialog purchaseDetailDialog;

        public PurchaseDetailDialogAction(PurchaseDetailDialog purchaseDetailDialog) {
            this.purchaseDetailDialog = purchaseDetailDialog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String mid = purchaseDetailDialog.Text_Mid.getText();
            String purchasePrice = purchaseDetailDialog.Text_PurchasePrice.getText();
            String purchaseQuantity = purchaseDetailDialog.Text_PurchaseQuantity.getText();
            String remark = purchaseDetailDialog.Text_Remark.getText();

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
            if (purchasePrice.equals("")) {
                JOptionPane.showMessageDialog(null, "进货价格不能为空", "Purchase price Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < purchasePrice.length(); i++) {
                if ((!(Character.isDigit(purchasePrice.charAt(i))) && !(".".equals(String.valueOf(purchasePrice.charAt(i)))))){
                    JOptionPane.showMessageDialog(null, "进货价格非法", "Credibility Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (purchaseQuantity.equals("")) {
                JOptionPane.showMessageDialog(null, "进货数量不能为空", "Purchase quantity Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < purchaseQuantity.length(); i++) {
                if (!Character.isDigit(purchaseQuantity.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "进货数量非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntMid = Integer.valueOf(mid);
            double DoublePurchasePrice = Double.valueOf(purchasePrice);
            int IntPurchaseQuantity = Integer.valueOf(purchaseQuantity);

            transactionAmount += DoublePurchasePrice * IntPurchaseQuantity;

            MedicineService medicineService = new MedicineService();
            if (medicineService.queryMedicineByIdService(IntMid) == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PurchaseDetail purchaseDetail = new PurchaseDetail(purchaseId, IntMid, DoublePurchasePrice, IntPurchaseQuantity, remark);
            PurchaseDetailService purchaseDetailService = new PurchaseDetailService();
            purchaseDetailService.addPurchaseDetailService(purchaseDetail);

            StockService stockService = new StockService();
            stockService.updateIncreaseStockService(IntMid, IntPurchaseQuantity);

            purchaseDetailDialog.setVisible(false);
        }
    }
}
