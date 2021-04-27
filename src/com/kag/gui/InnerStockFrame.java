package com.kag.gui;

import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 内部库存界面
 * @Author: 陈子康
 * @Date: 2020/5/26
 */
public class InnerStockFrame {

    private JDesktopPane DesktopPane;
    private final InnerStockMenuFrame innerStockMenuFrame = new InnerStockMenuFrame();
    private final InnerSearchStockByIdFrame innerSearchStockByIdFrame = new InnerSearchStockByIdFrame();
    private final InnerSearchStockByNameFrame innerSearchStockByNameFrame = new InnerSearchStockByNameFrame();

    public InnerStockFrame(JDesktopPane DesktopPane) {
        this.DesktopPane = DesktopPane;
        DesktopPane.add(innerStockMenuFrame);
        DesktopPane.add(innerSearchStockByIdFrame);
        DesktopPane.add(innerSearchStockByNameFrame);

        innerStockMenuFrame.Button_QueryAllStock.addActionListener(new InnerSearchAllStockFrameSearchAction());
        innerStockMenuFrame.Button_QueryStockById.addActionListener(new InnerSearchStockByIdFrameSearchAction(innerStockMenuFrame, innerSearchStockByIdFrame));
        innerStockMenuFrame.Button_QueryStockByName.addActionListener(new InnerSearchStockByNameFrameSearchAction(innerStockMenuFrame, innerSearchStockByNameFrame));
        innerSearchStockByIdFrame.Button_Return.addActionListener(new InnerSearchStockByIdFrameReturnAction(innerStockMenuFrame, innerSearchStockByIdFrame));
        innerSearchStockByNameFrame.Button_Return.addActionListener(new InnerSearchStockByNameFrameReturnAction(innerStockMenuFrame, innerSearchStockByNameFrame));
    }

    class InnerSearchAllStockFrameSearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DesktopPane.add(new InnerSearchAllStockFrame());
        }
    }

    class InnerSearchStockByIdFrameSearchAction implements ActionListener {
        private InnerStockMenuFrame innerStockMenuFrame;
        private InnerSearchStockByIdFrame innerSearchStockByIdFrame;

        public InnerSearchStockByIdFrameSearchAction(InnerStockMenuFrame innerStockMenuFrame, InnerSearchStockByIdFrame innerSearchStockByIdFrame) {
            this.innerStockMenuFrame = innerStockMenuFrame;
            this.innerSearchStockByIdFrame = innerSearchStockByIdFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            innerStockMenuFrame.setVisible(false);
            innerSearchStockByIdFrame.setVisible(true);
        }
    }

    class InnerSearchStockByNameFrameSearchAction implements ActionListener {
        private InnerStockMenuFrame innerStockMenuFrame;
        private InnerSearchStockByNameFrame innerSearchStockByNameFrame;

        public InnerSearchStockByNameFrameSearchAction(InnerStockMenuFrame innerStockMenuFrame, InnerSearchStockByNameFrame innerSearchStockByNameFrame) {
            this.innerStockMenuFrame = innerStockMenuFrame;
            this.innerSearchStockByNameFrame = innerSearchStockByNameFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            innerStockMenuFrame.setVisible(false);
            innerSearchStockByNameFrame.setVisible(true);
        }
    }


    class InnerSearchStockByIdFrameReturnAction implements ActionListener {
        private InnerStockMenuFrame innerStockMenuFrame;
        private InnerSearchStockByIdFrame innerSearchStockByIdFrame;

        public InnerSearchStockByIdFrameReturnAction(InnerStockMenuFrame innerStockMenuFrame, InnerSearchStockByIdFrame innerSearchStockByIdFrame) {
            this.innerStockMenuFrame = innerStockMenuFrame;
            this.innerSearchStockByIdFrame = innerSearchStockByIdFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            innerSearchStockByIdFrame.setVisible(false);
            innerStockMenuFrame.setVisible(true);
        }
    }

    class InnerSearchStockByNameFrameReturnAction implements ActionListener {
        private InnerStockMenuFrame innerStockMenuFrame;
        private InnerSearchStockByNameFrame innerSearchStockByNameFrame;

        public InnerSearchStockByNameFrameReturnAction(InnerStockMenuFrame innerStockMenuFrame, InnerSearchStockByNameFrame innerSearchStockByNameFrame) {
            this.innerStockMenuFrame = innerStockMenuFrame;
            this.innerSearchStockByNameFrame = innerSearchStockByNameFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            innerSearchStockByNameFrame.setVisible(false);
            innerStockMenuFrame.setVisible(true);
        }
    }



}
