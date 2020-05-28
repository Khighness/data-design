package com.kag.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyDialog extends JDialog {
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("input");
        final JTextArea area = new JTextArea();
        frame.add(new JScrollPane(area));
        frame.add(button,BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String s = MyDialog.showInputDlg(frame);
                if(s!=null)
                    area.append(s);
            }
        });
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    private MyDialog() {
        setModal(true);//当对话框显示时候其他窗口不能获得焦点
        field = new JTextField(10);
        final JButton ok = new JButton("Ok");
        final JButton cancel = new JButton("Cancel");
        add(field);
        JPanel panel = new JPanel();
        panel.add(ok);
        panel.add(cancel);
        add(panel,BorderLayout.SOUTH);
        ActionListener lst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==ok)
                    ret = field.getText();
                else if(e.getSource()==cancel)
                    ret = null;
                setVisible(false);
            }
        };
        ok.addActionListener(lst);
        cancel.addActionListener(lst);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                ret = null;//除了点击cancel按钮外，关闭对话框时也视作取消
            }
        });
        pack();
        setResizable(false);
    }
    public static String showInputDlg(Component comp) {
        instance.field.setText(null);
        instance.setLocationRelativeTo(comp);//使得对话框显示在comp的中间
        instance.setVisible(true);//显示对话框时候，调用它的线程被阻塞
        return instance.ret;//直到对话框不显示时才返回，而时候ret已经被设置好了
    }
    private static MyDialog instance = new MyDialog();
    private String ret;
    private JTextField field;
}

