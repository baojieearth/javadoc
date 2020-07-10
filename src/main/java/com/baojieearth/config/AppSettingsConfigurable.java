package com.baojieearth.config;

import com.baojieearth.component.AppSettingsComponent;
import com.baojieearth.state.AppSettingsState;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author baojie 2020/7/9
 */
public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent appSettingsComponent;

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "JavaDoc Generator Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return appSettingsComponent.getPreferredFocusedComponent();
    }

    @Override
    public @Nullable JComponent createComponent() {
        appSettingsComponent = new AppSettingsComponent();
        return appSettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        boolean isModified = !appSettingsComponent.getHeaderDocTemplate().equals(settings.getHeaderDocTemplate());
        isModified |= !appSettingsComponent.getMethodDocTemplate().equals(settings.getMethodDocTemplate());
        return isModified;
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.setHeaderDocTemplate(appSettingsComponent.getHeaderDocTemplate());
        settings.setMethodDocTemplate(appSettingsComponent.getMethodDocTemplate());
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        appSettingsComponent.setHeaderDocTemplate(settings.getHeaderDocTemplate());
        appSettingsComponent.setMethodDocTemplate(settings.getMethodDocTemplate());
    }

    @Override
    public void disposeUIResources() {
        appSettingsComponent = null;
    }
}
