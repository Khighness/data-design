package com.kag.gui;

import com.kag.common.ExceptUtil;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 主界面
 * @Author: 陈子康
 * @Date: 2020/5/20
 */
public class MainFrame extends JFrame {

    private String staffName;
    private JDesktopPane DesktopPane = new JDesktopPane();

    private JMenuBar Menu = new JMenuBar();
    private JMenu Menu_Medicine = new JMenu("药品");
    private JMenu Menu_Factory = new JMenu("厂家");
    private JMenu Menu_Client = new JMenu("客户");
    private JMenu Menu_Ledger = new JMenu("账本");
    private JMenu Menu_About = new JMenu("关于");
    private JMenuItem Menu_Medicine_Item_Add = new JMenuItem("增加");
    private JMenuItem Menu_Medicine_Item_Update = new JMenuItem("更改");
    private JMenuItem Menu_Medicine_Item_Query = new JMenuItem("查询");
    private JMenuItem Menu_Medicine_Item_Delete = new JMenuItem("删除");
    private JMenuItem Menu_Factory_Item_Add = new JMenuItem("增加");
    private JMenuItem Menu_Factory_Item_Update = new JMenuItem("更改");
    private JMenuItem Menu_Factory_Item_Query = new JMenuItem("查询");
    private JMenuItem Menu_Factory_Item_Delete = new JMenuItem("删除");
    private JMenuItem Menu_Client_Item_Add = new JMenuItem("增加");
    private JMenuItem Menu_Client_Item_Update = new JMenuItem("更改");
    private JMenuItem Menu_Client_Item_Query = new JMenuItem("查询");
    private JMenuItem Menu_Client_Item_Delete = new JMenuItem("删除");
    private JMenuItem Menu_Ledger_Item_Query = new JMenuItem("查看");
    private JMenuItem Menu_About_Item_Detail =new JMenuItem("详情");

    private final JButton Button_Purchase = new JButton("进货");
    private final JButton Button_Sale = new JButton("批发");
    private final JButton Button_Retail = new JButton("零售");
    private final JButton Button_Shock = new JButton("库存");
    private final JButton Button_Person = new JButton("个人");
    private final Font Button_Font = new Font("微软雅黑", Font.BOLD, 30);

    private final ImageIcon PurchaseIcon = new ImageIcon("img/PurchaseButton.png");
    private final ImageIcon SaleIcon = new ImageIcon("img/SaleButton.png");
    private final ImageIcon RetailIcon = new ImageIcon("img/RetailButton.png");
    private final ImageIcon ShockIcon = new ImageIcon("img/ShockButton.png");
    private final ImageIcon PersonIcon = new ImageIcon("img/PersonButton.png");

    private final Font Font_Menu = new Font("微软雅黑", Font.PLAIN, 20);

    private final ImageIcon BackIcon = new ImageIcon("img/MainBack5.png");
    //private final ImageIcon BackImage = new ImageIcon("img/MainBack.jpg");
    private final ImageIcon LogoIcon = new ImageIcon("img/SysLogo.png");
    private final ImageIcon TimeIcon = new ImageIcon("img/TimeBack.png");
    private final JPanel TimePanel = new ClockPanel();
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JLabel TimeLabel = new JLabel(TimeIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPanel =   getLayeredPane();

    public MainFrame() {
        super();
        initFrameBackground();
        initFrameProperty();
        initFrameComponent();
    }

    /**
     * @Description: 设置窗口图片
     */
    private void initFrameBackground() {
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        DesktopPane.setLayout(null);
        DesktopPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
        TimeLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        TimeLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        DesktopPane.add(TimeLabel);
        TimeLabel.setBounds(BackIcon.getIconWidth() - TimeIcon.getIconWidth() - 10, BackIcon.getIconHeight() - TimeIcon.getIconHeight() - 70, TimeIcon.getIconWidth(), TimeIcon.getIconHeight()
        );
    }

    /**
     * @Description: 设置窗口属性
     */
    private void initFrameProperty() {
        setTitle("药品进销存管理系统");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setJMenuBar(Menu);
        setContentPane(DesktopPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LogoIcon.getImage());
        setBounds(400,130, BackIcon.getIconWidth(), BackIcon.getIconHeight());
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

    private void initFrameComponent() {

        /**
         * @Description: 导航栏
         */
        Menu.setOpaque(false);
        Menu_Medicine.setFont(Font_Menu);
        Menu_Factory.setFont(Font_Menu);
        Menu_Client.setFont(Font_Menu);
        Menu_Ledger.setFont(Font_Menu);
        Menu_About.setFont(Font_Menu);
        Menu_Medicine_Item_Add.setFont(Font_Menu);
        Menu_Medicine_Item_Update.setFont(Font_Menu);
        Menu_Medicine_Item_Query.setFont(Font_Menu);
        Menu_Medicine_Item_Delete.setFont(Font_Menu);
        Menu_Client_Item_Add.setFont(Font_Menu);
        Menu_Client_Item_Update.setFont(Font_Menu);
        Menu_Client_Item_Query.setFont(Font_Menu);
        Menu_Client_Item_Delete.setFont(Font_Menu);
        Menu_Factory_Item_Add.setFont(Font_Menu);
        Menu_Factory_Item_Update.setFont(Font_Menu);
        Menu_Factory_Item_Query.setFont(Font_Menu);
        Menu_Factory_Item_Delete.setFont(Font_Menu);
        Menu_Ledger_Item_Query.setFont(Font_Menu);
        Menu_About_Item_Detail.setFont(Font_Menu);
        Menu.add(Menu_Medicine);
        Menu.add(Menu_Factory);
        Menu.add(Menu_Client);
        Menu.add(Menu_Ledger);
        Menu.add(Menu_About);
        Menu_Medicine.add(Menu_Medicine_Item_Add);
        Menu_Medicine.add(Menu_Medicine_Item_Update);
        Menu_Medicine.add(Menu_Medicine_Item_Query);
        Menu_Medicine.add(Menu_Medicine_Item_Delete);
        Menu_Factory.add(Menu_Factory_Item_Add);
        Menu_Factory.add(Menu_Factory_Item_Update);
        Menu_Factory.add(Menu_Factory_Item_Query);
        Menu_Factory.add(Menu_Factory_Item_Delete);
        Menu_Client.add(Menu_Client_Item_Add);
        Menu_Client.add(Menu_Client_Item_Update);
        Menu_Client.add(Menu_Client_Item_Query);
        Menu_Client.add(Menu_Client_Item_Delete);
        Menu_Ledger.add(Menu_Ledger_Item_Query);
        Menu_About.add(Menu_About_Item_Detail);
        Menu_Medicine_Item_Add.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, Event.CTRL_MASK));
        Menu_Medicine_Item_Update.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, Event.CTRL_MASK));
        Menu_Medicine_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, Event.CTRL_MASK));
        Menu_Medicine_Item_Delete.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, Event.CTRL_MASK));
        Menu_Factory_Item_Add.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, Event.SHIFT_MASK));
        Menu_Factory_Item_Update.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, Event.SHIFT_MASK));
        Menu_Factory_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, Event.SHIFT_MASK));
        Menu_Factory_Item_Delete.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, Event.SHIFT_MASK));
        Menu_Client_Item_Add.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, Event.ALT_MASK));
        Menu_Client_Item_Update.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, Event.ALT_MASK));
        Menu_Client_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, Event.ALT_MASK));
        Menu_Client_Item_Delete.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, Event.ALT_MASK));
        Menu_Ledger_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, Event.ENTER));
        Menu_About_Item_Detail.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.Event.CTRL_MASK));
        Menu_About_Item_Detail.addActionListener(new AboutDetailAction());

        /**
         * @Description: 按钮
         */
        add(Button_Purchase);
        add(Button_Sale);
        add(Button_Retail);
        add(Button_Shock);
        add(Button_Person);
        int X = 50, Y_FIRST = 120, Y_DISTANCE = 100;
        Button_Purchase.setBounds(X, Y_FIRST, 150, 50);
        Button_Sale.setBounds(X, Y_FIRST + 1 * Y_DISTANCE, 150, 50);
        Button_Retail.setBounds(X, Y_FIRST + 2 * Y_DISTANCE, 150, 50);
        Button_Shock.setBounds(X, Y_FIRST + 3 * Y_DISTANCE, 150, 50);
        Button_Person.setBounds(X, Y_FIRST + 4 * Y_DISTANCE, 150, 50);
        Button_Purchase.setIcon(PurchaseIcon);
        Button_Sale.setIcon(SaleIcon);
        Button_Retail.setIcon(RetailIcon);
        Button_Shock.setIcon(ShockIcon);
        Button_Person.setIcon(PersonIcon);
        Button_Purchase.setOpaque(false);
        Button_Sale.setOpaque(false);
        Button_Retail.setOpaque(false);
        Button_Shock.setOpaque(false);
        Button_Person.setOpaque(false);
        Button_Purchase.setFont(Button_Font);
        Button_Sale.setFont(Button_Font);
        Button_Retail.setFont(Button_Font);
        Button_Shock.setFont(Button_Font);
        Button_Person.setFont(Button_Font);
        Button_Purchase.setForeground(Color.BLACK);
        Button_Sale.setForeground(Color.BLACK);
        Button_Retail.setForeground(Color.BLACK);
        Button_Shock.setForeground(Color.BLACK);
        Button_Person.setForeground(Color.BLACK);
        Button_Purchase.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Sale.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Retail.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Shock.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Person.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Person.addActionListener(new AddStaffAction());
        Button_Purchase.addActionListener(new PurchaseAction());

        /**
         * @Description: 时间
         */
        LayeredPanel.add(TimePanel);
        TimePanel.setLocation(this.getWidth() - TimePanel.getWidth() - 5, this.getHeight() - TimePanel.getHeight() - 35);
    }

    /**
     * @Description: 添加职员
     */
    class AddStaffAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAddStaffFrame());
        }
    }

    /**
     * @Description: 关于
     */
    class AboutDetailAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AboutDialogFrame();
        }
    }

    /**
     * @Description: 进货
     */
    class PurchaseAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InnerPurchaseFrame purchaseFrame = new InnerPurchaseFrame();
            purchaseFrame.Button_Sure.addActionListener(new PurchaseSureButtonAction());
            DesktopPane.add(purchaseFrame);
        }
    }

    class PurchaseSureButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new InnerPurchaseFrame();
        }
    }



    public static void main(String[] args) {
        new MainFrame();
    }



}
