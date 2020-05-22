package com.kag.test;

import javax.swing.*;
import java.awt.*;

public class PanelImage  {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Panel");
        frame.setBounds(300, 200, 300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(new FlowLayout());
        panel.setOpaque(false);
        ImageIcon imageIcon = new ImageIcon("img/bu.png");
        JLabel imgLabel = new JLabel(imageIcon);
        panel.add(imgLabel);
        panel.add(panel);
        frame.add(imgLabel);
    }

}
