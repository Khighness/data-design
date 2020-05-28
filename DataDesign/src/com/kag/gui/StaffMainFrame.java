package com.kag.gui;

import com.kag.common.ExceptUtil;
import com.kag.service.MedicineService;
import com.kag.service.StockService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 职员主界面
 * @Author: 陈子康
 * @Date: 2020/5/20
 */
public class StaffMainFrame extends JFrame {

    private int sid;
    private JDesktopPane DesktopPane = new JDesktopPane();
    private final JMenuBar Menu = new JMenuBar();
    private final JMenu Menu_Medicine = new JMenu("药品");
    private final JMenu Menu_Factory = new JMenu("厂家");
    private final JMenu Menu_Client = new JMenu("客户");
    private final JMenu Menu_Ledger = new JMenu("账本");
    private final JMenu Menu_About = new JMenu("关于");
    private final JMenuItem Menu_Medicine_Item_Add = new JMenuItem("增加");
    private final JMenuItem Menu_Medicine_Item_Update = new JMenuItem("更改");
    private final JMenuItem Menu_Medicine_Item_Query = new JMenuItem("查询");
    private final JMenuItem Menu_Medicine_Item_Delete = new JMenuItem("删除");
    private final JMenuItem Menu_Factory_Item_Add = new JMenuItem("增加");
    private final JMenuItem Menu_Factory_Item_Update = new JMenuItem("更改");
    private final JMenuItem Menu_Factory_Item_Query = new JMenuItem("查询");
    private final JMenuItem Menu_Factory_Item_Delete = new JMenuItem("删除");
    private final JMenuItem Menu_Client_Item_Add = new JMenuItem("增加");
    private final JMenuItem Menu_Client_Item_Update = new JMenuItem("更改");
    private final JMenuItem Menu_Client_Item_Query = new JMenuItem("查询");
    private final JMenuItem Menu_Client_Item_Delete = new JMenuItem("删除");
    private final JMenuItem Menu_Ledger_Item_Query = new JMenuItem("查看");
    private final JMenuItem Menu_About_Item_Detail =new JMenuItem("详情");

    private final JButton Button_Purchase = new JButton("进货");
    private final JButton Button_Sale = new JButton("批发");
    private final JButton Button_Retail = new JButton("零售");
    private final JButton Button_Stock = new JButton("库存");
    private final JButton Button_Person = new JButton("个人");
    private final Font Button_Font = new Font("微软雅黑", Font.BOLD, 30);

    private final ImageIcon PurchaseIcon = new ImageIcon("img/PurchaseButton.png");
    private final ImageIcon SaleIcon = new ImageIcon("img/SaleButton.png");
    private final ImageIcon RetailIcon = new ImageIcon("img/RetailButton.png");
    private final ImageIcon ShockIcon = new ImageIcon("img/StockButton.png");
    private final ImageIcon PersonIcon = new ImageIcon("img/PersonButton.png");

    private final Font Font_Menu = new Font("微软雅黑", Font.PLAIN, 20);

    private final ImageIcon BackIcon = new ImageIcon("img/MainBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/SysLogo.png");
    private final ImageIcon TimeIcon = new ImageIcon("img/TimeBack.png");
    private final JPanel TimePanel = new ClockPanel();
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JLabel TimeLabel = new JLabel(TimeIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPanel =   getLayeredPane();

    public StaffMainFrame(int sid) {
        super();
        this.sid = sid;
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
        Menu_Medicine_Item_Add.addActionListener(new AddMedicineAction());
        Menu_Medicine_Item_Update.addActionListener(new UpdateMedicineAction());
        Menu_Medicine_Item_Query.addActionListener(new SearchMedicineAction());
        Menu_Medicine_Item_Delete.addActionListener(new DeleteMedicineAction());
        Menu_Factory_Item_Add.addActionListener(new AddFactoryAction());
        Menu_Client_Item_Add.addActionListener(new AddClientAction());
        Menu_About_Item_Detail.addActionListener(new AboutDetailAction());

        /**
         * @Description: 按钮
         */
        add(Button_Purchase);
        add(Button_Sale);
        add(Button_Retail);
        add(Button_Stock);
        add(Button_Person);
        int X = 50, Y_FIRST = 120, Y_DISTANCE = 100;
        Button_Purchase.setBounds(X, Y_FIRST, 150, 50);
        Button_Sale.setBounds(X, Y_FIRST + 1 * Y_DISTANCE, 150, 50);
        Button_Retail.setBounds(X, Y_FIRST + 2 * Y_DISTANCE, 150, 50);
        Button_Stock.setBounds(X, Y_FIRST + 3 * Y_DISTANCE, 150, 50);
        Button_Person.setBounds(X, Y_FIRST + 4 * Y_DISTANCE, 150, 50);
        Button_Purchase.setIcon(PurchaseIcon);
        Button_Sale.setIcon(SaleIcon);
        Button_Retail.setIcon(RetailIcon);
        Button_Stock.setIcon(ShockIcon);
        Button_Person.setIcon(PersonIcon);
        Button_Purchase.setOpaque(false);
        Button_Sale.setOpaque(false);
        Button_Retail.setOpaque(false);
        Button_Stock.setOpaque(false);
        Button_Person.setOpaque(false);
        Button_Purchase.setFont(Button_Font);
        Button_Sale.setFont(Button_Font);
        Button_Retail.setFont(Button_Font);
        Button_Stock.setFont(Button_Font);
        Button_Person.setFont(Button_Font);
        Button_Purchase.setForeground(Color.BLACK);
        Button_Sale.setForeground(Color.BLACK);
        Button_Retail.setForeground(Color.BLACK);
        Button_Stock.setForeground(Color.BLACK);
        Button_Person.setForeground(Color.BLACK);
        Button_Purchase.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Sale.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Retail.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Stock.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Person.setBorder(BorderFactory.createRaisedBevelBorder());
        Button_Purchase.addActionListener(new PurchaseAction());
        Button_Sale.addActionListener(new SaleAction());
        Button_Retail.addActionListener(new RetailAction());
        Button_Stock.addActionListener(new StockAction());
        Button_Person.addActionListener(new PersonAction());

        /**
         * @Description: 时间
         */
        LayeredPanel.add(TimePanel);
        TimePanel.setLocation(this.getWidth() - TimePanel.getWidth() - 5, this.getHeight() - TimePanel.getHeight() - 40);
    }

    /**
     * @Description: 增加药品
     */
    class AddMedicineAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAddMedicineFrame());
        }
    }

    /**
     * @Description: 修改药品
     */
    class UpdateMedicineAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mid = JOptionPane.showInputDialog("请输入需要修改的药品编号");
            if (mid.length() < 8 || mid.length() > 10) {
                JOptionPane.showMessageDialog(null, "药品编号应该在8~10位之间", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < mid.length(); i++) {
                if (!Character.isDigit(mid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "药品编号非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            MedicineService medicineService = new MedicineService();
            if (medicineService.queryMedicineByIdService(Integer.valueOf(mid)) == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            add(new InnerUpdateMedicineFrame(Integer.valueOf(mid)));
        }
    }

    /**
     * @Description: 搜索药品
     */
    class SearchMedicineAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerSearchMedicineFrame());
        }
    }

    /**
     * @Description: 删除药品
     */
    class DeleteMedicineAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mid = JOptionPane.showInputDialog("请输入需要删除的药品编号");
            if (mid.length() < 8 || mid.length() > 10) {
                JOptionPane.showMessageDialog(null, "药品编号应该在8~10位之间", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < mid.length(); i++) {
                if (!Character.isDigit(mid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "药品编号非法", "Medicine id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            MedicineService medicineService = new MedicineService();
            if (medicineService.queryMedicineByIdService(Integer.valueOf(mid)) == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int Mid = Integer.valueOf(mid);
            medicineService.deleteMedicineService(Mid);
        }
    }

    /**
     * @Description: 增加厂家
     */
    class AddFactoryAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAddFactoryFrame());
        }
    }

    /**
     * @Description: 增加客户
     */
    class AddClientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAddClientFrame());
        }
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
    class PurchaseAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            InnerPurchaseFrame innerPurchaseFrame = new InnerPurchaseFrame(sid);
            add(innerPurchaseFrame.InnerPurchaseMainFrame);
        }
    }

    /**
     * @Description: 批发
     */
    class SaleAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            InnerSaleFrame innerSaleFrame = new InnerSaleFrame(sid);
            add(innerSaleFrame.InnerSaleMainFrame);
        }
    }

    /**
     * @Description: 零售
     */
    class RetailAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerRetailFrame(sid));
        }
    }

    /**
     * @Description: 库存
     */
    class StockAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new InnerStockFrame(DesktopPane);
        }
    }

    /**
     * @Description: 个人
     */
    class PersonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerStaffFrame(sid, DesktopPane));
        }
    }

    public static void main(String[] args) {
        new StaffMainFrame(20200001);
    }

}
