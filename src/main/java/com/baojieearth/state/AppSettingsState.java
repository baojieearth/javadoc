package com.baojieearth.state;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author baojie 2020/7/9
 */
@State(
        name = "com.baojieearth.state.AppSettingsState",
        storages = {@Storage("JavaDocGeneratorPlugin.xml")}
)
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    private String headerDocTemplate;

    private String methodDocTemplate;

    public static AppSettingsState getInstance() {
        return ServiceManager.getService(AppSettingsState.class);
    }

    @Nullable
    @Override
    public AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public String getHeaderDocTemplate() {
        return headerDocTemplate;
    }

    public void setHeaderDocTemplate(String headerDocTemplate) {
        this.headerDocTemplate = headerDocTemplate;
    }

    public String getMethodDocTemplate() {
        return methodDocTemplate;
    }

    public void setMethodDocTemplate(String methodDocTemplate) {
        this.methodDocTemplate = methodDocTemplate;
    }
}
