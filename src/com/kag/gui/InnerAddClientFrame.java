package com.kag.gui;

import com.kag.common.CheckUtil;
import com.kag.entity.Client;
import com.kag.service.ClientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

/**
 * @Description: 内部添加客户界面
 * @Author: 陈子康
 * @Date: 2020/5/25
 */
public class InnerAddClientFrame extends JInternalFrame {

    private final JLabel Label_Cid = new JLabel("编号");
    private final JLabel Label_ClientName = new JLabel("姓名");
    private final JLabel Label_ClientAddress = new JLabel("地址");
    private final JLabel Label_PhoneNumber = new JLabel("电话号码");
    private final JLabel Label_BanKCard = new JLabel("银行卡号");
    private final JLabel Label_Credibility = new JLabel("信用度");
    private final JLabel Label_Remark = new JLabel("备注");

    private final JTextField Text_Cid = new JTextField();
    private final JTextField Text_ClientName = new JTextField();
    private final JTextField Text_ClientAddress = new JTextField();
    private final JTextField Text_PhoneNumber = new JTextField();
    private final JTextField Text_BankCard = new JTextField();
    private final JTextField Text_Credibility = new JTextField();
    private final JTextField Text_Remark = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("返回");

    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/ClientBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/ClientLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();


    public InnerAddClientFrame() {
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
        add(Label_ClientName);
        add(Label_ClientAddress);
        add(Label_PhoneNumber);
        add(Label_BanKCard);
        add(Label_Credibility);
        add(Label_Remark);
        Label_Cid.setFont(Font_Label);
        Label_ClientName.setFont(Font_Label);
        Label_ClientAddress.setFont(Font_Label);
        Label_PhoneNumber.setFont(Font_Label);
        Label_BanKCard.setFont(Font_Label);
        Label_Credibility.setFont(Font_Label);
        Label_Remark.setFont(Font_Label);
        int X_LABEL_FIRST = 30, Y_LABEL_FIRST = 25, Y_LABEL_DISTANCE = 45, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_Cid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_ClientName.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_ClientAddress.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_PhoneNumber.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_BanKCard.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 4 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Credibility.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 5 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Remark.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 6 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_Cid);
        add(Text_ClientName);
        add(Text_ClientAddress);
        add(Text_PhoneNumber);
        add(Text_BankCard);
        add(Text_Credibility);
        add(Text_Remark);
        Text_Cid.setFont(Font_Text);
        Text_ClientName.setFont(Font_Text);
        Text_ClientAddress.setFont(Font_Text);
        Text_PhoneNumber.setFont(Font_Text);
        Text_BankCard.setFont(Font_Text);
        Text_Credibility.setFont(Font_Text);
        Text_Remark.setFont(Font_Text);
        Text_Cid.setOpaque(false);
        Text_ClientName.setOpaque(false);
        Text_ClientAddress.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_BankCard.setOpaque(false);
        Text_Credibility.setOpaque(false);
        Text_Remark.setOpaque(false);
        Text_Cid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_ClientName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_ClientAddress.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_BankCard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Credibility.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Remark.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int X_TEXT_FIRST = 110, Y_TEXT_FIRST = 25, Y_TEXT_DISTANCE = 40, TEXT_WIDTH = 300, TEXT_HEIGHT = 30;
        Text_Cid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_ClientName.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_ClientAddress.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_PhoneNumber.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_BankCard.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 4 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Credibility.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 5 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Remark.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 6 * Y_LABEL_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
        Button_Finish.setBounds(130, 355, 70, 30);
        Button_Return.setBounds(260, 355, 70, 30);
        Button_Finish.addActionListener(new AddClientFinishAction());
        Button_Return.addActionListener(new AddClientReturnAction());
    }

    class AddClientFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String cid = Text_Cid.getText();
            String clientName = Text_ClientName.getText();
            String clientAddress = Text_ClientAddress.getText();
            String phoneNumber = Text_PhoneNumber.getText();
            String bankCard = Text_BankCard.getText();
            String credibility = Text_Credibility.getText();
            String remark = Text_Remark.getText();

            if (cid.length() < 8 ||cid.length() > 10 ) {
                JOptionPane.showMessageDialog(null, "客户编号应该在8 ~ 10位之间", "Cid Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < cid.length(); i++) {
                if (!Character.isDigit(cid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "客户编号中含有非数字字符", "Cid Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (clientName.toString().equals("")) {
                JOptionPane.showMessageDialog(null, "客户姓名不能为空", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isFirstNameLegal(clientName)) {
                JOptionPane.showMessageDialog(null, "客户姓氏不合法", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (phoneNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "手机号码不能为空", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isPhoneNumberLegal(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "手机号码不合法（仅支持大陆手机号码）", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (bankCard.equals("")) {
                JOptionPane.showMessageDialog(null, "银行卡号不能为空", "BankCard Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isBankCardLegal(bankCard)) {
                JOptionPane.showMessageDialog(null, "银行卡号码不合法", "BankCard Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double doubleCredibility = 0;
            for (int i = 0; i < credibility.length(); i++) {
                if ((!(Character.isDigit(credibility.charAt(i))) && !(".".equals(String.valueOf(credibility.charAt(i))))) || credibility.length() > 3){
                    JOptionPane.showMessageDialog(null, "信任度不合法", "Credibility Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (!credibility.equals("")) {
                doubleCredibility = Double.valueOf(credibility);
            }

            int Cid = Integer.valueOf(cid);
            ClientService clientService = new ClientService();
            if (clientService.queryClientByIdService(Cid) != null) {
                JOptionPane.showMessageDialog(null, "客户编号不能重复", "Client id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Client client = new Client(Cid, clientName, clientAddress, phoneNumber, bankCard, doubleCredibility, remark);
            clientService.addClientService(client);
            JOptionPane.showMessageDialog(null, "添加客户信息成功", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class AddClientReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
