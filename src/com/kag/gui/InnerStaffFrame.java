package com.kag.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @Description: 内部个人界面
 * @Author: 陈子康
 * @Date: 2020/5/25
 */
public class InnerStaffFrame extends JInternalFrame {

    private int sid;
    private JDesktopPane DesktopPane;
    private final InnerPersonMenuFrame innerPersonMenuFrame = new InnerPersonMenuFrame();

    public InnerStaffFrame(int sid, JDesktopPane DesktopPane) {
        this.sid = sid;
        this.DesktopPane = DesktopPane;
        DesktopPane.add(innerPersonMenuFrame);

        innerPersonMenuFrame.Button_PersonInfo.addActionListener(new ShowStaffInfoAction());
        innerPersonMenuFrame.Button_UpdateInfo.addActionListener(new UpdateStaffInfoAction());
        innerPersonMenuFrame.Button_UpdateWord.addActionListener(new UpdateStaffPasswordAction());
        innerPersonMenuFrame.Button_Logout.addActionListener(new LogoutAction());
    }

    class ShowStaffInfoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DesktopPane.add(new InnerStaffInfoFrame(sid));
        }
    }

    class UpdateStaffInfoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DesktopPane.add(new InnerUpdateStaffInfoFrame(sid));
        }
    }

    class UpdateStaffPasswordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DesktopPane.add(new InnerUpdateStaffWordFrame(sid));
        }
    }

    class LogoutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DesktopPane.getParent().setVisible(false);
            try {
                new LoginFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

