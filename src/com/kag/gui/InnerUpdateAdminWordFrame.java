package com.kag.gui;

import com.kag.entity.Staff;
import com.kag.entity.User;
import com.kag.service.StaffService;
import com.kag.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @apiNote 内部修改登录密码界面
 * @author KHighness
 * @since 2020/5/30
 */
public class InnerUpdateAdminWordFrame extends JInternalFrame{

    private int uid;
    private User user;
    private UserService userService = new UserService();

    private final JLabel Label_OldPassword = new JLabel("原密码");
    private final JLabel Label_NewPassword = new JLabel("新密码");
    private final JLabel Label_SurePassword = new JLabel("确认密码");
    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);

    private final JPasswordField OldPassWord = new JPasswordField();
    private final JPasswordField NewPassWord = new JPasswordField();
    private final JPasswordField SurePassWord = new JPasswordField();
    private final Font Font_Text = new Font("微软雅黑", Font.BOLD, 20);

    private final ImageIcon BackIcon = new ImageIcon("img/UpdateWordBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/UserLogo.png");
    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final ImageIcon FinishIcon = new ImageIcon("img/EditButton.png");
    public final JButton Button_Return = new JButton(ReturnIcon);
    public final JButton Button_Finish = new JButton(FinishIcon);
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerUpdateAdminWordFrame(int uid) {
        this.uid = uid;
        user = userService.queryUserService(uid);
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    private void initFrameProperty() {
        setTitle("修改密码");
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

        add(Label_OldPassword);
        add(Label_NewPassword);
        add(Label_SurePassword);
        Label_OldPassword.setFont(Font_Label);
        Label_NewPassword.setFont(Font_Label);
        Label_SurePassword.setFont(Font_Label);
        int LABEL_X = 65, LABEL_Y_FIRST = 50, LABEL_Y_DISTANCE = 50, LABEL_WIDTH = 100, LABEL_HEIGHT = 30;
        Label_OldPassword.setBounds(LABEL_X, LABEL_Y_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_NewPassword.setBounds(LABEL_X, LABEL_Y_FIRST + 1 * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_SurePassword.setBounds(LABEL_X, LABEL_Y_FIRST + 2 * LABEL_Y_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(OldPassWord);
        add(NewPassWord);
        add(SurePassWord);
        OldPassWord.setOpaque(false);
        NewPassWord.setOpaque(false);
        SurePassWord.setOpaque(false);
        OldPassWord.setFont(Font_Text);
        NewPassWord.setFont(Font_Text);
        SurePassWord.setFont(Font_Text);
        OldPassWord.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        NewPassWord.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        SurePassWord.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int TEXT_X = 165, TEXT_Y_FIRST = 50, TEXT_Y_DISTANCE = 50, TEXT_WIDTH = 250, TEXT_HEIGHT = 30;
        OldPassWord.setBounds(TEXT_X, TEXT_Y_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        NewPassWord.setBounds(TEXT_X, TEXT_Y_FIRST + 1 *TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        SurePassWord.setBounds(TEXT_X, TEXT_Y_FIRST + 2 * TEXT_Y_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Return);
        add(Button_Finish);
        Button_Return.setBounds(22, 31, 30, 30);
        Button_Finish.setBounds(433, 31, 30, 30);
        Button_Return.addActionListener(new ReturnAction());
        Button_Finish.addActionListener(new FinishAction());
    }

    class FinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String oldPassword = new String(OldPassWord.getPassword());
            String newPassword = new String(NewPassWord.getPassword());
            String surePassword = new String(SurePassWord.getPassword());

            if (!oldPassword.equals(user.getPassword())) {
                JOptionPane.showMessageDialog(null, "原密码不正确", "Old password Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (newPassword.length() < 6 || newPassword.length() > 16) {
                JOptionPane.showMessageDialog(null, "密码长度应该在6~16位之间", "New password Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!newPassword.equals(surePassword)) {
                JOptionPane.showMessageDialog(null, "两次密码输入不一致", "Password Difference", JOptionPane.ERROR_MESSAGE);
                return;
            }

            userService.updateUserPasswordService(uid, newPassword);
            JOptionPane.showMessageDialog(null, "修改密码成功", "Success", JOptionPane.YES_OPTION);
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
