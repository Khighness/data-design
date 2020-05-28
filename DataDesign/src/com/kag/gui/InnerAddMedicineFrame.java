package com.kag.gui;

import com.kag.entity.Medicine;
import com.kag.service.MedicineService;
import com.kag.service.StockService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 内部添加药品界面
 * @Author: 陈子康
 * @Date: 2020/5/22
 */
public class InnerAddMedicineFrame extends JInternalFrame {

    private final JLabel Label_Mid = new JLabel("编号");
    private final JLabel Label_MedicineName = new JLabel("名称");
    private final JLabel Label_Character = new JLabel("性状");
    private final JLabel Label_DosageForm = new JLabel("剂型");
    private final JLabel Label_QualityStandard = new JLabel("成分");
    private final JLabel Label_Indication = new JLabel("适应症");
    private final JLabel Label_AboutUse = new JLabel("用法用量");
    private final JLabel Label_Taboo = new JLabel("禁忌");
    private final JLabel Label_AdverseReaction = new JLabel("不良反应");

    private final JTextField Text_Mid = new JTextField();
    private final JTextField Text_MedicineName = new JTextField();
    private final JTextField Text_Character = new JTextField();
    private final JTextField Text_DosageForm = new JTextField();
    private final JTextField Text_QuantityStandard = new JTextField();
    private final JTextField Text_Indication = new JTextField();
    private final JTextField Text_AboutUse = new JTextField();
    private final JTextField Text_Taboo = new JTextField();
    private final JTextField Text_AdverseReaction = new JTextField();

    private final JButton Button_Finish = new JButton("完成");
    private final JButton Button_Return = new JButton("返回");

    private final Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);
    private final Font Font_Text = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/MedicineBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/MedicineLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerAddMedicineFrame() {
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
        setBounds(300, 10, BackIcon.getIconWidth(), BackIcon.getIconHeight());
        setVisible(true);
        setLayout(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("新增药品");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Label_Mid);
        add(Label_MedicineName);
        add(Label_Character);
        add(Label_DosageForm);
        add(Label_QualityStandard);
        add(Label_Indication);
        add(Label_AboutUse);
        add(Label_Taboo);
        add(Label_AdverseReaction);
        Label_Mid.setFont(Font_Label);
        Label_MedicineName.setFont(Font_Label);
        Label_Character.setFont(Font_Label);
        Label_DosageForm.setFont(Font_Label);
        Label_QualityStandard.setFont(Font_Label);
        Label_Indication.setFont(Font_Label);
        Label_AboutUse.setFont(Font_Label);
        Label_Taboo.setFont(Font_Label);
        Label_AdverseReaction.setFont(Font_Label);
        int X_LABEL_FIRST = 30, Y_LABEL_FIRST = 30, Y_LABEL_DISTANCE = 40, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_Mid.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_MedicineName.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Character.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_DosageForm.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_QualityStandard.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 4 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Indication.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 5 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_AboutUse.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 6 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Taboo.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 7 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_AdverseReaction.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 8 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_Mid);
        add(Text_MedicineName);
        add(Text_Character);
        add(Text_DosageForm);
        add(Text_QuantityStandard);
        add(Text_Indication);
        add(Text_AboutUse);
        add(Text_Taboo);
        add(Text_AdverseReaction);
        Text_Mid.setOpaque(false);
        Text_MedicineName.setOpaque(false);
        Text_Character.setOpaque(false);
        Text_DosageForm.setOpaque(false);
        Text_QuantityStandard.setOpaque(false);
        Text_Indication.setOpaque(false);
        Text_AboutUse.setOpaque(false);
        Text_Taboo.setOpaque(false);
        Text_AdverseReaction.setOpaque(false);
        Text_Mid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_MedicineName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Character.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_DosageForm.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_QuantityStandard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Indication.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_AboutUse.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Taboo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_AdverseReaction.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Mid.setFont(Font_Text);
        Text_MedicineName.setFont(Font_Text);
        Text_Character.setFont(Font_Text);
        Text_DosageForm.setFont(Font_Text);
        Text_QuantityStandard.setFont(Font_Text);
        Text_Indication.setFont(Font_Text);
        Text_AboutUse.setFont(Font_Text);
        Text_Taboo.setFont(Font_Text);
        Text_AdverseReaction.setFont(Font_Text);
        int X_TEXT_FIRST = 110, Y_TEXT_FIRST = 30, Y_TEXT_DISTANCE = 40, TEXT_WIDTH = 300, TEXT_HEIGHT = 30;
        Text_Mid.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_MedicineName.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Character.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_DosageForm.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_QuantityStandard.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 4 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Indication.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 5 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_AboutUse.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 6 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Taboo.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 7 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_AdverseReaction.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 8 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
        Button_Finish.setBounds(130, 400, 70, 30);
        Button_Return.setBounds(260, 400, 70, 30);
        Button_Finish.addActionListener(new AddMedicineFinishAction());
        Button_Return.addActionListener(new AddMedicineReturnAction());
    }

    class AddMedicineFinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mid = Text_Mid.getText();
            String medicineName = Text_MedicineName.getText();
            String character = Text_Character.getText();
            String dosageForm = Text_DosageForm.getText();
            String qualityStandard = Text_QuantityStandard.getText();
            String indication = Text_Indication.getText();
            String aboutUse = Text_AboutUse.getText();
            String taboo = Text_Taboo.getText();
            String adverseReactions = Text_AdverseReaction.getText();

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

            Medicine medicine = new Medicine(Integer.valueOf(mid), medicineName, character, dosageForm, qualityStandard, indication, aboutUse, taboo, adverseReactions);
            MedicineService medicineService = new MedicineService();
            medicineService.addMedicineDetailInfoService(medicine);
            JOptionPane.showMessageDialog(null, "添加药品信息成功", "Success", JOptionPane.YES_OPTION);
            StockService stockService = new StockService();
            stockService.addStockService(Integer.valueOf(mid));
        }
    }

    class AddMedicineReturnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
