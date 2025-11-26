package com.poeticcoder.ai.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PandaCoder AI 插件设置
 * 存储 AI 服务配置信息
 */
@State(
    name = "PandaCoderAISettings",
    storages = @Storage("pandacoder-ai-settings.xml")
)
public class PandaCoderAISettings implements PersistentStateComponent<PandaCoderAISettings> {

    // AI 服务配置
    private boolean enableAiChat = false;
    private String aiProviderType = "openai"; // openai/ollama
    private String aiBaseUrl = "http://localhost:11434"; // 默认 Ollama 地址
    private String aiApiKey = "";
    private String aiModel = "codellama"; // 默认模型

    // 单例模式获取实例
    public static PandaCoderAISettings getInstance() {
        return com.intellij.openapi.application.ApplicationManager.getApplication()
            .getService(PandaCoderAISettings.class);
    }

    // Getters and Setters
    public boolean isEnableAiChat() {
        return enableAiChat;
    }

    public void setEnableAiChat(boolean enableAiChat) {
        this.enableAiChat = enableAiChat;
    }

    public String getAiProviderType() {
        if (aiProviderType == null || aiProviderType.isEmpty()) {
            aiProviderType = "openai";
        }
        return aiProviderType;
    }

    public void setAiProviderType(String aiProviderType) {
        this.aiProviderType = aiProviderType;
    }

    public String getAiBaseUrl() {
        return aiBaseUrl == null ? "" : aiBaseUrl;
    }

    public void setAiBaseUrl(String aiBaseUrl) {
        this.aiBaseUrl = aiBaseUrl;
    }

    public String getAiApiKey() {
        return aiApiKey == null ? "" : aiApiKey;
    }

    public void setAiApiKey(String aiApiKey) {
        this.aiApiKey = aiApiKey;
    }

    public String getAiModel() {
        if (aiModel == null || aiModel.isEmpty()) {
            aiModel = "codellama";
        }
        return aiModel;
    }

    public void setAiModel(String aiModel) {
        this.aiModel = aiModel;
    }

    @Nullable
    @Override
    public PandaCoderAISettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull PandaCoderAISettings state) {
        XmlSerializerUtil.copyBean(state, this);
        
        // 确保默认值
        if (this.aiProviderType == null || this.aiProviderType.isEmpty()) {
            this.aiProviderType = "openai";
        }
        if (this.aiBaseUrl == null) {
            this.aiBaseUrl = "http://localhost:11434";
        }
        if (this.aiApiKey == null) {
            this.aiApiKey = "";
        }
        if (this.aiModel == null || this.aiModel.isEmpty()) {
            this.aiModel = "codellama";
        }
    }
}
