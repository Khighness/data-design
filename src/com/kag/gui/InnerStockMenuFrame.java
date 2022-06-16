package com.kag.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @apiNote 内部库存查询菜单
 * @author KHighness
 * @since 2020/5/26
 */
public class InnerStockMenuFrame extends JInternalFrame {

    public final JButton Button_QueryAllStock = new JButton("查询所有药品库存数量");
    public final JButton Button_QueryStockById = new JButton("根据药品编号查询库存");
    public final JButton Button_QueryStockByName = new JButton("根据药品名称查询库存");
    private final Font Font_Button = new Font("微软雅黑", Font.BOLD, 18);
    private final ImageIcon BackIcon = new ImageIcon("img/StockMenuBack.png");
    private final ImageIcon LogoIcon = new ImageIcon("img/StockLogo.png");
    private final JLabel BackLabel = new JLabel(BackIcon);
    private final JPanel ContentPanel = (JPanel) getContentPane();
    private final JLayeredPane LayeredPane = getLayeredPane();


    public InnerStockMenuFrame() {
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
        setTitle("库存查询");
        setFrameIcon(LogoIcon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initInnerFrameComponent() {
        add(Button_QueryAllStock);
        add(Button_QueryStockById);
        add(Button_QueryStockByName);
        Button_QueryAllStock.setFont(Font_Button);
        Button_QueryStockById.setFont(Font_Button);
        Button_QueryStockByName.setFont(Font_Button);
        Button_QueryAllStock.setBounds(20, 10, 250, 30);
        Button_QueryStockById.setBounds(20, 50, 250, 30);
        Button_QueryStockByName.setBounds(20, 90, 250, 30);
    }

}
