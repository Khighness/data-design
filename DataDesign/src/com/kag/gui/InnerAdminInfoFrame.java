package com.kag.gui;

import com.kag.entity.Staff;
import com.kag.entity.User;
import com.kag.service.StaffService;
import com.kag.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * @Description: 内部我的信息界面
 * @Author: 陈子康
 * @Date: 2020/5/30
 */
public class InnerAdminInfoFrame extends JInternalFrame {

    private int uid;
    private final JLabel Label_Uid = new JLabel("ID");
    private final JLabel Label_Username = new JLabel("用户名");
    private final JLabel Label_Age = new JLabel("年龄");
    private final JLabel Label_Sex = new JLabel("性别");
    private final JLabel Label_Signature = new JLabel("个性签名");
    private final JLabel Label_PhoneNumber = new JLabel("联系电话");

    private JTextField Text_Uid = new JTextField();
    private JTextField Text_Username = new JTextField();
    private JTextField Text_Age = new JTextField();
    private JTextField Text_Sex = new JTextField();
    private JTextField Text_Signature = new JTextField();
    private JTextField Text_PhoneNumber = new JTextField();

    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final ImageIcon BackIcon = new ImageIcon("img/PersonInfoBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/UserLogo.png");
    private JButton Button_Return = new JButton(ReturnIcon);
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerAdminInfoFrame(int uid) {
        this.uid = uid;
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
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    private void initFrameComponent() {
        add(Label_Uid);
        add(Label_Username);
        add(Label_Age);
        add(Label_Sex);
        add(Label_Signature);
        add(Label_PhoneNumber);
        Font Label_Font = new Font("微软雅黑", Font.BOLD, 20);
        Label_Uid.setFont(Label_Font);
        Label_Username.setFont(Label_Font);
        Label_Age.setFont(Label_Font);
        Label_Sex.setFont(Label_Font);
        Label_Signature.setFont(Label_Font);
        Label_PhoneNumber.setFont(Label_Font);
        int LABEL_X = 70, LABEL_Y_LEFT_FIRST = 40, LABEL_Y_DISTANCE = 50, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Rectangle[] Label_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Label_Rectangles[i] = new Rectangle(LABEL_X, LABEL_Y_LEFT_FIRST + i * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        }
        Label_Uid.setBounds(Label_Rectangles[0]);
        Label_Username.setBounds(Label_Rectangles[1]);
        Label_Age.setBounds(Label_Rectangles[2]);
        Label_Sex.setBounds(Label_Rectangles[3]);
        Label_Signature.setBounds(Label_Rectangles[4]);
        Label_PhoneNumber.setBounds(Label_Rectangles[5]);

        add(Text_Uid);
        add(Text_Username);
        add(Text_Age);
        add(Text_Sex);
        add(Text_Signature);
        add(Text_PhoneNumber);
        Font Text_Font = new Font("微软雅黑", Font.PLAIN, 18);
        Text_Uid.setFont(Text_Font);
        Text_Username.setFont(Text_Font);
        Text_Age.setFont(Text_Font);
        Text_Sex.setFont(Text_Font);
        Text_Signature.setFont(Text_Font);
        Text_PhoneNumber.setFont(Text_Font);
        Text_Uid.setOpaque(false);
        Text_Username.setOpaque(false);
        Text_Age.setOpaque(false);
        Text_Sex.setOpaque(false);
        Text_Signature.setOpaque(false);
        Text_PhoneNumber.setOpaque(false);
        Text_Uid.setEditable(false);
        Text_Username.setEditable(false);
        Text_Age.setEditable(false);
        Text_Sex.setEditable(false);
        Text_Signature.setEditable(false);
        Text_PhoneNumber.setEditable(false);
        Text_Uid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Username.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Age.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Sex.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Signature.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PhoneNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int TEXT_X = 170, TEXT_Y_FIRST = 40, TEXT_Y_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        Rectangle[] Text_Rectangles = new Rectangle[6];
        for (int i = 0; i < 6; i++) {
            Text_Rectangles[i] = new Rectangle(TEXT_X, TEXT_Y_FIRST + i * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        }
        Text_Uid.setBounds(Text_Rectangles[0]);
        Text_Username.setBounds(Text_Rectangles[1]);
        Text_Age.setBounds(Text_Rectangles[2]);
        Text_Sex.setBounds(Text_Rectangles[3]);
        Text_Signature.setBounds(Text_Rectangles[4]);
        Text_PhoneNumber.setBounds(Text_Rectangles[5]);

        add(Button_Return);
        Button_Return.setBounds(25, 21, 30, 30);
        Button_Return.addActionListener(new ReturnAction());

    }

    private void initFramePersonInfo() {
        UserService userService = new UserService();
        User user = userService.queryUserService(uid);
        Text_Uid.setText(String.valueOf(user.getUid()));
        Text_Username.setText(user.getUsername());
        Text_Age.setText(String.valueOf(user.getAge()));
        Text_Sex.setText(user.getSex());
        Text_Signature.setText(user.getSignature());
        Text_PhoneNumber.setText(user.getPhoneNumber());
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
