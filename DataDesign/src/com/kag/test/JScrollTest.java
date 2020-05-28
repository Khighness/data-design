package com.kag.test;

import javax.swing.*;
import java.awt.*;

public class JScrollTest extends JFrame{

    public JScrollTest()
    {
        this.setLayout(null);
        JPanel jp=new JPanel();
        jp.setPreferredSize(new Dimension(200,100));
        JScrollPane sp=new JScrollPane(jp);
        this.setBounds(100,100,300,200);
        sp.setBounds(10,10,175,70);
        this.getContentPane().add(sp);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollTest();
    }

}

