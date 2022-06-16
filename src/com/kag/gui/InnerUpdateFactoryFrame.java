package com.kag.gui;

import com.kag.common.CheckUtil;
import com.kag.entity.Factory;
import com.kag.service.FactoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @apiNote 内部修改厂家界面
 * @author KHighness
 * @since 2020/5/29
 */
public class InnerUpdateFactoryFrame extends JInternalFrame {

    private Factory factory;
    private FactoryService factoryService = new FactoryService();

    private final JLabel Label_FactoryName = new JLabel("名称");
    private final JLabel Label_FactoryAddress = new JLabel("地址");
    private final JLabel Label_PostCode = new JLabel("邮编");
    private final JLabel Label_TelephoneNumber = new JLabel("电话号码");
    private final JLabel Label_Remark = new JLabel("备注");

    private final JTextField Text_FactoryName = new JTextField();
    private final JTextField Text_FactoryAddress = new JTextField();
    private final JTextField Text_PostCode = new JTextField();
    private final JTextField Text_TelephoneNumber = new JTextField();
    private final JTextField Text_Remark = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("返回");

    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/UpdateFactoryBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/FactoryLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerUpdateFactoryFrame(Factory factory) {
        this.factory = factory;
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
        initFrameData();
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
        setTitle("修改厂家");
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initFrameComponent() {
        add(Label_FactoryName);
        add(Label_FactoryAddress);
        add(Label_PostCode);
        add(Label_TelephoneNumber);
        add(Label_Remark);
        Label_FactoryName.setFont(Font_Label);
        Label_FactoryAddress.setFont(Font_Label);
        Label_PostCode.setFont(Font_Label);
        Label_TelephoneNumber.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        int X_LABEL_FIRST = 30, Y_LABEL_FIRST = 40, Y_LABEL_DISTANCE = 43, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_FactoryName.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_FactoryAddress.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_PostCode.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_TelephoneNumber.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 4 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_FactoryName);
        add(Text_FactoryAddress);
        add(Text_PostCode);
        add(Text_TelephoneNumber);
        add(Text_Remark);
        Text_FactoryName.setFont(Font_Text);
        Text_FactoryAddress.setFont(Font_Text);
        Text_PostCode.setFont(Font_Text);
        Text_TelephoneNumber.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_FactoryName.setOpaque(false);
        Text_FactoryAddress.setOpaque(false);
        Text_PostCode.setOpaque(false);
        Text_TelephoneNumber.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_FactoryName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_FactoryAddress.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PostCode.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_TelephoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int X_TEXT_FIRST = 110, Y_TEXT_FIRST = 40, Y_TEXT_DISTANCE = 43, TEXT_WIDTH = 300, TEXT_HEIGHT = 30;
        Text_FactoryName.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST , TEXT_WIDTH, TEXT_HEIGHT);
        Text_FactoryAddress.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_PostCode.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_TelephoneNumber.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 4 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
        Button_Finish.setBounds(130, 260, 70, 30);
        Button_Return.setBounds(260, 260, 70, 30);
        Button_Finish.addActionListener(new AddFactoryFinishAction());
        Button_Return.addActionListener(new AddFactoryReturnAction());

    }

    private void initFrameData() {
        Text_FactoryName.setText(factory.getFactoryName());
        Text_FactoryAddress.setText(factory.getFactoryAddress());
        Text_PostCode.setText(factory.getPostCode());
        Text_TelephoneNumber.setText(factory.getTelephoneNumber());
        Text_Remark.setText(factory.getRemark());
    }

    class AddFactoryFinishAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String factoryName = Text_FactoryName.getText();
            String factoryAddress = Text_FactoryAddress.getText();
            String postCode = Text_PostCode.getText();
            String telephoneNumber = Text_TelephoneNumber.getText();
            String remark = Text_Remark.getText();

            if (postCode.length() != 6) {
                JOptionPane.showMessageDialog(null, "邮政编码不合法", "PostCode Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (telephoneNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "手机号码不能为空", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isPhoneNumberLegal(telephoneNumber)) {
                JOptionPane.showMessageDialog(null, "电话号码不合法（仅支持大陆手机号码）", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            factory.setFactoryName(factoryName);
            factory.setFactoryAddress(factoryAddress);
            factory.setPostCode(postCode);
            factory.setTelephoneNumber(telephoneNumber);
            factory.setRemark(remark);
            factoryService.updateFactoryService(factory.getFid(), factory);
            JOptionPane.showMessageDialog(null, "修改厂家成功", "Add factory Success", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    class AddFactoryReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
