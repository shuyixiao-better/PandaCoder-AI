package com.poeticcoder.ai.ui;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * AI Chat 工具窗口工厂
 * 创建 AI 聊天工具窗口
 */
public class AiChatToolWindowFactory implements ToolWindowFactory, DumbAware {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        AiChatToolWindowPanel panel = new AiChatToolWindowPanel(project);
        Content content = ContentFactory.getInstance().createContent(panel.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
