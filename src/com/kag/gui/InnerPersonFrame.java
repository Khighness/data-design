package com.kag.gui;

import com.kag.common.ExceptUtil;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

public class InnerPersonFrame extends JInternalFrame {

    private final ImageIcon BackIcon = new ImageIcon("img/StaffBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerPersonFrame()  {
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
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        setTitle("个人");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
    }

    private void initInnerFrameComponent() {

    }

}

