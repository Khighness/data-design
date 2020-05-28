package com.kag.gui;

import com.kag.common.TimeUtil;
import com.kag.entity.Medicine;
import com.kag.service.MedicineService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 内部药品查询界面(根据ID或者药名)
 * @Author: 陈子康
 * @Date: 2020/5/26
 */
public class InnerSearchMedicineFrame extends JInternalFrame {

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


    public InnerSearchMedicineFrame() {
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
        setTitle("输入药品编号或者名称查询信息");
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
            String search = Text_Search.getText();
            Medicine medicine = null;
            MedicineService medicineService = new MedicineService();

            boolean isID = true;
            for (int i = 0; i < search.length(); i++) {
                if (!Character.isDigit(search.charAt(i))) {
                    isID = false;
                    break;
                }
            }
            if (isID) {
                medicine = medicineService.queryMedicineByIdService(Integer.valueOf(search));
            } else {
                medicine = medicineService.queryMedicineByNameService(search);
            }
            if (medicine == null) {
                Area_Result.setText("未查询到任何我药品,\r\n请检查输入后再查询。");
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                String produceDate = null;
                if (medicine.getProduceDate() != null) {
                    produceDate = TimeUtil.getFormatDate(medicine.getProduceDate());
                }
                stringBuffer.append("—————查询结果如下——————")
                        .append("▶药品编号：" + medicine.getMid() + "\r\n")
                        .append("▶药品名称：" + medicine.getMedicineName() + "\r\n")
                        .append("▶进货价格：" + medicine.getPurchasePrice() + "\r\n")
                        .append("▶零售价格：" + medicine.getRetailPrice() + "\r\n")
                        .append("▶批发价格：" + medicine.getSalePrice() + "\r\n")
                        .append("▶生产日期：" + produceDate + "\r\n")
                        .append("▶保质期：" + medicine.getShelfLife() + "天" + "\r\n")
                        .append("▶性状：" + medicine.getCharacter() + "\r\n")
                        .append("▶剂型：" + medicine.getDosageForm() + "\r\n")
                        .append("▶成分：" + medicine.getIngredient() + "\r\n")
                        .append("▶适应症：" + medicine.getIndication() + "\r\n")
                        .append("▶用法用量：" + medicine.getAboutUse() + "\r\n")
                        .append("▶禁忌：" + medicine.getTaboo() + "\r\n")
                        .append("▶不良反应：" + medicine.getAdverseReactions());
                Area_Result.setText(new String(stringBuffer));
            }
        }
    }

    class ReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
