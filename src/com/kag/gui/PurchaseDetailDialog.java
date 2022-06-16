package com.kag.gui;

import com.kag.entity.PurchaseDetail;
import com.kag.service.PurchaseDetailService;
import com.kag.service.StockService;

import javax.swing.*;
import java.awt.*;

/**
 * @apiNote 进货对话框
 * @author KHighness
 * @since 2020/5/25
 */
public class PurchaseDetailDialog extends JDialog {

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

    public PurchaseDetailDialog(String purchaseId) {
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
        setBounds(800, 350, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setTitle("输入药品信息");
        setIconImage(LogoIcon.getImage());
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
    }
}
