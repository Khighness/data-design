package com.kag.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @Description: 内部个人菜单
 * @Author: 陈子康
 * @Date: 2020/5/26
 */
public class InnerPersonMenuFrame extends JInternalFrame {

    public final JButton Button_PersonInfo = new JButton("我的信息");
    public final JButton Button_UpdateInfo = new JButton("更改信息");
    public final JButton Button_UpdateWord = new JButton("修改密码");
    public final JButton Button_Logout = new JButton("退出登陆");
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/PersonMenuBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/PersonLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();


    public InnerPersonMenuFrame() {
        initInnerFrameBackground();
        initInnerFrameProperty();
        initInnerFrameComponent();
    }

    private void initInnerFrameBackground() {
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
    }

    private void initInnerFrameProperty() {
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("个人");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Button_PersonInfo);
        add(Button_UpdateInfo);
        add(Button_Logout);
        add(Button_UpdateWord);
        Button_PersonInfo.setFont(Font_Button);
        Button_UpdateInfo.setFont(Font_Button);
        Button_UpdateWord.setFont(Font_Button);
        Button_Logout.setFont(Font_Button);
        Button_PersonInfo.setBounds(70, 10, 120, 30);
        Button_UpdateInfo.setBounds(70, 50, 120, 30);
        Button_UpdateWord.setBounds(70, 90, 120, 30);
        Button_Logout.setBounds(70, 130, 120, 30);
    }
}