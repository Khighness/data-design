package com.kag.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutDialogFrame extends JDialog {
    private ImageIcon AboutIcon = new ImageIcon("img/AboutDetail.png");
    private ImageIcon LogoIcon = new ImageIcon("img/AboutLogo.png");
    private JLabel AboutLabel = new JLabel(AboutIcon);
    private JButton Button_Sure = new JButton("确定");
    private JPanel ContentPanel = (JPanel) getContentPane();
    private JLayeredPane LayeredPane = getLayeredPane();

    public AboutDialogFrame() {
        setTitle("关于");
        setVisible(true);
        setResizable(false);
        setIconImage(LogoIcon.getImage());
        setBounds(700, 200, AboutIcon.getIconWidth() + 10, AboutIcon.getIconHeight() + 70);
        AboutLabel.setBounds(0, 0, AboutIcon.getIconWidth(), AboutIcon.getIconHeight());
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        LayeredPane.add(AboutLabel, new Integer(Integer.MIN_VALUE));
        setLayout(null);
        add(Button_Sure);
        Button_Sure.setBounds(AboutIcon.getIconWidth() - 80, AboutIcon.getIconHeight() + 5, 80, 30);
        Button_Sure.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Button_Sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }
}
