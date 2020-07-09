package com.baojieearth.component;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author baojie 2020/7/9
 */
public class AppSettingsComponent {

    private final JPanel myMainPanel;
    private final JBTextField myHeaderText = new JBTextField();

    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter Header Content: "), myHeaderText, 1, false)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return myHeaderText;
    }

    public String getHeaderText() {
        return myHeaderText.getText();
    }

    public void setHeaderText(String inputText) {
        myHeaderText.setText(inputText);
    }

}
