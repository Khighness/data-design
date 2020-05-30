package com.kag.gui;

import com.kag.common.ColorUtil;
import com.kag.common.ExceptUtil;
import com.kag.entity.Client;
import com.kag.entity.Factory;
import com.kag.entity.Medicine;
import com.kag.entity.Staff;
import com.kag.service.ClientService;
import com.kag.service.FactoryService;
import com.kag.service.MedicineService;
import com.kag.service.StaffService;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 管理员主界面
 * @Author: 陈子康
 * @Date: 2020/5/20
 */
public class AdminMainFrame extends JFrame {

    private int uid;
    private JDesktopPane DesktopPane = new JDesktopPane();
    private final JMenuBar Menu = new JMenuBar();
    private final JMenu Menu_Staff = new JMenu("职员");
    private final JMenu Menu_Medicine = new JMenu("药品");
    private final JMenu Menu_Factory = new JMenu("厂家");
    private final JMenu Menu_Client = new JMenu("客户");
    private final JMenu Menu_Ledger = new JMenu("账本");
    private final JMenu Menu_Person = new JMenu("个人");
    private final JMenu Menu_About = new JMenu("关于");
    private final JMenuItem Menu_Staff_Item_Add = new JMenuItem("增加");
    private final JMenuItem Menu_Staff_Item_Query = new JMenuItem("查询");
    private final JMenuItem Menu_Staff_Item_Depart = new JMenuItem("离职");
    private final JMenuItem Menu_Staff_Item_Delete = new JMenuItem("删除");
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
    private final JMenuItem Menu_Person_Query_Info = new JMenuItem("我的信息");
    private final JMenuItem Menu_Person_Update_Info = new JMenuItem("修改信息");
    private final JMenuItem Menu_Person_Update_Word = new JMenuItem("修改密码");
    private final JMenuItem Menu_Person_Logout = new JMenuItem("退出登录");
    private final JMenuItem Menu_About_Item_Detail =new JMenuItem("详情");
    private final Font Font_Menu = new Font("微软雅黑", Font.PLAIN, 20);

    private final ImageIcon BackIcon = new ImageIcon("img/AdminMainBack.jpg");
    private final ImageIcon LogoIcon = new ImageIcon("img/SysLogo.png");
    private final ImageIcon TimeIcon = new ImageIcon("img/TimeBack.png");
    private final JPanel TimePanel = new ClockPanel();
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JLabel TimeLabel = new JLabel();
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPanel =   getLayeredPane();

    public AdminMainFrame(int uid) {
        super();
        this.uid = uid;
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
        TimeLabel.setBackground(ColorUtil.color6);
        DesktopPane.add(TimeLabel);
        TimeLabel.setBounds(BackIcon.getIconWidth() - TimeIcon.getIconWidth() - 10, BackIcon.getIconHeight() - TimeIcon.getIconHeight() - 70, TimeIcon.getIconWidth(), TimeIcon.getIconHeight());
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
        Menu.setOpaque(false);
        Menu_Staff.setFont(Font_Menu);
        Menu_Medicine.setFont(Font_Menu);
        Menu_Factory.setFont(Font_Menu);
        Menu_Client.setFont(Font_Menu);
        Menu_Ledger.setFont(Font_Menu);
        Menu_Person.setFont(Font_Menu);
        Menu_About.setFont(Font_Menu);
        Menu_Staff_Item_Add.setFont(Font_Menu);
        Menu_Staff_Item_Query.setFont(Font_Menu);
        Menu_Staff_Item_Depart.setFont(Font_Menu);
        Menu_Staff_Item_Delete.setFont(Font_Menu);
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
        Menu_Person_Query_Info.setFont(Font_Menu);
        Menu_Person_Update_Info.setFont(Font_Menu);
        Menu_Person_Update_Word.setFont(Font_Menu);
        Menu_Person_Logout.setFont(Font_Menu);
        Menu_About_Item_Detail.setFont(Font_Menu);
        Menu.add(Menu_Staff);
        Menu.add(Menu_Medicine);
        Menu.add(Menu_Factory);
        Menu.add(Menu_Client);
        Menu.add(Menu_Ledger);
        Menu.add(Menu_Person);
        Menu.add(Menu_About);
        Menu_Staff.add(Menu_Staff_Item_Add);
        Menu_Staff.add(Menu_Staff_Item_Query);
        Menu_Staff.add(Menu_Staff_Item_Depart);
        Menu_Staff.add(Menu_Staff_Item_Delete);
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
        Menu_Person.add(Menu_Person_Query_Info);
        Menu_Person.add(Menu_Person_Update_Info);
        Menu_Person.add(Menu_Person_Update_Word);
        Menu_Person.add(Menu_Person_Logout);
        Menu_About.add(Menu_About_Item_Detail);

        Menu_Staff_Item_Add.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, Event.ALT_MASK));
        Menu_Staff_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, Event.ALT_MASK));
        Menu_Staff_Item_Depart.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, Event.ALT_MASK));
        Menu_Staff_Item_Delete.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, Event.ALT_MASK));
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
        Menu_Ledger_Item_Query.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, Event.CTRL_MASK));
        Menu_Person_Query_Info.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, Event.CTRL_MASK));
        Menu_Person_Update_Info.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, Event.CTRL_MASK));
        Menu_Person_Update_Word.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, Event.CTRL_MASK));
        Menu_Person_Logout.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, Event.CTRL_MASK));
        Menu_About_Item_Detail.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.Event.CTRL_MASK));
        Menu_Staff_Item_Add.addActionListener(new AddStaffAction());
        Menu_Staff_Item_Query.addActionListener(new SearchStaffAction());
        Menu_Staff_Item_Depart.addActionListener(new DepartStaffAction());
        Menu_Staff_Item_Delete.addActionListener(new DeleteStaffAction());
        Menu_Medicine_Item_Add.addActionListener(new AddMedicineAction());
        Menu_Medicine_Item_Update.addActionListener(new UpdateMedicineAction());
        Menu_Medicine_Item_Query.addActionListener(new SearchMedicineAction());
        Menu_Medicine_Item_Delete.addActionListener(new DeleteMedicineAction());
        Menu_Factory_Item_Add.addActionListener(new AddFactoryAction());
        Menu_Factory_Item_Update.addActionListener(new UpdateFactoryAction());
        Menu_Factory_Item_Query.addActionListener(new QueryFactoryAction());
        Menu_Factory_Item_Delete.addActionListener(new DeleteFactoryAction());
        Menu_Client_Item_Add.addActionListener(new AddClientAction());
        Menu_Client_Item_Update.addActionListener(new UpdateClientAction());
        Menu_Client_Item_Query.addActionListener(new QueryClientAction());
        Menu_Client_Item_Delete.addActionListener(new DeleteClientAction());
        Menu_Ledger_Item_Query.addActionListener(new LookLedgerAction());
        Menu_Person_Query_Info.addActionListener(new PersonInfoAction());
        Menu_Person_Update_Info.addActionListener(new UpdateInfoAction());
        Menu_Person_Update_Word.addActionListener(new UpdateWordAction());
        Menu_Person_Logout.addActionListener(new LogoutAction());
        Menu_About_Item_Detail.addActionListener(new AboutDetailAction());

        LayeredPanel.add(TimePanel);
        TimePanel.setLocation(this.getWidth() - TimePanel.getWidth() - 5, this.getHeight() - TimePanel.getHeight() - 40);
    }

    /**
     * @Description: 增加职员
     */
    class AddStaffAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAddStaffFrame());
        }
    }

    /**
     * @Description: 查询职员
     */
    class SearchStaffAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerSearchStaffFrame());
        }
    }

    /**
     * @Description: 职员离职
     */
    class DepartStaffAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sid = JOptionPane.showInputDialog("请输入离职职员的编号");
            if (sid.length() < 8 || sid.length() > 10) {
                JOptionPane.showMessageDialog(null, "职员编号应该在8~10位之间", "Staff id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < sid.length(); i++) {
                if (!Character.isDigit(sid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "职员编号非法", "Staff id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int Sid = Integer.valueOf(sid);
            StaffService staffService = new StaffService();
            if (staffService.queryStaffByIdService(Sid) == null) {
                JOptionPane.showMessageDialog(null, "职员不存在", "Staff exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            staffService.departureService(Sid);
            JOptionPane.showMessageDialog(null, "设置职员离职成功", "Success ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * @Description: 删除职员
     */
    class DeleteStaffAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sid = JOptionPane.showInputDialog("请输入离职职员的编号");
            if (sid.length() < 8 || sid.length() > 10) {
                JOptionPane.showMessageDialog(null, "职员编号应该在8~10位之间", "Staff id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < sid.length(); i++) {
                if (!Character.isDigit(sid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "职员编号非法", "Staff id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int Sid = Integer.valueOf(sid);
            StaffService staffService = new StaffService();
            if (staffService.queryStaffByIdService(Sid) == null) {
                JOptionPane.showMessageDialog(null, "职员不存在", "Staff exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            staffService.deleteStaffService(Sid);
            JOptionPane.showMessageDialog(null, "删除职员成功", "Success ", JOptionPane.INFORMATION_MESSAGE);
        }
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
            int Mid = Integer.valueOf(mid);
            MedicineService medicineService = new MedicineService();
            Medicine medicine = medicineService.queryMedicineByIdService(Mid);
            if (medicine == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            add(new InnerUpdateMedicineFrame(medicine));
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
            int Mid = Integer.valueOf(mid);
            MedicineService medicineService = new MedicineService();
            Medicine medicine = medicineService.queryMedicineByIdService(Mid);
            if (medicine == null) {
                JOptionPane.showMessageDialog(null, "药品不存在", "Medicine exist Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            medicineService.deleteMedicineService(Mid);
            JOptionPane.showMessageDialog(null, "删除药品信息成功", "Success", JOptionPane.INFORMATION_MESSAGE);
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
     * @Description: 修改厂家
     */
    class UpdateFactoryAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fid = JOptionPane.showInputDialog("请输入需要修改的厂家编号");
            if (fid.length() < 8 || fid.length() > 10) {
                JOptionPane.showMessageDialog(null, "厂家编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < fid.length(); i++) {
                if (!Character.isDigit(fid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "厂家编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int Fid = Integer.valueOf(fid);
            FactoryService factoryService = new FactoryService();
            Factory factory = factoryService.queryFactoryByIdService(Fid);
            if (factory == null) {
                JOptionPane.showMessageDialog(null, "厂家不存在", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            add(new InnerUpdateFactoryFrame(factory));
        }
    }

    /**
     * @Description: 查询厂家
     */
    class QueryFactoryAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerSearchFactoryFrame());
        }
    }

    /**
     * @Description: 删除厂家
     */
    class DeleteFactoryAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fid = JOptionPane.showInputDialog("请输入需要删除的厂家编号");
            if (fid.length() < 8 || fid.length() > 10) {
                JOptionPane.showMessageDialog(null, "厂家编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < fid.length(); i++) {
                if (!Character.isDigit(fid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "厂家编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int Fid = Integer.valueOf(fid);
            FactoryService factoryService = new FactoryService();
            Factory factory = factoryService.queryFactoryByIdService(Fid);
            if (factory == null) {
                JOptionPane.showMessageDialog(null, "厂家不存在", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            factoryService.deleteFactoryService(Fid);
            JOptionPane.showMessageDialog(null, "删除厂家信息成功", "Success", JOptionPane.INFORMATION_MESSAGE);
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
     * @Description: 修改客户
     */
    class UpdateClientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cid = JOptionPane.showInputDialog("请输入需要修改的客户编号");
            if (cid.length() < 8 || cid.length() > 10) {
                JOptionPane.showMessageDialog(null, "客户编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < cid.length(); i++) {
                if (!Character.isDigit(cid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "客户编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int Cid = Integer.valueOf(cid);
            ClientService clientService = new ClientService();
            Client client = clientService.queryClientByIdService(Cid);
            if (client == null) {
                JOptionPane.showMessageDialog(null, "客户不存在", "Client id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            add(new InnerUpdateClientFrame(client));
        }
    }

    /**
     * @Description: 查询客户
     */
    class QueryClientAction implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerSearchClientFrame());
        }
    }

    /**
     * @Description: 删除客户
     */
    class DeleteClientAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cid = JOptionPane.showInputDialog("请输入需要修改的客户编号");
            if (cid.length() < 8 || cid.length() > 10) {
                JOptionPane.showMessageDialog(null, "客户编号应该在8~10位之间", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < cid.length(); i++) {
                if (!Character.isDigit(cid.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "客户编号非法", "Factory id Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int Cid = Integer.valueOf(cid);
            ClientService clientService = new ClientService();
            Client client = clientService.queryClientByIdService(Cid);
            if (client == null) {
                JOptionPane.showMessageDialog(null, "客户不存在", "Client id Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            clientService.deleteClientService(Cid);
        }
    }

    /**
     * @Description: 查看账本
     */
    class LookLedgerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerLedgerFrame());
        }
    }

    /**
     * @Description: 个人信息
     */
    class PersonInfoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerAdminInfoFrame(uid));
        }
    }

    /**
     * @Description: 修改信息
     */
    class UpdateInfoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerUpdateAdminInfoFrame(uid));
        }
    }

    /**
     * @Description: 修改密码
     */
    class UpdateWordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            add(new InnerUpdateAdminWordFrame(uid));
        }
    }

    /**
     * @Description: 退出登录
     */
    class LogoutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

    /**
     * @Description: 关于详情
     */
    class AboutDetailAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AboutDialogFrame();
        }
    }

}
