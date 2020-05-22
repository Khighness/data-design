package com.kag.gui;

import com.kag.entity.Staff;
import com.kag.service.StaffService;
import com.kag.common.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 添加职员界面
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public class AddStaffFrame extends JFrame {

    private final JLabel Label_Sid = new JLabel("编号");
    private final JLabel Label_StaffName = new JLabel("职员名");
    private final JLabel Label_Password = new JLabel("密码");
    private final JLabel Label_SureWord = new JLabel("确认密码");
    private final JLabel Label_BirthDate = new JLabel("生日");
    private final JLabel Label_Address = new JLabel("住址");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");
    private final JLabel Label_BankCard = new JLabel("银行卡号");

    private JTextField Text_Sid = new JTextField();
    private JTextField Text_StaffName = new JTextField();
    private JPasswordField Text_Password = new JPasswordField();
    private JPasswordField Text_SureWord = new JPasswordField();
    private JComboBox<String> ComboBox_Year = new JComboBox<>();
    private JComboBox<String> ComboBox_Month = new JComboBox<>();
    private JComboBox<String> ComboBox_Day = new JComboBox<>();
    private JTextField Text_Address = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();
    private JTextField Text_BankCard = new JTextField();

    private JButton Button_Finish = new JButton("完成");
    private JButton Button_Return = new JButton("返回");

    private final ImageIcon BackIcon = new ImageIcon("img/StaffBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public AddStaffFrame() {
        super();
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    /**
     * @Description: 设置窗口属性
     */
    private void initFrameProperty() {
        setTitle("新增职员");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e1) {
            ExceptUtil.printException(e1);
        } catch (UnsupportedLookAndFeelException e2) {
            ExceptUtil.printException(e2);
        } catch (InstantiationException e3) {
            ExceptUtil.printException(e3);
        } catch (IllegalAccessException e4) {
            ExceptUtil.printException(e4);
        }
    }

    /**
     * @Description: 设置窗口背景
     */
    private void initFrameBackground() {
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
        setIconImage(LogoIcon.getImage());
        setBounds(700, 200, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    /**
     * @Description: 设置窗口组件
     */
    private void initFrameComponent() {
        /**
         * @Description: JLabel
         */
        add(Label_Sid);
        add(Label_StaffName);
        add(Label_Password);
        add(Label_SureWord);
        add(Label_BirthDate);
        add(Label_Address);
        add(Label_PhoneNumber);
        add(Label_BankCard);
        Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
        Label_Sid.setFont(Label_Font);
        Label_StaffName.setFont(Label_Font);
        Label_Password.setFont(Label_Font);
        Label_SureWord.setFont(Label_Font);
        Label_BirthDate.setFont(Label_Font);
        Label_Address.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        Label_BankCard.setFont(Label_Font);
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

        /**
         * @Description: JTextField
         */
        add(Text_Sid);
        add(Text_StaffName);
        add(Text_Password);
        add(Text_SureWord);
        add(Text_Address);
        add(Text_PhoneNumber);
        add(Text_BankCard);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_Sid.setFont(Text_Font);
        Text_StaffName.setFont(Text_Font);
        Text_Password.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Text_SureWord.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Text_Address.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_BankCard.setFont(Text_Font);
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
        /**
         * @Description: 输入栏透明
         */
        Text_Sid.setOpaque(false);
        Text_StaffName.setOpaque(false);
        Text_Password.setOpaque(false);
        Text_SureWord.setOpaque(false);
        Text_Address.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_BankCard.setOpaque(false);

        /**
         * @Description: Combobox
         */
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
        ComboBox_Year.setBounds(new Rectangle(200, 265, 70, 30));
        ComboBox_Month.setBounds(new Rectangle(290, 265, 70, 30));
        ComboBox_Day.setBounds(new Rectangle(380, 265, 70, 30));

        /**
         * @Description: JButton
         */
        add(Button_Finish);
        add(Button_Return);
        Font Button_Font = new Font("华文楷体", 1, 18);
        Button_Finish.setFont(Button_Font);
        Button_Return.setFont(Button_Font);
        Button_Finish.setOpaque(false);
        Button_Return.setOpaque(false);
        Button_Finish.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Return.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Finish.setBounds(new Rectangle(150, 500, 80, 40));
        Button_Return.setBounds(new Rectangle(370, 500, 80, 40));
        Button_Finish.addActionListener(new AddStaffFinishAction());
        Button_Return.addActionListener(new ReturnAction());
    }

    /**
     * @Description: 完成注册
     */
    class AddStaffFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (Text_Sid.getText().length() < 8 || Text_Sid.getText().length() > 10 ) {
                JOptionPane.showMessageDialog(null, "职员编号应该在8 ~ 10位之间", "Sid Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < Text_Sid.getText().length(); i++) {
                if (!Character.isDigit(Text_Sid.getText().charAt(i))) {
                    JOptionPane.showMessageDialog(null, "职员编号中含有非数字字符", "Sid Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int sid = Integer.valueOf(Text_Sid.getText());

            if (Text_StaffName.getText().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "职员姓名为空", "Staff Name Error", JOptionPane.ERROR_MESSAGE);
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
    class ReturnAction implements ActionListener {
        int sid = 20200002;
        @Override
        public void actionPerformed(ActionEvent e) {
//            setVisible(false);
//            System.exit(0);
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

    public static void main(String[] args) {
        new AddStaffFrame();
    }

}
