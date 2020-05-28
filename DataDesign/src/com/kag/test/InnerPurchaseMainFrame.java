package com.kag.test;

import com.kag.entity.PurchaseMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerPurchaseMainFrame extends JInternalFrame {

    public final JLabel Label_MedicineKinds = new JLabel("购药种类数");
    public final JLabel Label_Fid = new JLabel("厂家编号");
    public final JLabel Label_Remark = new JLabel("备注");
    public final JButton Button_Sure = new JButton("确定");
    public final JButton Button_Cancel = new JButton("取消");
    public final JTextField Text_MedicineKinds = new JTextField();
    public final JTextField Text_Fid = new JTextField();
    public final JTextField Text_Remark = new JTextField();
    public final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    public final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    public final Font Font_Button = new Font("微软雅黑", Font.BOLD, 15);
    public final ImageIcon BackIcon = new ImageIcon("img/PurchaseMainBack.png");
    public final ImageIcon LogoIcon = new ImageIcon("img/PurchaseLogo.png");
    public final JLabel BackLabel = new JLabel(BackIcon);
    public final JPanel ContentPanel = (JPanel) getContentPane();
    public final JLayeredPane LayeredPane = getLayeredPane();

    public InnerPurchaseMainFrame( ) {
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
        Label_MedicineKinds.setBounds(20, 30, 100, 20);
        Label_Fid.setBounds(20, 80, 100, 20);
        Label_Remark.setBounds(20, 130, 100, 20);

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
        Button_Sure.addActionListener(new PurchaseMainSureAction());
        Button_Cancel.addActionListener(new PurchaseDetailCancelAction());
    }

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
            for (int i = 0; i < fid.length(); i++) {
                if (!Character.isDigit(fid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "厂家编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int IntMedicineKinds = Integer.valueOf(medicineKinds);
            double transactionAmount = 0;
            int IntFid = Integer.valueOf(fid);

        }
    }

    class PurchaseDetailCancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Text_MedicineKinds.setText("");
            Text_Fid.setText("");
            Text_Remark.setText("");
            setVisible(false);
        }
    }

}
