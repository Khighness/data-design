package com.kag.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerPurchaseFrame extends JInternalFrame {

    private final JLabel Label_MedicineKinds = new JLabel("进购药品数");
    private final JLabel Label_Fid = new JLabel("厂家编号");
    private final JLabel Label_Remark = new JLabel("备注");
    public final JButton Button_Sure = new JButton("确定");
    public final JButton Button_Cancel = new JButton("取消");
    public JTextField Text_MedicineKinds = new JTextField();
    public JTextField Text_Fid = new JTextField();
    public JTextField Text_Remark = new JTextField();
    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 15);
    private final ImageIcon BackIcon = new ImageIcon("img/PurchaseBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/PurchaseLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerPurchaseFrame( ) {
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
        setBounds(300, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("进货");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Label_MedicineKinds);
        add(Label_Fid);
        add(Label_Remark);
        Label_MedicineKinds.setFont(Font_Label);
        Label_Fid.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        Label_MedicineKinds.setBounds(10, 30, 100, 20);
        Label_Fid.setBounds(28, 80, 82, 20);
        Label_Remark.setBounds(55, 130, 55, 20);

        add(Text_MedicineKinds);
        add(Text_Fid);
        add(Text_Remark);
        Text_MedicineKinds.setOpaque(false);
        Text_Fid.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_MedicineKinds.setFont(Font_Text);
        Text_Fid.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_MedicineKinds.setBounds(120, 25, 220, 30);
        Text_Fid.setBounds(120, 75, 220, 30);
        Text_Remark.setBounds(120, 125, 220, 30);
        Text_MedicineKinds.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Fid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        add(Button_Sure);
        add(Button_Cancel);
        Button_Sure.setOpaque(false);
        Button_Cancel.setOpaque(false);
        Button_Sure.setFont(Font_Button);
        Button_Cancel.setFont(Font_Button);
        Button_Sure.setBounds(100, 180, 70, 25);
        Button_Cancel.setBounds(220, 180, 70, 25);
        Button_Sure.addActionListener(new SureAction());
        Button_Cancel.addActionListener(new CancelAction());
    }

    class SureAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new InnerPurchaseFrame();
        }
    }

    class CancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Text_MedicineKinds.setText("");
            Text_Fid.setText("");
            Text_Remark.setText("");
            setVisible(false);
        }
    }

}
