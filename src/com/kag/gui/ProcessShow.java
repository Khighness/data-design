package com.kag.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessShow extends JFrame{

    private int type;
    private int id;
    private static final int MIN_PROGRESS = 0;
    private static final int MAX_PROGRESS = 100;
    private static int currentProgress = MIN_PROGRESS;
    private final  JPanel panel = new JPanel();
    private final JLabel Label_Load = new JLabel("Loading......");
    private final JProgressBar progressBar = new JProgressBar();

    public ProcessShow(int type, int id) {
        this.type = type;
        this.id = id;

        // 设置窗口和画布属性
        setUndecorated(true);
        panel.setLayout(null);

        // 设置大小和位置
        setBounds(800, 400, 250, 90);
        Label_Load.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        Label_Load.setBounds(80, 10, 120, 30);
        progressBar.setBounds(10, 50, 230, 30);

        progressBar.setBackground(new Color(0,205,205));
        // 设置进度的最小值和最大值
        progressBar.setMinimum(MIN_PROGRESS);
        progressBar.setMaximum(MAX_PROGRESS);
        // 设置当前进度值
        progressBar.setValue(currentProgress);
        // 绘制百分比文本（进度条中间显示的百分数）
        progressBar.setStringPainted(true);
        // 添加到内容面板
        panel.add(Label_Load);
        panel.add(progressBar);
        setContentPane(panel);
        setVisible(true);

        // 模拟延时操作进度
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentProgress++;
                if (currentProgress > MAX_PROGRESS) {
                    currentProgress = MIN_PROGRESS;
                }
                progressBar.setValue(currentProgress);
            }
        });
        timer.start();

        // 进度条满
        progressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (progressBar.getValue() == 100) {
                    setVisible(false);
                    timer.stop();
                    if (type == 1) {
                        new AdminMainFrame(id);
                    } else {
                        new StaffMainFrame(id);
                    }
                }
            }
        });

    }

}
