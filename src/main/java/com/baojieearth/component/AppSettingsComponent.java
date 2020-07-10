package com.baojieearth.component;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextArea;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * @author baojie 2020/7/9
 */
public class AppSettingsComponent {

    private final JPanel myMainPanel;
    private final JBTextArea myHeaderText = new JBTextArea(10,10);
    private final JBTextArea myMethodText = new JBTextArea(10,10);

    public AppSettingsComponent() {
        myHeaderText.scrollRectToVisible(new Rectangle());
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Setting Header Doc Template: "), myHeaderText, 1, true)
                .addLabeledComponent(new JBLabel("Setting Method Doc Template: "), myMethodText, 1, true)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return myHeaderText;
    }

    public String getHeaderDocTemplate() {
        return myHeaderText.getText();
    }

    public void setHeaderDocTemplate(String inputText) {
        myHeaderText.setText(inputText);
    }


    public String getMethodDocTemplate() {
        return myMethodText.getText();
    }

    public void setMethodDocTemplate(String inputText) {
        myMethodText.setText(inputText);
    }


}
