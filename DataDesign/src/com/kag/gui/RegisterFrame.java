package com.kag.gui;

import com.kag.entity.User;
import com.kag.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import com.kag.common.CheckUtil;
import com.kag.common.ExceptUtil;

/**
 * @Description: 注册界面
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public class RegisterFrame extends JFrame {

    private final JLabel Label_Username = new JLabel("用户名");
    private final JLabel Label_Password = new JLabel("密码");
    private final JLabel Label_Age = new JLabel("年龄");
    private final JLabel Label_Sex = new JLabel("性别");
    private final JLabel Label_Signature = new JLabel("个性签名");
    private final JLabel Label_PhoneNumber = new JLabel("电话号码");

    private JTextField Text_Username = new JTextField();
    private JPasswordField Text_Password = new JPasswordField();
    private JTextField Text_Age = new JTextField();
    private JComboBox<String> ComboBoxSex = new JComboBox<String>();
    private JTextField Text_Signature = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("返回");
    private final Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
    private final Font Button_Font = new Font("华文楷体", 1, 18);

    private final ImageIcon BackIcon = new ImageIcon("img/RegisterBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/RegisterLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel BackPanel = (JPanel) getContentPane();

    public RegisterFrame() throws Exception {
        super();
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    /**
     * @Description: 设置窗口图片
     */
    private void initFrameBackground() {
        /**
         * 设置背景
         */
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        BackPanel.setOpaque(false);
        BackPanel.setLayout(new FlowLayout());
        getLayeredPane().setLayout(null);
        getLayeredPane().add(BackLabel, new Integer(Integer.MIN_VALUE));
        /**
         * 设置Logo
         */
        setIconImage(LogoIcon.getImage());
        /**
         * 根据背景图片设置窗体的大小
         */
        setBounds(700, 200, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    /**
     * @Description: 设置窗口属性
     */
    private void initFrameProperty() {
        setTitle("用户注册");
        setVisible(true);
        setResizable(false);
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
     * @Description: 设置窗口部件
     */
    private void initFrameComponent() {
        setLayout(null);

        /**
         * @Description: JLabel
         */
        add(Label_Username);
        add(Label_Password);
        add(Label_Age);
        add(Label_Sex);
        add(Label_Signature);
        add(Label_PhoneNumber);
        Label_Username.setFont(Label_Font);
        Label_Password.setFont(Label_Font);
        Label_Age.setFont(Label_Font);
        Label_Sex.setFont(Label_Font);
        Label_Signature.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        int Y_FIRST = 70, LABEL_Y_DISTANCE = 50;
        Label_Username.setBounds(new Rectangle(100, Y_FIRST, 100, 20));
        Label_Password.setBounds(new Rectangle(100, Y_FIRST + LABEL_Y_DISTANCE,100, 20));
        Label_Age.setBounds(new Rectangle(100, Y_FIRST + 2 * LABEL_Y_DISTANCE, 100, 20));
        Label_Sex.setBounds(new Rectangle(100, Y_FIRST + 3 * LABEL_Y_DISTANCE, 100, 20));
        Label_Signature.setBounds(new Rectangle(100, Y_FIRST + 4 * LABEL_Y_DISTANCE, 100, 20));
        Label_PhoneNumber.setBounds(new Rectangle(100, Y_FIRST + 5 * LABEL_Y_DISTANCE, 100, 20));

        /**
         * @Description: JTextField
         */
        add(Text_Username);
        add(Text_Password);
        add(Text_Age);
        add(ComboBoxSex);
        add(Text_Signature);
        add(Text_PhoneNumber);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_Username.setFont(Text_Font);
        Text_Password.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Text_Age.setFont(Text_Font);
        ComboBoxSex.setFont(Text_Font);
        Text_Signature.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_Username.setBounds(new Rectangle(200, Y_FIRST - 5, 300, 30));
        Text_Password.setBounds(new Rectangle(200, Y_FIRST + LABEL_Y_DISTANCE - 5, 300, 30));
        Text_Age.setBounds(new Rectangle(200, Y_FIRST + 2 * LABEL_Y_DISTANCE - 5, 300, 30));
        ComboBoxSex.addItem("     男");
        ComboBoxSex.addItem("     女");
        ComboBoxSex.setBounds(new Rectangle(200 + 100, Y_FIRST + 3 * LABEL_Y_DISTANCE - 5, 100, 30));
        Text_Signature.setBounds(new Rectangle(200, Y_FIRST + 4 * LABEL_Y_DISTANCE - 5, 300, 30));
        Text_PhoneNumber.setBounds(new Rectangle(200, Y_FIRST + 5 * LABEL_Y_DISTANCE - 5, 300, 30));
        Text_Username.setOpaque(false);
        Text_Password.setOpaque(false);
        Text_Age.setOpaque(false);
        ComboBoxSex.setOpaque(false);
        Text_Signature.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);

        /**
         * @Description: JButton
         */
        add(Button_Finish);
        add(Button_Return);

        Button_Finish.setFont(Button_Font);
        Button_Return.setFont(Button_Font);
        Button_Finish.setBounds(new Rectangle(250, 450, 80, 40));
        Button_Return.setBounds(new Rectangle(420, 450, 80, 40));

        /**
         * setContentAreaFilled(false) => 设置按钮透明
         * setBorderPainted(false)     =>去掉按钮边框
         * setBorder(BorderFactory.createLoweredBevelBorder()) => 设置按钮内凹
         * setBorder(BorderFactory.createRaisedBevelBorder())  => 设置按钮凸出
         */
        Button_Finish.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Finish.setContentAreaFilled(false);
        Button_Return.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Return.setContentAreaFilled(false);
        Button_Finish.addActionListener(new RegisterFinishAction());
        Button_Return.addActionListener(new ReturnLoginAction());
    }

    /**
     * @Description: 完成注册
     */
    class RegisterFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            /**
             * @Description: 判断输入是否合法
             */
            String username = Text_Username.getText();
            if ( (username.equals("")) || (username.length() > 10) ){
                JOptionPane.showMessageDialog(null, "用户名不合法，请重新输入", "Username Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String password = new String(Text_Password.getPassword());
            if ( (password == null) || (password.length() < 6) || (password.length() > 16) ) {
                JOptionPane.showMessageDialog(null, "密码长度在6~16位之间，请重新输入", "Password Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;
            if (!Text_Age.getText().equals("")) {
                age = Integer.valueOf(Text_Age.getText());
                if ( age <= 0 || age >= 200 ) {
                    JOptionPane.showMessageDialog(null, "年龄不合法，请重新确认", "Age Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                age = 0;
            }

            String sex = (String) ComboBoxSex.getSelectedItem();
            if (sex.contains("男")) {
                sex = "男";
            } else {
                sex = "女";
            }

            String signature = Text_Signature.getText();
            if ( signature.length() > 100 ) {
                JOptionPane.showMessageDialog(null, "个性签名长度超过50，请重新输入", "Signature Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String phoneNumber = Text_PhoneNumber.getText();
            if (!(phoneNumber.equals("")) && !(CheckUtil.isPhoneNumberLegal(phoneNumber))) {
                JOptionPane.showMessageDialog(null, "手机号码不合法（仅支持大陆手机号码）", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            /**
             * @Description: 合法，添加到数据库
             */
            UserService userService = new UserService();
            User user = new User(0, username, password, age, sex, signature, phoneNumber);
            userService.addUserService(user);
        }
    }

    /**
     * @Description: 返回登陆
     */
    class ReturnLoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setVisible(false);
                new LoginFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        RegisterFrame r = new RegisterFrame();
    }

}
