package com.kag.test;

import com.kag.common.ExceptUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Background {

    private JFrame frame = new JFrame("背景图片测试");

    private JPanel imagePanel;

    private ImageIcon background;

    public static void main(String[] args) throws Exception{
        new Background();
    }

    public Background() throws IOException {
        frame.setLayout(null);


        background = new ImageIcon("img/back3.jpg");// 背景图片
        JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面,把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        imagePanel = (JPanel) frame.getContentPane();// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel.setOpaque(false);
        imagePanel.setLayout(new FlowLayout());// 内容窗格默认的布局管理器为BorderLayout

        JButton button = new JButton("Test");
        button.setBounds(100, 100, 50, 30);
        ImageIcon buttonImg = new ImageIcon("img/bu.png");
        button.setIcon(buttonImg);
        button.setOpaque(false);
        imagePanel.add(button);


        ImageIcon imageIcon = new ImageIcon("img/back3.jpg");
        JLabel imgLabel = new JLabel(imageIcon);
        JPanel testPanel = new JPanel();
        testPanel.setLayout(null);
        testPanel.add(imgLabel);
        testPanel.setVisible(true);

        frame.getLayeredPane().setLayout(null);// 把背景图片添加到分层窗格的最底层作为背景
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 250,background.getIconWidth(), background.getIconHeight());
        frame.setResizable(false);
        frame.setVisible(true);
        BufferedImage logoImage = ImageIO.read(new FileInputStream("img/pharmacy.png"));
        frame.setIconImage(logoImage);
        try {
            //改变按钮样式
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
}
