package com.kag.test;

import com.kag.entity.PurchaseDetail;
import com.kag.service.PurchaseDetailService;
import com.kag.service.StockService;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerPurchaseDetailFrame extends JInternalFrame {

    public String purchaseId;
    public final JLabel Label_Mid = new JLabel("药品编号");
    public final JLabel Label_PurchasePrice = new JLabel("进货价格");
    public final JLabel Label_PurchaseQuantity = new JLabel("进货数量");
    public final JLabel Label_Remark = new JLabel("备注");

    public final JTextField Text_Mid = new JTextField();
    public final JTextField Text_PurchasePrice = new JTextField();
    public final JTextField Text_PurchaseQuantity = new JTextField();
    public final JTextField Text_Remark = new JTextField();

    public final JButton Button_Sure = new JButton("确定");
    public final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    public final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    public final Font Font_Button = new Font("微软雅黑", Font.BOLD, 15);
    public final ImageIcon BackIcon = new ImageIcon("img/PurchaseDetailBack.png");
    public final ImageIcon LogoIcon = new ImageIcon("img/MedicineLogo.png");
    public final JLabel BackLabel = new JLabel(BackIcon);
    public final JPanel ContentPanel = (JPanel) getContentPane();
    public final JLayeredPane LayeredPane = getLayeredPane();

    public InnerPurchaseDetailFrame(String purchaseId) {
        this.purchaseId = purchaseId;
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
        setBounds(700, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(false);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("输入药品信息");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Label_Mid);
        add(Label_PurchasePrice);
        add(Label_PurchaseQuantity);
        add(Label_Remark);
        Label_Mid.setFont(Font_Label);
        Label_PurchasePrice.setFont(Font_Label);
        Label_PurchaseQuantity.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        Label_Mid.setOpaque(false);
        Label_PurchasePrice.setOpaque(false);
        Label_PurchaseQuantity.setOpaque(false);
        Label_Remark.setOpaque(false);
        int X_LABEL_FIRST = 20, Y_LABEL_FIRST = 20, Y_LABEL_DISTANCE = 48, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_Mid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_PurchasePrice.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_PurchaseQuantity.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_Mid);
        add(Text_PurchasePrice);
        add(Text_PurchaseQuantity);
        add(Text_Remark);
        Text_Mid.setFont(Font_Text);
        Text_PurchasePrice.setFont(Font_Text);
        Text_PurchaseQuantity.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_Mid.setOpaque(false);
        Text_PurchasePrice.setOpaque(false);
        Text_PurchaseQuantity.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_Mid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PurchasePrice.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PurchaseQuantity.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int X_TEXT_FIRST = 110, Y_TEXT_FIRST = 20, Y_TEXT_DISTANCE = 48, TEXT_WIDTH = 220, TEXT_HEIGHT = 30;
        Text_Mid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_PurchasePrice.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_PurchaseQuantity.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Sure);
        Button_Sure.setFont(Font_Button);
        Button_Sure.setBounds(150, 210, 70, 25);
        Button_Sure.addActionListener(new PurchaseDetailSureAction());
    }

    /**
     * @Desciption：药品进货
     *  1) 添加PurchaseDetail记录
     *  2) 改变库存Stock库存记录
     */
    class PurchaseDetailSureAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           String mid = Text_Mid.getText();
           String purchasePrice = Text_PurchasePrice.getText();
           String purchaseQuantity = Text_PurchaseQuantity.getText();
           String remark = Text_Remark.getText();

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
                if (!Character.isDigit(mid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "进货数量非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntMid = Integer.valueOf(mid);
            double DoublePurchasePrice = Double.valueOf(purchasePrice);
            int IntPurchaseQuantity = Integer.valueOf(purchaseQuantity);

            PurchaseDetail purchaseDetail = new PurchaseDetail(purchaseId, IntMid, DoublePurchasePrice, IntPurchaseQuantity, remark);

            PurchaseDetailService purchaseDetailService = new PurchaseDetailService();
            purchaseDetailService.addPurchaseDetailService(purchaseDetail);

            StockService stockService = new StockService();
            stockService.updateDecreaseStockService(IntMid, IntPurchaseQuantity);

        }
    }




}
