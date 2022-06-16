package com.kag.gui;

import com.kag.common.ColorUtil;
import com.kag.common.ExceptionUtil;
import com.kag.entity.Medicine;
import com.kag.service.MedicineService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @apiNote 内部修改药品界面
 * @author KHighness
 * @since 2020/5/22
 */
public class InnerUpdateMedicineFrame extends JInternalFrame {

    private Medicine medicine;
    private MedicineService medicineService = new MedicineService();

    private final JLabel Label_MedicineName = new JLabel("名称");
    private final JLabel Label_PurchasePrice = new JLabel("进货价格");
    private final JLabel Label_RetailPrice = new JLabel("零售价格");
    private final JLabel Label_SalePrice = new JLabel("批发价格");
    private final JLabel Label_ProduceDate = new JLabel("生产日期");
    private final JLabel Label_ShelfLife = new JLabel("保质期");
    private final JLabel Label_Character = new JLabel("性状");
    private final JLabel Label_DosageForm = new JLabel("剂型");
    private final JLabel Label_QualityStandard = new JLabel("成分");
    private final JLabel Label_Indication = new JLabel("适应症");
    private final JLabel Label_AboutUse = new JLabel("用法用量");
    private final JLabel Label_Taboo = new JLabel("禁忌");
    private final JLabel Label_AdverseReaction = new JLabel("不良反应");

    private final JTextField Text_MedicineName = new JTextField();
    private final JTextField Text_PurchasePrice = new JTextField();
    private final JTextField Text_RetailPrice = new JTextField();
    private final JTextField Text_SalePrice = new JTextField();
    private final JComboBox<String> ComboBox_Year = new JComboBox<>();
    private final JComboBox<String> ComboBox_Month = new JComboBox<>();
    private final JComboBox<String> ComboBox_Day = new JComboBox<>();
    private final JTextField Text_ShelfLife = new JTextField();
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
    private final Font Font_Combo = new Font("微软雅黑", Font.PLAIN, 18);
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/UpdateMedicineBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/MedicineLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();

    public InnerUpdateMedicineFrame(Medicine medicine) {
        this.medicine = medicine;
        initInnerFrameBackground();
        initInnerFrameProperty();
        initInnerFrameComponent();
        initInnerFrameData();
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
        setTitle("修改药品");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Label_MedicineName);
        add(Label_PurchasePrice);
        add(Label_RetailPrice);
        add(Label_SalePrice);
        add(Label_ProduceDate);
        add(Label_ShelfLife);
        add(Label_Character);
        add(Label_DosageForm);
        add(Label_QualityStandard);
        add(Label_Indication);
        add(Label_AboutUse);
        add(Label_Taboo);
        add(Label_AdverseReaction);
        Label_MedicineName.setFont(Font_Label);
        Label_PurchasePrice.setFont(Font_Label);
        Label_RetailPrice.setFont(Font_Label);
        Label_SalePrice.setFont(Font_Label);
        Label_ProduceDate.setFont(Font_Label);
        Label_ShelfLife.setFont(Font_Label);
        Label_Character.setFont(Font_Label);
        Label_DosageForm.setFont(Font_Label);
        Label_QualityStandard.setFont(Font_Label);
        Label_Indication.setFont(Font_Label);
        Label_AboutUse.setFont(Font_Label);
        Label_Taboo.setFont(Font_Label);
        Label_AdverseReaction.setFont(Font_Label);
        int X_LABEL_FIRST = 40, Y_LABEL_FIRST = 30, Y_LABEL_DISTANCE = 40, LABEL_WIDTH = 80, LABEL_HEIGHT = 30;
        Label_MedicineName.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST, LABEL_WIDTH, LABEL_HEIGHT);
        Label_PurchasePrice.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 1 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_RetailPrice.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 2 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_SalePrice.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 3 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_ProduceDate.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 4 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_ShelfLife.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 5 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Character.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 6 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_DosageForm.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 7 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_QualityStandard.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 8 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Indication.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 9 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_AboutUse.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 10 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_Taboo.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 11 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);
        Label_AdverseReaction.setBounds(X_LABEL_FIRST, Y_LABEL_FIRST + 12 * Y_LABEL_DISTANCE, LABEL_WIDTH, LABEL_HEIGHT);

        add(Text_MedicineName);
        add(Text_PurchasePrice);
        add(Text_RetailPrice);
        add(Text_SalePrice);
        add(Text_ShelfLife);
        add(Text_Character);
        add(Text_DosageForm);
        add(Text_QuantityStandard);
        add(Text_Indication);
        add(Text_AboutUse);
        add(Text_Taboo);
        add(Text_AdverseReaction);

        Text_MedicineName.setOpaque(false);
        Text_PurchasePrice.setOpaque(false);
        Text_RetailPrice.setOpaque(false);
        Text_SalePrice.setOpaque(false);
        Text_ShelfLife.setOpaque(false);
        Text_Character.setOpaque(false);
        Text_DosageForm.setOpaque(false);
        Text_QuantityStandard.setOpaque(false);
        Text_Indication.setOpaque(false);
        Text_AboutUse.setOpaque(false);
        Text_Taboo.setOpaque(false);
        Text_AdverseReaction.setOpaque(false);
        Text_MedicineName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_PurchasePrice.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_RetailPrice.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_SalePrice.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_ShelfLife.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Character.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_DosageForm.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_QuantityStandard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Indication.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_AboutUse.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_Taboo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_AdverseReaction.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Text_MedicineName.setFont(Font_Text);
        Text_PurchasePrice.setFont(Font_Text);
        Text_RetailPrice.setFont(Font_Text);
        Text_SalePrice.setFont(Font_Text);
        Text_ShelfLife.setFont(Font_Text);
        Text_Character.setFont(Font_Text);
        Text_DosageForm.setFont(Font_Text);
        Text_QuantityStandard.setFont(Font_Text);
        Text_Indication.setFont(Font_Text);
        Text_AboutUse.setFont(Font_Text);
        Text_Taboo.setFont(Font_Text);
        Text_AdverseReaction.setFont(Font_Text);
        int X_TEXT_FIRST = 140, Y_TEXT_FIRST = 30, Y_TEXT_DISTANCE = 40, TEXT_WIDTH = 300, TEXT_HEIGHT = 30;
        Text_MedicineName.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST, TEXT_WIDTH, TEXT_HEIGHT);
        Text_PurchasePrice.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 1 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_RetailPrice.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 2 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_SalePrice.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 3 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_ShelfLife.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 5 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Character.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 6 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_DosageForm.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 7 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_QuantityStandard.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 8 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Indication.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 9 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_AboutUse.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 10 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_Taboo.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 11 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);
        Text_AdverseReaction.setBounds(X_TEXT_FIRST, Y_TEXT_FIRST + 12 * Y_TEXT_DISTANCE, TEXT_WIDTH, TEXT_HEIGHT);

        add(ComboBox_Year);
        add(ComboBox_Month);
        add(ComboBox_Day);
        for (int i = 2010; i <= 2020; i++) {
            ComboBox_Year.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            ComboBox_Month.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 31; i++) {
            ComboBox_Day.addItem(String.valueOf(i));
        }
        ComboBox_Year.setFont(Font_Combo);
        ComboBox_Month.setFont(Font_Combo);
        ComboBox_Day.setFont(Font_Combo);
        ComboBox_Year.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Month.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Day.setBorder(BorderFactory.createLineBorder(ColorUtil.color6, 3));
        ComboBox_Year.setBounds(140, 190, 90, 30);
        ComboBox_Month.setBounds(244, 190, 90, 30);
        ComboBox_Day.setBounds(348, 190, 90, 30);

        add(Button_Finish);
        add(Button_Return);
        Button_Finish.setFont(Font_Button);
        Button_Return.setFont(Font_Button);
        Button_Finish.setBounds(150, 560, 70, 30);
        Button_Return.setBounds(280, 560, 70, 30);
        Button_Finish.addActionListener(new FinishAction());
        Button_Return.addActionListener(new ReturnAction());
    }

    private void initInnerFrameData() {
        Text_MedicineName.setText(medicine.getMedicineName());
        Text_PurchasePrice.setText(String.valueOf(medicine.getPurchasePrice()));
        Text_RetailPrice.setText(String.valueOf(medicine.getRetailPrice()));
        Text_SalePrice.setText(String.valueOf(medicine.getSalePrice()));
        Text_ShelfLife.setText(String.valueOf(medicine.getShelfLife()));
        Text_Character.setText(medicine.getCharacter());
        Text_DosageForm.setText(medicine.getDosageForm());
        Text_QuantityStandard.setText(medicine.getIngredient());
        Text_Indication.setText(medicine.getIndication());
        Text_AboutUse.setText(medicine.getAboutUse());
        Text_Taboo.setText(medicine.getTaboo());
        Text_AdverseReaction.setText(medicine.getAdverseReactions());
    }

    class FinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String medicineName = Text_MedicineName.getText();
            String purchasePrice = Text_PurchasePrice.getText();
            String retailPrice = Text_RetailPrice.getText();
            String salePrice = Text_SalePrice.getText();
            String produceDate = ComboBox_Year.getSelectedItem() + "-" + ComboBox_Month.getSelectedItem() + "-" + ComboBox_Day.getSelectedItem();
            String shelfLife = Text_ShelfLife.getText();
            String character = Text_Character.getText();
            String dosageForm = Text_DosageForm.getText();
            String qualityStandard = Text_QuantityStandard.getText();
            String indication = Text_Indication.getText();
            String aboutUse = Text_AboutUse.getText();
            String taboo = Text_Taboo.getText();
            String adverseReaction = Text_AdverseReaction.getText();

            if (purchasePrice.equals("")) {
                JOptionPane.showMessageDialog(null, "进货价格不能为空", "Purchase price Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < purchasePrice.length(); i++) {
                if ((!(Character.isDigit(purchasePrice.charAt(i))) && !(".".equals(String.valueOf(purchasePrice.charAt(i)))))){
                    JOptionPane.showMessageDialog(null, "进货价格非法", "Purchase price Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (retailPrice.equals("")) {
                JOptionPane.showMessageDialog(null, "零售价格不能为空", "Retail price Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < retailPrice.length(); i++) {
                if ((!(Character.isDigit(retailPrice.charAt(i))) && !(".".equals(String.valueOf(retailPrice.charAt(i)))))){
                    JOptionPane.showMessageDialog(null, "零售价格非法", "Retail Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (salePrice.equals("")) {
                JOptionPane.showMessageDialog(null, "批发价格不能为空", "Sale price Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < salePrice.length(); i++) {
                if ((!(Character.isDigit(salePrice.charAt(i))) && !(".".equals(String.valueOf(salePrice.charAt(i)))))){
                    JOptionPane.showMessageDialog(null, "批发价格非法", "Sale Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            for (int i = 0; i < shelfLife.length(); i++) {
                if (!Character.isDigit(shelfLife.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "保质期非法", "Shelf life Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            double DoublePurchasePrice = Double.valueOf(purchasePrice);
            double DoubleRetailPrice = Double.valueOf(retailPrice);
            double DoubleSalePrice = Double.valueOf(salePrice);
            int IntShelfLife = Integer.valueOf(shelfLife);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ProduceDate = new Date();
            try {
                ProduceDate = simpleDateFormat.parse(produceDate);
            } catch (ParseException ex) {
                ExceptionUtil.printException(ex);
            }

            medicine.setMedicineName(medicineName);
            medicine.setPurchasePrice(DoublePurchasePrice);
            medicine.setRetailPrice(DoubleRetailPrice);
            medicine.setSalePrice(DoubleSalePrice);
            medicine.setProduceDate(ProduceDate);
            medicine.setShelfLife(IntShelfLife);
            medicine.setCharacter(character);
            medicine.setDosageForm(dosageForm);
            medicine.setIngredient(qualityStandard);
            medicine.setIndication(indication);
            medicine.setAboutUse(aboutUse);
            medicine.setTaboo(taboo);
            medicine.setAdverseReactions(adverseReaction);
            medicineService.updateMedicineInfoService(medicine.getMid(), medicine);
            JOptionPane.showMessageDialog(null, "修改药品信息成功", "Success", JOptionPane.YES_OPTION);
        }
    }

    class ReturnAction implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

}
