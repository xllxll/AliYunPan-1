package xin.xingk.www.ui.dialog;

import cn.hutool.core.swing.DesktopUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import lombok.Data;
import xin.xingk.www.common.CommonConstants;
import xin.xingk.www.util.ComponentUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static xin.xingk.www.App.mainFrame;

/**
 * @author: Mr.chen
 * @date: 2022/2/13 11:30
 * @description:
 */
@Data
public class About extends JDialog {
    private JPanel aboutPanel;
    private JLabel rewardImg;
    private JLabel thank;
    private JLabel code;
    private JLabel gitHub;
    private JLabel gitee;
    private JLabel versionInfo;

    public About() {
        super(mainFrame, "关于");
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.4, 0.5);
        setContentPane(aboutPanel);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        versionInfo.setText(CommonConstants.TITLE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        gitHub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DesktopUtil.browse("https://github.com/chenxingk/AliYunPan");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        gitee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DesktopUtil.browse("https://gitee.com/xingk-code/AliYunPan");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayoutManager(6, 1, new Insets(20, 20, 20, 20), -1, -1));
        rewardImg = new JLabel();
        rewardImg.setIcon(new ImageIcon(getClass().getResource("/icons/zs.png")));
        rewardImg.setText("");
        aboutPanel.add(rewardImg, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        thank = new JLabel();
        thank.setText("感谢有您的支持，备份助手才能一直保持更新，增加更多功能。");
        aboutPanel.add(thank, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        code = new JLabel();
        code.setText("项目源码");
        aboutPanel.add(code, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gitHub = new JLabel();
        gitHub.setText("<html>GitHub：<a href=\"https://github.com/chenxingk/AliYunPan\">https://github.com/chenxingk/AliYunPan</a></html>");
        aboutPanel.add(gitHub, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gitee = new JLabel();
        gitee.setText("<html>Gitee：<a href=\"https://gitee.com/xingk-code/AliYunPan\">https://gitee.com/xingk-code/AliYunPan</a></html>");
        aboutPanel.add(gitee, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        versionInfo = new JLabel();
        versionInfo.setText("备份助手-V2.0");
        aboutPanel.add(versionInfo, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return aboutPanel;
    }

}
