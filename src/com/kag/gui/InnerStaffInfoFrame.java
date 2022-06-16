package com.kag.gui;

import com.kag.entity.Staff;
import com.kag.service.StaffService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * @apiNote 内部个人信息界面
 * @author KHighness
 * @since 2020/5/27
 */
public class InnerStaffInfoFrame extends JInternalFrame {

    private int sid;
    private final JLabel Label_Sid = new JLabel("ID");
    private final JLabel Label_StaffName = new JLabel("姓名");
    private final JLabel Label_BirthDate = new JLabel("生日");
    private final JLabel Label_Address = new JLabel("住址");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");
    private final JLabel Label_BankCard = new JLabel("银行卡号");

    private JTextField Text_Sid = new JTextField();
    private JTextField Text_StaffName = new JTextField();
    private JTextField Text_Birth = new JTextField();
    private JTextField Text_Address = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();
    private JTextField Text_BankCard = new JTextField();

    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final ImageIcon BackIcon = new ImageIcon("img/PersonInfoBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private JButton Button_Return = new JButton(ReturnIcon);
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerStaffInfoFrame(int sid) {
        this.sid = sid;

        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
        initFramePersonInfo();
    }

    private void initFrameProperty() {
        setTitle("我的信息");
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initFrameBackground() {
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
        setFrameIcon(LogoIcon);
        setBounds(600, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    private void initFrameComponent() {
        add(Label_Sid);
        add(Label_StaffName);
        add(Label_BirthDate);
        add(Label_Address);
        add(Label_PhoneNumber);
        add(Label_BankCard);
        Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
        Label_Sid.setFont(Label_Font);
        Label_StaffName.setFont(Label_Font);
        Label_BirthDate.setFont(Label_Font);
        Label_Address.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        Label_BankCard.setFont(Label_Font);
        int LABEL_X = 70, LABEL_Y_LEFT_FIRST = 40, LABEL_Y_DISTANCE = 50, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Rectangle[] Label_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Label_Rectangles[i] = new Rectangle(LABEL_X, LABEL_Y_LEFT_FIRST + i * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        }
        Label_Sid.setBounds(Label_Rectangles[0]);
        Label_StaffName.setBounds(Label_Rectangles[1]);
        Label_BirthDate.setBounds(Label_Rectangles[2]);
        Label_Address.setBounds(Label_Rectangles[3]);
        Label_PhoneNumber.setBounds(Label_Rectangles[4]);
        Label_BankCard.setBounds(Label_Rectangles[5]);

        add(Text_Sid);
        add(Text_StaffName);
        add(Text_Birth);
        add(Text_Address);
        add(Text_PhoneNumber);
        add(Text_BankCard);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_Sid.setFont(Text_Font);
        Text_StaffName.setFont(Text_Font);
        Text_Birth.setFont(Text_Font);
        Text_Address.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_BankCard.setFont(Text_Font);
        Text_Sid.setOpaque(false);
        Text_StaffName.setOpaque(false);
        Text_Birth.setOpaque(false);
        Text_Address.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_BankCard.setOpaque(false);
        Text_Sid.setEditable(false);
        Text_StaffName.setEditable(false);
        Text_Birth.setEditable(false);
        Text_Address.setEditable(false);
        Text_PhoneNumber.setEditable(false);
        Text_BankCard.setEditable(false);
        Text_Sid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_StaffName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Birth.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Address.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_BankCard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int TEXT_X = 170, TEXT_Y_FIRST = 40, TEXT_Y_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Rectangle[] Text_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Text_Rectangles[i] = new Rectangle(TEXT_X, TEXT_Y_FIRST + i * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        }
        Text_Sid.setBounds(Text_Rectangles[0]);
        Text_StaffName.setBounds(Text_Rectangles[1]);
        Text_Birth.setBounds(Text_Rectangles[2]);
        Text_Address.setBounds(Text_Rectangles[3]);
        Text_PhoneNumber.setBounds(Text_Rectangles[4]);
        Text_BankCard.setBounds(Text_Rectangles[5]);

        add(Button_Return);
        Button_Return.setBounds(25, 21, 30, 30);
        Button_Return.addActionListener(new ReturnAction());

    }

    private void initFramePersonInfo() {
        StaffService staffService = new StaffService();
        Staff staff = staffService.queryStaffByIdService(sid);

        Text_Sid.setText(String.valueOf(staff.getSid()));
        Text_StaffName.setText(staff.getStaffName());
        Text_Birth.setText(new SimpleDateFormat("yyyy年MM月dd日").format(staff.getBirthDate()));
        Text_Address.setText(staff.getAddress());
        Text_PhoneNumber.setText(staff.getPhoneNumber());
        Text_BankCard.setText(staff.getBankCard());
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
