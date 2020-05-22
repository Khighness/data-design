package com.kag.gui;


/**
 * @Description: 登录界面
 * @Author: 陈子康
 * @Date: 2020/4/29
 */

import com.kag.service.LoginService;
import com.kag.common.ExceptUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class LoginFrame extends JFrame {

    /**
     * @LoginBackPane: 画板层
     * @BackIcon: 背景图
     * @LogoIcon: 标志图
     * @BackPanel: 背景面板
     * @LogoPanel: 标志面板
     * @LoginPanel: 登录面板
     * @UserName: 用户名显示框
     * @PassWord: 密码显示框
     * @Button_Login： 登陆按钮
     * @Button_Cancel: 取消按钮
     * @Text_Username： 用户名输入框
     * @Text_Password： 密码输入框
     */
    private JLayeredPane LayeredPane = new JLayeredPane();
    private ImageIcon BackIcon = new ImageIcon(BackImagePath);
    private ImageIcon LeftIcon = new ImageIcon(LeftImagePath);
    private JPanel BackPanel = new JPanel();
    private JPanel LogoPanel = new JPanel();
    private JPanel LoginPanel = new JPanel();
    private JComboBox<String> ComboBoxType = new JComboBox<String>();
    private final JLabel Identity = new JLabel("身份");
    private final JLabel UserName = new JLabel("用户名");
    private final JLabel PassWord = new JLabel("密码");
    private JButton Button_Login = new JButton("登录");
    private JButton Button_Register = new JButton("注册");
    private JButton Button_Cancel = new JButton("取消");
    private JTextField Text_Username = new JTextField();
    private JPasswordField Text_Password = new JPasswordField();
    private  final long serialVersionUID = 1L;


    /**
     * @backImagePath: 背景图的相对路径
     * @LeftImagePath: 左侧图的相对路径
     * @backImagePath: Logo图的相对路径
     */
    private final static String BackImagePath = "img/NewLoginBack.png";
    private final static String LeftImagePath = "img/LeftLogo.png";
    private final static String SystemLogoPath = "img/SysLogo.png";

    /**
     * @Description: 处理拖动窗口事件
     */
    private int xOld = 0;
    private int yOld = 0;

    /**
     * @Description: 登陆
     */
    class LoginSuccessAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String Username = Text_Username.getText();
            String Password = new String(Text_Password.getPassword());
            LoginService loginService = new LoginService();
            String LoginFlag = loginService.Admin_loginCheck(Username, Password);
            if ( LoginFlag.equals("true") ) {
                JOptionPane.showMessageDialog(null, "登陆成功", "Success", JOptionPane.YES_NO_CANCEL_OPTION);
            } else if ( LoginFlag.equals("false") ) {
                JOptionPane.showMessageDialog(null, "密码错误", "Error",JOptionPane.YES_NO_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, LoginFlag, "Error",JOptionPane.YES_NO_OPTION);
            }
            //setVisible(false);
            //MainFrame.serVisible(true);
        }
    }

    /**
     * @Description: 注册
     */
    class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setVisible(false);
                new RegisterFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @Description: 取消登录
     */
    class LoginCancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            System.out.println("End");
            System.exit(0);
        }
    }
    
    public LoginFrame() throws IOException {
        super();
        DraggableFrame();
        InitImageFrame();
        InitLoginFrame();
    }

    /**
     * @Description: 实现窗口可以随意拖动
     * @throws IOException
     */
    private void DraggableFrame() throws IOException {
        LoginFrame.this.setLayout(null);
        // 处理拖动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();
                yOld = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();
                int xNew = xOnScreen - xOld;
                int yNew = yOnScreen - yOld;
                LoginFrame.this.setLocation(xNew, yNew);
            }
        });
    }

    /**
     * @Description: 贴图
     */
    private void InitImageFrame() throws IOException {
        BufferedImage BackImage = ImageIO.read(new FileInputStream(BackImagePath));
        BufferedImage LogoImage = ImageIO.read(new FileInputStream(SystemLogoPath));
        LayeredPane.setBounds(0, 0, 600, 544);
        this.add(LayeredPane);

        BackPanel.setBounds(0, 0, BackImage.getWidth(), BackImage.getHeight());
        LayeredPane.add(BackPanel, new Integer(Integer.MIN_VALUE));
        JLabel BackLabel = new JLabel(BackIcon);
        BackPanel.add(BackLabel);
        JPanel jPanel = (JPanel) this.getContentPane();
        jPanel.setOpaque(false);

        LogoPanel.setBounds(50, 168,  150,  195);
        LogoPanel.setLayout(null);
        LogoPanel.setBorder(BorderFactory.createTitledBorder("K"));   //边框名称
        LogoPanel.setBorder(BorderFactory.createLineBorder(Color.white)); //设置边框
        LayeredPane.add(LogoPanel);
        JLabel LogoLabel = new JLabel(LeftIcon);
        LogoPanel.add(LogoLabel);
        LogoLabel.setBounds(new Rectangle(0, 20,  150,  150));

        LoginPanel.setBounds(200, 168, 350, 195);
        LoginPanel.setLayout(null);
        LoginPanel.setOpaque(false);
        LoginPanel.setBorder(BorderFactory.createTitledBorder(""));
        LoginPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        LayeredPane.add(LoginPanel);
        setIconImage(LogoImage);
    }

    /**
     * @Description: 初始化整个登录界面
     */
    private void InitLoginFrame() {
        Font Font_Label = new Font("微软雅黑", Font.BOLD, 18);

        LoginPanel.add(Identity);
        Identity.setBounds(new Rectangle(30, 20, 62, 25));
        Identity.setFont(Font_Label);
        LoginPanel.add(UserName);
        UserName.setBounds(new Rectangle(30, 70, 62, 25));
        UserName.setFont(Font_Label);
        LoginPanel.add(PassWord);
        PassWord.setBounds(new Rectangle(30, 110, 62, 25));
        PassWord.setFont(Font_Label);

        LoginPanel.add(ComboBoxType);
        ComboBoxType.addItem("Admin");
        ComboBoxType.addItem("Staff");
        ComboBoxType.setBounds(new Rectangle(95, 15, 240, 30));
        ComboBoxType.setFont(new Font("微软雅黑", 1, 15));
        LoginPanel.add(Text_Username);
        Text_Username.setBounds(new Rectangle(95, 65, 240, 30));
        Text_Username.setFont(new Font("微软雅黑", 1, 18));
        LoginPanel.add(Text_Password);
        Text_Password.setBounds(new Rectangle(95, 105, 240, 30));
        Text_Password.setFont(new Font("", Font.PLAIN, 25)); // 设置回显字符大小

        LoginPanel.add(Button_Login);
        Font Button_Font = new Font("微软雅黑", 1, 12);
        Button_Login.setBounds(new Rectangle(50, 155,  80, 25));
        Button_Login.addActionListener(new LoginSuccessAction());
        Button_Login.setFont(Button_Font);
        LoginPanel.add(Button_Register);
        Button_Register.setBounds(new Rectangle(150, 155, 80, 25));
        Button_Register.addActionListener(new RegisterAction());
        Button_Register.setFont(Button_Font);
        LoginPanel.add(Button_Cancel);
        Button_Cancel.setBounds(new Rectangle(250, 155,  80, 25));
        Button_Cancel.addActionListener(new LoginCancelAction());
        Button_Cancel.setFont(Button_Font);

        this.setBounds(0, 0, 600, 544);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        try {
            //改变按钮样式
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

    public static void main(String[] args) throws IOException {
        new LoginFrame();
    }

}