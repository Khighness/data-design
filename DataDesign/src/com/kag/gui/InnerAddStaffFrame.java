package com.kag.gui;

import com.kag.common.*;
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
 * @Description: 内部添加职员界面
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class InnerAddStaffFrame extends JInternalFrame {

    private final JLabel Label_Sid = new JLabel("编号");
    private final JLabel Label_StaffName = new JLabel("职员名");
    private final JLabel Label_Password = new JLabel("密码");
    private final JLabel Label_SureWord = new JLabel("确认密码");
    private final JLabel Label_BirthDate = new JLabel("生日");
    private final JLabel Label_Address = new JLabel("住址");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");
    private final JLabel Label_BankCard = new JLabel("银行卡号");

    private final JTextField Text_Sid = new JTextField();
    private final JTextField Text_StaffName = new JTextField();
    private final JPasswordField Text_Password = new JPasswordField();
    private final JPasswordField Text_SureWord = new JPasswordField();
    private final JComboBox<String> ComboBox_Year = new JComboBox<>();
    private final JComboBox<String> ComboBox_Month = new JComboBox<>();
    private final JComboBox<String> ComboBox_Day = new JComboBox<>();
    private final JTextField Text_Address = new JTextField();
    private final JTextField Text_PhoneNumber = new JTextField();
    private final JTextField Text_BankCard = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("返回");

    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 20);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", 1, 18);
    private final Font Font_Combobox = new Font("微软雅黑", Font.PLAIN, 15);

    private final ImageIcon BackIcon = new ImageIcon("img/StaffBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerAddStaffFrame() {
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    /**
     * @Description: 设置窗口背景
     */
    private void initFrameBackground() {
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
    }

    /**
     * @Description: 设置窗口属性
     */
    private void initFrameProperty() {
        setBounds(300, 50, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setTitle("新增职员");
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * @Description: 设置窗口组件
     */
    private void initFrameComponent() {
        add(Label_Sid);
        add(Label_StaffName);
        add(Label_Password);
        add(Label_SureWord);
        add(Label_BirthDate);
        add(Label_Address);
        add(Label_PhoneNumber);
        add(Label_BankCard);
        Label_Sid.setFont(Font_Label);
        Label_StaffName.setFont(Font_Label);
        Label_Password.setFont(Font_Label);
        Label_SureWord.setFont(Font_Label);
        Label_BirthDate.setFont(Font_Label);
        Label_Address.setFont(Font_Label);
        Label_PhoneNumber.setFont(Font_Label);
        Label_BankCard.setFont(Font_Label);
        int LABEL_X = 100, LABEL_Y_LEFT_FIRST = 50, LABEL_Y_DISTANCE = 55, LABEL_WIDTH = 100, LABEL_HEIGHT = 20;
        Rectangle[] Label_Rectangles = new Rectangle[8];
        for (int i = 0; i < 8; i++) {
            Label_Rectangles[i] = new Rectangle(LABEL_X, LABEL_Y_LEFT_FIRST + i * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        }
        Label_Sid.setBounds(Label_Rectangles[0]);
        Label_StaffName.setBounds(Label_Rectangles[1]);
        Label_Password.setBounds(Label_Rectangles[2]);
        Label_SureWord.setBounds(Label_Rectangles[3]);
        Label_BirthDate.setBounds(Label_Rectangles[4]);
        Label_Address.setBounds(Label_Rectangles[5]);
        Label_PhoneNumber.setBounds(Label_Rectangles[6]);
        Label_BankCard.setBounds(Label_Rectangles[7]);

        add(Text_Sid);
        add(Text_StaffName);
        add(Text_Password);
        add(Text_SureWord);
        add(Text_Address);
        add(Text_PhoneNumber);
        add(Text_BankCard);
        Text_Sid.setFont(Font_Text);
        Text_StaffName.setFont(Font_Text);
        Text_Password.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Text_SureWord.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        Text_Address.setFont(Font_Text);
        Text_PhoneNumber.setFont(Font_Text);
        Text_BankCard.setFont(Font_Text);
        int TEXT_X = 200, TEXT_Y_FIRST = 45, TEXT_Y_DISTANCE = 55, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Rectangle[] Text_Rectangles = new Rectangle[8];
        for (int i = 0; i < 8; i++) {
            Text_Rectangles[i] = new Rectangle(TEXT_X, TEXT_Y_FIRST + i * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        }
        Text_Sid.setBounds(Text_Rectangles[0]);
        Text_StaffName.setBounds(Text_Rectangles[1]);
        Text_Password.setBounds(Text_Rectangles[2]);
        Text_SureWord.setBounds(Text_Rectangles[3]);
        Text_Address.setBounds(Text_Rectangles[5]);
        Text_PhoneNumber.setBounds(Text_Rectangles[6]);
        Text_BankCard.setBounds(Text_Rectangles[7]);
        Text_Sid.setOpaque(false);
        Text_StaffName.setOpaque(false);
        Text_Password.setOpaque(false);
        Text_SureWord.setOpaque(false);
        Text_Address.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_BankCard.setOpaque(false);
        Text_Sid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_StaffName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Password.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_SureWord.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Address.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_BankCard.setBorder(BorderFactory.createLineBorder(Color.WHITE));

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
        ComboBox_Year.setFont(Font_Combobox);
        ComboBox_Month.setFont(Font_Combobox);
        ComboBox_Day.setFont(Font_Combobox);
        ComboBox_Year.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Month.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Day.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Year.setBounds(new Rectangle(200, 265, 70, 30));
        ComboBox_Month.setBounds(new Rectangle(290, 265, 70, 30));
        ComboBox_Day.setBounds(new Rectangle(380, 265, 70, 30));

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
//        Button_Finish.setBorderPainted(false);
//        Button_Return.setBorderPainted(false);
        Button_Finish.setBounds(new Rectangle(150, 500, 80, 30));
        Button_Return.setBounds(new Rectangle(370, 500, 80, 30));
        Button_Finish.addActionListener(new AddStaffFinishAction());
        Button_Return.addActionListener(new AddStaffReturnAction());
    }

    /**
     * @Description: 完成注册
     */
    class AddStaffFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (Text_Sid.getText().length() < 8 || Text_Sid.getText().length() > 10 ) {
                JOptionPane.showMessageDialog(null, "职员编号应该在8 ~ 10位之间", "Staff Id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < Text_Sid.getText().length(); i++) {
                if (!Character.isDigit(Text_Sid.getText().charAt(i))) {
                    JOptionPane.showMessageDialog(null, "职员编号中含有非数字字符", "Staff Id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int sid = Integer.valueOf(Text_Sid.getText());

            if (Text_StaffName.getText().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "职员姓名不能为空", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isFirstNameLegal(Text_StaffName.getText())) {
                JOptionPane.showMessageDialog(null, "职员姓氏不合法", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String staffName = Text_StaffName.getText();

            if (Text_Password.getPassword().equals(Text_SureWord.getPassword())) {
                JOptionPane.showMessageDialog(null, "两次密码输入不一致", "Password Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (Text_Password.getPassword().length < 6  || Text_Password.getPassword().length > 16) {
                JOptionPane.showMessageDialog(null, "密码长度应在6 ~ 16位之间", "Password Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String password = new String(Text_Password.getPassword());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = null;
            try {
                birthDate = simpleDateFormat.parse((String) ComboBox_Year.getSelectedItem() + '-' +
                        (String) ComboBox_Month.getSelectedItem() + '-' +
                        (String) ComboBox_Day.getSelectedItem());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            String address = Text_Address.getText();
            String phoneNumber = Text_PhoneNumber.getText();
            if (phoneNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "手机号码不能为空", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isPhoneNumberLegal(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "手机号码不合法（仅支持大陆手机号码）", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String bankCard = Text_BankCard.getText();
            if (bankCard.equals("")) {
                JOptionPane.showMessageDialog(null, "银行卡号不能为空", "BankCard Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isBankCardLegal(bankCard)) {
                JOptionPane.showMessageDialog(null, "银行卡号码不合法", "BankCard Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Staff staff = new Staff(sid, staffName, password, birthDate, address, phoneNumber, bankCard, 1);
            StaffService staffService = new StaffService();
            staffService.addStaffService(staff);
            JOptionPane.showMessageDialog(null, "添加成功", "Success", JOptionPane.YES_NO_CANCEL_OPTION);
        }
    }

    /**
     * @Description: 返回操作
     */
    class AddStaffReturnAction implements ActionListener {
        int sid = 20200101;
        @Override
        public void actionPerformed(ActionEvent e) {
            //setVisible(false);
            /**
             * 点击一次返回，自动填充一次资料
             */
            Text_Sid.setText(String.valueOf(sid++));
            Text_StaffName.setText(RandomPersonInfoGenerator.getChineseName());
            String password = new RandomPasswordGenerator(10, 3).getRandomPassword();
            Text_Password.setText(password);
            Text_SureWord.setText(password);
            Text_Address.setText(RandomPersonInfoGenerator.getAddress());
            Text_PhoneNumber.setText(RandomPersonInfoGenerator.getTel());
            Text_BankCard.setText(RandomCreditCardNumberGenerator.getRandomCardNumber());
        }
    }

}
