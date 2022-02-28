package xin.xingk.www.ui;

import cn.hutool.core.io.resource.ResourceUtil;
import com.formdev.flatlaf.extras.FlatSVGUtils;
import lombok.extern.slf4j.Slf4j;
import xin.xingk.www.common.constant.CommonConstants;
import xin.xingk.www.ui.menu.TopMenuBar;
import xin.xingk.www.util.ComponentUtil;
import xin.xingk.www.util.ConfigUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: Mr.chen
 * @date: 2022/2/12 11:54
 * @description:
 */
@Slf4j
public class MainFrame extends JFrame {

    public MainFrame(){
        //设置图标
        setIconImages(FlatSVGUtils.createWindowIconImages("/icons/logo.svg"));
        // 窗口最小化事件
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            public void windowIconified(WindowEvent e) {
                setVisible(false);
                miniTray();
            }
        });
    }

    public void initTopMenuBar() {
        TopMenuBar topMenuBar = TopMenuBar.getInstance();
        topMenuBar.init();
        setJMenuBar(topMenuBar);
    }

    public void initUpdate() {
        this.initTopMenuBar();
        this.setTitle("检测更新");
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.3, 0.4);
        this.add(Login.getInstance().getLoginPanel());
        this.remove(Home.getInstance().getHomePanel());
    }

    public void initLogin() {
        this.initTopMenuBar();
        this.setTitle("扫码登录");
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.3, 0.4);
        this.add(Login.getInstance().getLoginPanel());
        this.remove(Home.getInstance().getHomePanel());
        Login.initQrCode();
    }

    public void initHome() {
        this.initTopMenuBar();
        this.setTitle(CommonConstants.TITLE +"，欢迎您："+ ConfigUtil.getUserName());
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.6, 0.8);
        this.add(Home.getInstance().getHomePanel());
        this.remove(Login.getInstance().getLoginPanel());
        Home.initTableData();
//        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.3, 0.5);
    }

    /**
     * 窗口最小化到任务栏托盘
     */
    public void miniTray() {
        SystemTray tray = SystemTray.getSystemTray();
        ImageIcon trayImg = new ImageIcon(ResourceUtil.getResource("icons/logo.png"));//托盘图标
        TrayIcon trayIcon = new TrayIcon(trayImg.getImage(), CommonConstants.TITLE);
        trayIcon.setImageAutoSize(true);

        //鼠标点击事件处理器
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 鼠标点击一次打开软件
                if (e.getClickCount() == 1) {
                    // 移去托盘图标
                    tray.remove(trayIcon);
                    setVisible(true);
                    //还原窗口
                    setExtendedState(JFrame.NORMAL);
                }
            }
        });

        try {
            tray.add(trayIcon);
        } catch (Exception e) {
            log.error(">>> 窗口最小化发生异常：{}",e.getMessage());
        }
    }
}
