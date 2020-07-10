package com.baojieearth.action;

import com.baojieearth.dialog.DescDialogWrapper;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;

/**
 * @author baojie 2020/6/22
 */
public class JavaDocGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        //获取当前在操作的工程上下文
        Project project = e.getData(PlatformDataKeys.PROJECT);
        //获取当前操作的类文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前类文件的路径
        String classPath = psiFile.getVirtualFile().getPath();
        //String title = "Hello World!";
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (null == editor) {
            return;
        }
        DescDialogWrapper descDialogWrapper = new DescDialogWrapper();
        descDialogWrapper.show();
//        SelectionModel selectionModel = editor.getSelectionModel();
//        String selectedText = selectionModel.getSelectedText();
//        if (StringUtils.isBlank(selectedText)) {
//            return;
//        }
        //显示对话框
//        Messages.showMessageDialog(project, classPath, selectedText, Messages.getInformationIcon());

    }


}
