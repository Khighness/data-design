package com.kag.gui;

import com.kag.common.CheckUtil;
import com.kag.common.ColorUtil;
import com.kag.common.ExceptUtil;
import com.kag.entity.Staff;
import com.kag.service.StaffService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 内部更改个人信息界面
 * @Author: 陈子康
 * @Date: 2020/5/27
 */
public class InnerUpdateStaffInfoFrame extends JInternalFrame{

    private int sid;
    private StaffService staffService = new StaffService();
    private Staff staff;
    private final JLabel Label_StaffName = new JLabel("姓名");
    private final JLabel Label_BirthDate = new JLabel("生日");
    private final JLabel Label_Address = new JLabel("住址");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");
    private final JLabel Label_BankCard = new JLabel("银行卡号");

    private JTextField Text_StaffName = new JTextField();
    private JComboBox<String> ComboBox_Year = new JComboBox<>();
    private JComboBox<String> ComboBox_Month = new JComboBox<>();
    private JComboBox<String> ComboBox_Day = new JComboBox<>();
    private JTextField Text_Address = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();
    private JTextField Text_BankCard = new JTextField();

    private final ImageIcon BackIcon = new ImageIcon("img/UpdateInfoBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final ImageIcon FinishIcon = new ImageIcon("img/EditButton.png");
    public final JButton Button_Return = new JButton(ReturnIcon);
    public final JButton Button_Finish = new JButton(FinishIcon);
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerUpdateStaffInfoFrame(int sid) {
        this.sid = sid;
        staff = staffService.queryStaffByIdService(sid);
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
        initFramePersonInfo();
    }

    private void initFrameProperty() {
        setTitle("更改信息");
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
        add(Label_StaffName);
        add(Label_BirthDate);
        add(Label_Address);
        add(Label_PhoneNumber);
        add(Label_BankCard);
        Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
        Label_StaffName.setFont(Label_Font);
        Label_BirthDate.setFont(Label_Font);
        Label_Address.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        Label_BankCard.setFont(Label_Font);
        int LABEL_X = 65, LABEL_Y_LEFT_FIRST = 45, LABEL_Y_DISTANCE = 50, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Rectangle[] Label_Rectangles = new Rectangle[5];
        for (int i = 0; i < 5; i++) {
            Label_Rectangles[i] = new Rectangle(LABEL_X, LABEL_Y_LEFT_FIRST + i * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        }
        Label_StaffName.setBounds(Label_Rectangles[0]);
        Label_BirthDate.setBounds(Label_Rectangles[1]);
        Label_Address.setBounds(Label_Rectangles[2]);
        Label_PhoneNumber.setBounds(Label_Rectangles[3]);
        Label_BankCard.setBounds(Label_Rectangles[4]);

        add(Text_StaffName);
        add(Text_Address);
        add(Text_PhoneNumber);
        add(Text_BankCard);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_StaffName.setFont(Text_Font);
        Text_Address.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_BankCard.setFont(Text_Font);
        Text_StaffName.setOpaque(false);
        Text_Address.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_BankCard.setOpaque(false);
        Text_StaffName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Address.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_BankCard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int TEXT_X = 165, TEXT_Y_FIRST = 45, TEXT_Y_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Rectangle[] Text_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Text_Rectangles[i] = new Rectangle(TEXT_X, TEXT_Y_FIRST + i * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        }
        Text_StaffName.setBounds(Text_Rectangles[0]);
        Text_Address.setBounds(Text_Rectangles[2]);
        Text_PhoneNumber.setBounds(Text_Rectangles[3]);
        Text_BankCard.setBounds(Text_Rectangles[4]);

        add(ComboBox_Year);
        add(ComboBox_Month);
        add(ComboBox_Day);
        for (int i = 1900; i <= 2010; i++) {
            ComboBox_Year.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            ComboBox_Month.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 31; i++) {
            ComboBox_Day.addItem(String.valueOf(i));
        }
        ComboBox_Year.setOpaque(false);
        ComboBox_Month.setOpaque(false);
        ComboBox_Day.setOpaque(false);
        Font Combo_Font = new Font("微软雅黑", Font.PLAIN, 16);
        ComboBox_Year.setFont(Combo_Font);
        ComboBox_Month.setFont(Combo_Font);
        ComboBox_Day.setFont(Combo_Font);
        ComboBox_Year.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Month.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Day.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Year.setBounds(new Rectangle(170, 95, 70, 30));
        ComboBox_Month.setBounds(new Rectangle(265, 95, 70, 30));
        ComboBox_Day.setBounds(new Rectangle(350, 95, 70, 30));

        add(Button_Return);
        add(Button_Finish);
        Button_Return.setBounds(21, 32, 30, 30);
        Button_Finish.setBounds(433, 32, 30, 30);
        Button_Return.addActionListener(new ReturnAction());
        Button_Finish.addActionListener(new FinishAction());
    }

    private void initFramePersonInfo() {
        Text_StaffName.setText(staff.getStaffName());
        Text_Address.setText(staff.getAddress());
        Text_PhoneNumber.setText(staff.getPhoneNumber());
        Text_BankCard.setText(staff.getBankCard());
    }

    class FinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String staffName = Text_StaffName.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = null;
            try {
                birthDate = simpleDateFormat.parse((String) ComboBox_Year.getSelectedItem() + '-' +
                        (String) ComboBox_Month.getSelectedItem() + '-' +
                        (String) ComboBox_Day.getSelectedItem());
            } catch (ParseException ex) {
                ExceptUtil.printException(ex);
            }
            String address = Text_Address.getText();
            String phoneNumber = Text_PhoneNumber.getText();
            String bankCard = Text_BankCard.getText();

            if (staffName.equals("")) {
                JOptionPane.showMessageDialog(null, "姓名不能为空", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isFirstNameLegal(staffName)) {
                JOptionPane.showMessageDialog(null, "姓名不合法", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
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

            staff.setStaffName(staffName);
            staff.setBirthDate(birthDate);
            staff.setAddress(address);
            staff.setPhoneNumber(phoneNumber);
            staff.setBankCard(bankCard);
            staffService.updateStaffService(sid, staff);

            JOptionPane.showMessageDialog(null, "更改信息成功", "Success", JOptionPane.YES_OPTION);
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
