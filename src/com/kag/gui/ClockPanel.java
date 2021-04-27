package com.kag.gui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @Description: 时间画布
 * @Author: 陈子康
 * @Date: 2020/5/20
 */
public class ClockPanel extends JPanel{

    private final JLabel ShowLabel = new JLabel();
    private final Font Font_Label = new Font("微软雅黑", Font.PLAIN, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/TimeBack.png");
    private String DTF = "yyyy-MM-dd HH:mm:ss";
    private String time;
    private int ONE_SECOND =1000;

    public ClockPanel() {
        setLayout(null);
        setOpaque(false);
        setSize(190, 25);
        add(ShowLabel);
        ShowLabel.setFont(Font_Label);
        ShowLabel.setBounds(0,0, 190, 25);
        configTimeArea();
    }

    private void configTimeArea() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);
    }

    protected class JLabelTimerTask extends TimerTask {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DTF);
        @Override
        public void run() {
            time = dateFormatter.format(Calendar.getInstance().getTime());
            ShowLabel.setText(time);
        }
    }
}

