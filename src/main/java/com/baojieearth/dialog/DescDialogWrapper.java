package com.baojieearth.dialog;

import com.baojieearth.state.AppSettingsState;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author baojie 2020/7/10
 */
public class DescDialogWrapper extends DialogWrapper {

    private AppSettingsState appSettingsState;

    private JTextField desc = new JTextField();

    public DescDialogWrapper() {
        //use current window as parent
        super(true);
        this.appSettingsState = AppSettingsState.getInstance();
        init();
        setTitle("功能描述");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("请输入功能描述"), desc, 1, true)
                .addComponentFillVertically(new JPanel(),0)
                .getPanel();
    }

    /**
     * 自定义按钮，并添加点击事件
     *
     * @return
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel southPanel = new JPanel(new FlowLayout());
        JButton generateButton = new JButton("生成");
        JButton cancelButton = new JButton("取消");
        generateButton.addActionListener(e -> {
            Messages.showMessageDialog(desc.getText()+appSettingsState.getHeaderDocTemplate(), "生成成功", Messages.getInformationIcon());
        });
        cancelButton.addActionListener(e -> {
            close(1);
        });
        southPanel.add(generateButton);
        southPanel.add(cancelButton);
        return southPanel;
    }


}
