package com.poeticcoder.ai.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.ui.Messages;
import com.poeticcoder.ai.chat.OpenAICompatibleChatClient;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * PandaCoder AI 设置界面
 */
public class PandaCoderAIConfigurable implements Configurable {

    private JPanel mainPanel;
    private JCheckBox enableAiChatCheckBox;
    private JComboBox<String> providerTypeCombo;
    private JTextField baseUrlField;
    private JPasswordField apiKeyField;
    private JTextField modelField;
    private JButton testConnectionButton;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "PandaCoder AI";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mainPanel = new JPanel(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 启用 AI Chat
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        enableAiChatCheckBox = new JCheckBox("启用 AI 智能助手");
        formPanel.add(enableAiChatCheckBox, gbc);

        // 提供商类型
        gbc.gridy++; gbc.gridwidth = 1;
        formPanel.add(new JLabel("服务类型:"), gbc);
        gbc.gridx = 1;
        providerTypeCombo = new JComboBox<>(new String[]{"OpenAI 兼容", "Ollama"});
        formPanel.add(providerTypeCombo, gbc);

        // Base URL
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("服务地址:"), gbc);
        gbc.gridx = 1;
        baseUrlField = new JTextField(30);
        formPanel.add(baseUrlField, gbc);

        // API Key
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("API Key (可选):"), gbc);
        gbc.gridx = 1;
        apiKeyField = new JPasswordField(30);
        formPanel.add(apiKeyField, gbc);

        // Model
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("模型名称:"), gbc);
        gbc.gridx = 1;
        modelField = new JTextField(30);
        formPanel.add(modelField, gbc);

        // 测试连接按钮
        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        testConnectionButton = new JButton("测试连接");
        testConnectionButton.addActionListener(e -> testConnection());
        formPanel.add(testConnectionButton, gbc);

        // 说明文本
        gbc.gridy++;
        JTextArea helpText = new JTextArea(
            "配置说明：\n" +
            "1. 服务类型：选择 OpenAI 兼容（支持 DeepSeek、Qwen 等）或 Ollama\n" +
            "2. 服务地址：本地部署地址，如 http://localhost:11434\n" +
            "3. API Key：云服务需要，本地部署可留空\n" +
            "4. 模型名称：如 codellama、qwen-coder、deepseek-coder 等\n\n" +
            "推荐本地模型：\n" +
            "- CodeLlama: 专为代码生成优化\n" +
            "- Qwen-Coder: 阿里通义千问代码模型\n" +
            "- DeepSeek-Coder: 深度求索代码模型"
        );
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setBackground(formPanel.getBackground());
        formPanel.add(helpText, gbc);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        
        return mainPanel;
    }

    private void testConnection() {
        try {
            String baseUrl = baseUrlField.getText().trim();
            String apiKey = new String(apiKeyField.getPassword()).trim();
            String model = modelField.getText().trim();
            
            if (baseUrl.isEmpty() || model.isEmpty()) {
                Messages.showWarningDialog("请填写服务地址和模型名称", "配置不完整");
                return;
            }

            String result = OpenAICompatibleChatClient.quickTest(baseUrl, apiKey, model, "Hello");
            Messages.showInfoMessage("连接成功！\n\n回复: " + result, "测试成功");
        } catch (Exception ex) {
            Messages.showErrorDialog("连接失败：\n" + ex.getMessage(), "测试失败");
        }
    }

    @Override
    public boolean isModified() {
        PandaCoderAISettings settings = PandaCoderAISettings.getInstance();
        
        boolean modified = enableAiChatCheckBox.isSelected() != settings.isEnableAiChat();
        modified |= !getProviderType().equals(settings.getAiProviderType());
        modified |= !baseUrlField.getText().trim().equals(settings.getAiBaseUrl());
        modified |= !new String(apiKeyField.getPassword()).trim().equals(settings.getAiApiKey());
        modified |= !modelField.getText().trim().equals(settings.getAiModel());
        
        return modified;
    }

    @Override
    public void apply() {
        PandaCoderAISettings settings = PandaCoderAISettings.getInstance();
        
        settings.setEnableAiChat(enableAiChatCheckBox.isSelected());
        settings.setAiProviderType(getProviderType());
        settings.setAiBaseUrl(baseUrlField.getText().trim());
        settings.setAiApiKey(new String(apiKeyField.getPassword()).trim());
        settings.setAiModel(modelField.getText().trim());
    }

    @Override
    public void reset() {
        PandaCoderAISettings settings = PandaCoderAISettings.getInstance();
        
        enableAiChatCheckBox.setSelected(settings.isEnableAiChat());
        providerTypeCombo.setSelectedIndex("ollama".equals(settings.getAiProviderType()) ? 1 : 0);
        baseUrlField.setText(settings.getAiBaseUrl());
        apiKeyField.setText(settings.getAiApiKey());
        modelField.setText(settings.getAiModel());
    }

    private String getProviderType() {
        return providerTypeCombo.getSelectedIndex() == 1 ? "ollama" : "openai";
    }
}
