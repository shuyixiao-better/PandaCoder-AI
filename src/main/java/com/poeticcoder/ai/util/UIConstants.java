package com.poeticcoder.ai.util;

import com.intellij.ui.JBColor;
import java.awt.Color;

/**
 * UI 常量定义
 * 统一管理界面样式常量
 */
public class UIConstants {
    // 字体大小
    public static final float FONT_SIZE_TITLE = 16.0f;
    public static final float FONT_SIZE_INPUT = 13.0f;
    
    // 间距
    public static final int PADDING_SMALL = 4;
    public static final int PADDING_MEDIUM = 8;
    public static final int PADDING_LARGE = 12;
    
    // 圆角半径
    public static final int ARC_RADIUS = 8;
    
    // 按钮颜色
    public static final Color PRIMARY_BUTTON_BACKGROUND = new JBColor(
        new Color(0x4A90E2),  // 亮色主题
        new Color(0x3A7BC8)   // 暗色主题
    );
    public static final Color PRIMARY_BUTTON_FOREGROUND = JBColor.WHITE;
    
    // Toggle 按钮颜色
    public static final Color TOGGLE_BUTTON_SELECTED_BG = new JBColor(
        new Color(0x4A90E2),
        new Color(0x3A7BC8)
    );
    public static final Color TOGGLE_BUTTON_UNSELECTED_BG = new JBColor(
        new Color(0xF0F0F0),
        new Color(0x3C3F41)
    );
    
    // 消息气泡颜色
    public static final Color USER_BUBBLE_BACKGROUND = new JBColor(
        new Color(0xE3F2FD),  // 浅蓝色
        new Color(0x2B3E50)   // 深蓝色
    );
    public static final Color ASSISTANT_BUBBLE_BACKGROUND = new JBColor(
        new Color(0xF5F5F5),  // 浅灰色
        new Color(0x3C3F41)   // 深灰色
    );
    public static final Color CONTEXT_BUBBLE_BACKGROUND = new JBColor(
        new Color(0xFFF9E6),  // 浅黄色
        new Color(0x4A4A3A)   // 深黄色
    );
    
    // Chip 颜色
    public static final Color CHIP_BACKGROUND = new JBColor(
        new Color(0xE0E0E0),
        new Color(0x4A4A4A)
    );
}
