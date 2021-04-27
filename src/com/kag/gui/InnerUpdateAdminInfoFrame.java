package com.kag.gui;

import com.kag.common.CheckUtil;
import com.kag.common.ColorUtil;
import com.kag.common.ExceptUtil;
import com.kag.entity.User;
import com.kag.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * @Description: 内部更改个人信息界面
 * @Author: 陈子康
 * @Date: 2020/5/27
 */
public class InnerUpdateAdminInfoFrame extends JInternalFrame{

    private int uid;
    private User user;
    private UserService userService = new UserService();
    private final JLabel Label_UserName = new JLabel("姓名");
    private final JLabel Label_Age = new JLabel("年龄");
    private final JLabel Label_Sex = new JLabel("性别");
    private final JLabel Label_Signature = new JLabel("个性签名");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");

    private JTextField Text_UserName = new JTextField();
    private JTextField Text_Age = new JTextField();
    private JComboBox<String> ComboBox_Sex = new JComboBox<>();
    private JTextField Text_Signature = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();

    private final ImageIcon BackIcon = new ImageIcon("img/UpdateInfoBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/UserLogo.png");
    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final ImageIcon FinishIcon = new ImageIcon("img/EditButton.png");
    public final JButton Button_Return = new JButton(ReturnIcon);
    public final JButton Button_Finish = new JButton(FinishIcon);
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerUpdateAdminInfoFrame(int uid) {
        this.uid = uid;
        user = userService.queryUserService(uid);
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
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    private void initFrameComponent() {
        add(Label_UserName);
        add(Label_Age);
        add(Label_Sex);
        add(Label_PhoneNumber);
        add(Label_Signature);
        Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
        Label_UserName.setFont(Label_Font);
        Label_Age.setFont(Label_Font);
        Label_Sex.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        Label_Signature.setFont(Label_Font);
        int LABEL_X = 65, LABEL_Y_LEFT_FIRST = 45, LABEL_Y_DISTANCE = 50, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Rectangle[] Label_Rectangles = new Rectangle[5];
        for (int i = 0; i < 5; i++) {
            Label_Rectangles[i] = new Rectangle(LABEL_X, LABEL_Y_LEFT_FIRST + i * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        }
        Label_UserName.setBounds(Label_Rectangles[0]);
        Label_Age.setBounds(Label_Rectangles[1]);
        Label_Sex.setBounds(Label_Rectangles[2]);
        Label_PhoneNumber.setBounds(Label_Rectangles[4]);
        Label_Signature.setBounds(Label_Rectangles[3]);

        add(Text_UserName);
        add(Text_Age);
        add(Text_PhoneNumber);
        add(Text_Signature);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_UserName.setFont(Text_Font);
        Text_Age.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_Signature.setFont(Text_Font);
        Text_UserName.setOpaque(false);
        Text_Age.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_Signature.setOpaque(false);
        Text_UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Age.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Signature.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int TEXT_X = 165, TEXT_Y_FIRST = 45, TEXT_Y_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Rectangle[] Text_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Text_Rectangles[i] = new Rectangle(TEXT_X, TEXT_Y_FIRST + i * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        }
        Text_UserName.setBounds(Text_Rectangles[0]);
        Text_Age.setBounds(Text_Rectangles[2]);
        Text_Signature.setBounds(Text_Rectangles[3]);
        Text_PhoneNumber.setBounds(Text_Rectangles[4]);

        add(ComboBox_Sex);
        ComboBox_Sex.addItem("      男   ");
        ComboBox_Sex.addItem("      女   ");
        ComboBox_Sex.setOpaque(false);
        Font Combo_Font = new Font("微软雅黑", Font.PLAIN, 16);
        ComboBox_Sex.setFont(Combo_Font);
        ComboBox_Sex.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Sex.setBounds(new Rectangle(230, 95, 100, 30));
        add(Button_Return);
        add(Button_Finish);
        Button_Return.setBounds(21, 32, 30, 30);
        Button_Finish.setBounds(433, 32, 30, 30);
        Button_Return.addActionListener(new ReturnAction());
        Button_Finish.addActionListener(new FinishAction());
    }

    private void initFramePersonInfo() {
        Text_UserName.setText(user.getUsername());
        Text_Age.setText(String.valueOf(user.getAge()));
        Text_Signature.setText(user.getSignature());
        Text_PhoneNumber.setText(user.getPhoneNumber());

    }

    class FinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String userName = Text_UserName.getText();
            String age = Text_Age.getText();
            String sex = (String) ComboBox_Sex.getSelectedItem();
            String signature = Text_Signature.getText();
            String phoneNumber = Text_PhoneNumber.getText();

            if (userName.equals("")) {
                JOptionPane.showMessageDialog(null, "用户名不能为空", "Username Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < age.length(); i++) {
                if (!Character.isDigit(age.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "年龄非法", "Age Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (sex.contains("男")) {
                sex = "男";
            } else {
                sex = "女";
            }
            if (phoneNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "手机号码不能为空", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!CheckUtil.isPhoneNumberLegal(phoneNumber)) {
                JOptionPane.showMessageDialog(null, "手机号码不合法（仅支持大陆手机号码）", "PhoneNumber Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            user.setUsername(userName);
            user.setAge(Integer.valueOf(age));
            user.setSex(sex);
            user.setSignature(signature);
            user.setPhoneNumber(phoneNumber);
            userService.updateUserService(uid, user);
            JOptionPane.showMessageDialog(null, "更改信息成功", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
