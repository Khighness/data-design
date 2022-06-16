package com.kag.gui;

import com.kag.common.TimeUtil;
import com.kag.entity.Medicine;
import com.kag.entity.Staff;
import com.kag.service.MedicineService;
import com.kag.service.StaffService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @apiNote 内部药品查询界面(根据ID或者药名)
 * @author KHighness
 * @since 2020/5/26
 */
public class InnerSearchStaffFrame extends JInternalFrame {

    public final JTextField Text_Search = new JTextField();
    public final JTextArea Area_Result = new JTextArea();
    public final JButton Button_Search = new JButton();
    public final JButton Button_Return = new JButton();
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Area = new Font("华文楷体", Font.PLAIN, 18);

    private final ImageIcon BackIcon = new ImageIcon("img/SearchBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/SearchLogo.png");
    private final ImageIcon SearchIcon = new ImageIcon("img/SearchButton.png");
    private final ImageIcon ReturnIcon = new ImageIcon("img/ReturnButton.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();


    public InnerSearchStaffFrame() {
        initInnerFrameBackground();
        initInnerFrameProperty();
        initInnerFrameComponent();
    }

    private void initInnerFrameBackground() {
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(new FlowLayout());
        LayeredPane.setLayout(null);
        BackLabel.setBounds(0, 0, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        LayeredPane.add(BackLabel, new Integer(Integer.MIN_VALUE));
    }

    private void initInnerFrameProperty() {
        setBounds(300, 100, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("输入职员编号或者姓名查询信息");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {

        add(Text_Search);
        Text_Search.setFont(Font_Text);
        Text_Search.setOpaque(false);
        Text_Search.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Search.setBounds(80-3, 30, 270, 30);
        Text_Search.addActionListener(new SearchAction());
        add(Area_Result);
        Area_Result.setFont(Font_Area);
        Area_Result.setOpaque(false);
        Area_Result.setEditable(false);
        Area_Result.setSelectedTextColor(Color.BLUE);
        Area_Result.setBounds(50, 80, 330, 250);

        add(Button_Search);
        add(Button_Return);
        Button_Search.setIcon(SearchIcon);
        Button_Return.setIcon(ReturnIcon);
        Button_Return.setBounds(50, 30, 30, 30);
        Button_Search.setBounds(350 - 3, 30, 30, 30);
        Button_Search.addActionListener(new SearchAction());
        Button_Return.addActionListener(new ReturnAction());

        JScrollPane Scroll_Result = new JScrollPane(Area_Result);
        Scroll_Result.setOpaque(false);
        Scroll_Result.getViewport().setOpaque(false);
        getContentPane().add(Scroll_Result);
        Scroll_Result.setBounds(50, 80, 330, 250);
        Scroll_Result.setViewportView(Area_Result);
        TitledBorder SearchBorder = new TitledBorder("Search");
        SearchBorder.setTitleFont(new Font("微软雅黑", Font.PLAIN, 10));
        Scroll_Result.setBorder(SearchBorder);

    }

    class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Area_Result.setText(null);
            String search = Text_Search.getText();
            Staff staff = null;
            java.util.List<Staff> staffList = null;
            StaffService staffService = new StaffService();

            boolean isID = true;
            for (int i = 0; i < search.length(); i++) {
                if (!Character.isDigit(search.charAt(i))) {
                    isID = false;
                    break;
                }
            }
            if (isID) {
                staff = staffService.queryStaffByIdService(Integer.valueOf(search));
            } else {
                staffList = staffService.queryStaffByNameService(search);
            }
            if (staff != null) {
                StringBuffer stringBuffer = new StringBuffer();
                String birthDate = null;
                if (staff.getBirthDate() != null) {
                    birthDate = TimeUtil.getFormatDate(staff.getBirthDate());
                }
                String status = (staff.getStatus() == 1) ? "在职" : "离职";
                stringBuffer.append("—————查询结果如下——————" + "\r\n")
                        .append("▶职员编号：" + staff.getSid() + "\r\n")
                        .append("▶职员姓名：" + staff.getStaffName() + "\r\n")
                        .append("▶出生日期：" + birthDate + "\r\n")
                        .append("▶职员地址：" + staff.getAddress() + "\r\n")
                        .append("▶电话号码：" + staff.getPhoneNumber() + "\r\n")
                        .append("▶银行卡号：" + staff.getBankCard() + "\r\n")
                        .append("▶在职状态：" + status + "\r\n");
                Area_Result.setText(new String(stringBuffer));
            } else if (staffList.size() != 0){
                StringBuffer stringBuffer = new StringBuffer();
                int i = 1;
                for (Staff s : staffList) {
                    String birthDate = null;
                    if (s.getBirthDate() != null) {
                        birthDate = TimeUtil.getFormatDate(s.getBirthDate());
                    }
                    String status = (s.getStatus() == 1) ? "在职" : "离职";
                    stringBuffer.append("—————查询结果如下——————" + "\r\n")
                            .append("第" + (i++) +"位职员信息" + "\r\n")
                            .append("▶职员编号：" + s.getSid() + "\r\n")
                            .append("▶职员姓名：" + s.getStaffName() + "\r\n")
                            .append("▶出生日期：" + birthDate + "\r\n")
                            .append("▶职员地址：" + s.getAddress() + "\r\n")
                            .append("▶电话号码：" + s.getPhoneNumber() + "\r\n")
                            .append("▶银行卡号：" + s.getBankCard() + "\r\n")
                            .append("▶在职状态：" + status + "\r\n");
                }
                Area_Result.setText(new String(stringBuffer));
            } else {
                Area_Result.setText("未查询到任何我职员,\r\n请检查输入后再查询。");
            }
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
