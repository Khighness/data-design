package com.kag.gui;

import com.kag.service.StaffService;
import com.kag.common.ExceptUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @Description: 查询员工界面
 * @Author: 陈子康
 * @Date: 2020/5/2
 */
public class SearchStaffFrame extends JFrame {

    private JTextField Text_Search = new JTextField();
    private JButton Button_Search = new JButton();
    private JButton Button_Return = new JButton("返回");
    private JTextArea Area_Result = new JTextArea();

    private final ImageIcon BackIcon = new ImageIcon("img/StaffBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StaffLogo.png");
    private final ImageIcon SearchIcon = new ImageIcon("img/SearchButton.png");

    public SearchStaffFrame() {
        super();
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    /**
     * @Description: 设置窗口背景
     */
    private void initFrameBackground() {
        /**
         * 设置背景
         */
        JLabel BackLabel = new JLabel(BackIcon);
        JPanel BackPanel = (JPanel) getContentPane();
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(),BackIcon.getIconHeight());
        BackPanel.setOpaque(false);
        BackPanel.setLayout(new FlowLayout());
        getLayeredPane().setLayout(null);
        getLayeredPane().add(BackLabel, new Integer(Integer.MIN_VALUE));
        /**
         * 设置Logo
         */
        setIconImage(LogoIcon.getImage());
        /**
         * 设置窗体大小
         */
        setBounds(700, 200, BackIcon.getIconWidth(), BackIcon.getIconHeight());

    }

    /**
     * @Description: 设置窗口属性
     */
    private void initFrameProperty() {
        setTitle("查询职员");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
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

    /**
     * @Description: 设置窗口组件
     */
    private void initFrameComponent() {
        add(Text_Search);
        add(Button_Search);
        add(Button_Return);
        add(Area_Result);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        Font font2 = new Font("华文楷体", Font.PLAIN, 18);
        Text_Search.setFont(font1);
        Button_Search.setFont(font2);
        Button_Return.setFont(font2);
        Area_Result.setFont(font2);
        Text_Search.setBounds(130, 70, 288, 30);
        Button_Search.setBounds(418, 70, 30,30);
        Button_Return.setBounds(250, 500, 80, 30);
        Area_Result.setBounds(130, 130, 320, 300);

        Text_Search.setOpaque(false);
        Button_Search.setOpaque(false);
        Button_Return.setOpaque(false);
        Area_Result.setOpaque(false);
        Area_Result.setEditable(false);
        Area_Result.setSelectedTextColor(Color.BLUE);
        Button_Return.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Search.addActionListener(new SearchAction());
        Text_Search.addActionListener(new SearchAction());
        Button_Return.addActionListener(new ReturnAction());

        Button_Search.setIcon(SearchIcon);
        Button_Search.registerKeyboardAction(Button_Search.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0, false),
                JComponent.WHEN_FOCUSED);
        Button_Search.registerKeyboardAction(Button_Search.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0, true),
                JComponent.WHEN_FOCUSED);

        //设置滚动条
        JScrollPane Scroll_Result = new JScrollPane(Area_Result);
        Scroll_Result.setOpaque(false);
        Scroll_Result.getViewport().setOpaque(false);
        getContentPane().add(Scroll_Result);
        Scroll_Result.setBounds(130, 130, 320, 300);
        Scroll_Result.setViewportView(Area_Result);
        TitledBorder SearchBorder = new TitledBorder("Search");
        SearchBorder.setTitleFont(new Font("微软雅黑", Font.PLAIN, 10));
        Scroll_Result.setBorder(SearchBorder);
    }

    class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            int len = Text_Search.getText().length();
//            StaffService staffService = new StaffService();
//            StringBuffer result = new StringBuffer();
//            if (len >= 2 && len <= 4) {
//                //TODO: 查询编号
//                String staffName = Text_Search.getText();
//                result = staffService.queryStaffByNameService(staffName);
//            } else if (len >= 8 && len <= 10){
//                //TODO: 查询姓名
//                int sid = Integer.valueOf(Text_Search.getText());
//                result = staffService.queryStaffByIdService(sid);
//            } else {
//                JOptionPane.showMessageDialog(null, "请输入合法的职员编号或者职员姓名！", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (result.toString().equals("")) {
//                Area_Result.setText("抱歉，未查询到相关职员。\n\r请检查输入的职员编号是否有误。" );
//            } else {
//                Area_Result.setText("—————查询结果如下—————\n\r" + result.toString());
//            }
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SearchStaffFrame();
    }

}
