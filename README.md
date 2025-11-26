# PandaCoder AI

<div align="center">

![Version](https://img.shields.io/badge/Version-1.0.0-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Platform](https://img.shields.io/badge/Platform-IntelliJ%20IDEA-orange)

**你的本地化智能编程伙伴**

[English](#english) | [中文](#中文)

</div>

---

## 🇨🇳 中文

### PandaCoder AI —— 你的本地化智能编程伙伴

**在数据安全与开发效率之间，不必妥协。**

PandaCoder AI 是一款专为 JetBrains IDE（如 IntelliJ IDEA）打造的智能编码插件，支持无缝对接本地或内网部署的大模型（如 CodeLlama、Qwen-Coder、DeepSeek 等），让你在完全离线或隔离网络环境中，依然享受 AI 驱动的代码生成、补全与解释能力。

无论你是金融、政务或企业的开发者，还是注重代码隐私的独立工程师，PandaCoder AI 都让你掌控数据主权——**所有代码请求均在本地处理，绝不外传**。

轻量、灵活、可配置，它不只是另一个 Copilot，而是为你量身定制的安全、自主、高效的 AI 编程入口。

**让智能回归本地，让编码专注创造。**

### ✨ 核心特性

- 🔒 **数据安全**：所有代码请求在本地处理，绝不外传
- 🚀 **本地部署**：支持 Ollama、CodeLlama、Qwen-Coder、DeepSeek 等本地模型
- 💬 **Chat 模式**：智能问答，代码解释，技术咨询
- 🤖 **Agent 模式**：代码生成，自动应用到编辑器
- 📎 **上下文感知**：支持 @类名、@文件路径绑定项目上下文
- 🎯 **精准定位**：自动识别代码元素，快速跳转
- 🔄 **多会话管理**：支持多个独立对话会话
- ⚡ **快速响应**：本地模型，无网络延迟

### 🚀 快速开始

#### 1. 安装本地 LLM 服务

推荐使用 [Ollama](https://ollama.ai/)：

```bash
# macOS / Linux
curl -fsSL https://ollama.ai/install.sh | sh

# 下载推荐模型
ollama pull codellama
ollama pull qwen-coder
ollama pull deepseek-coder
```

#### 2. 配置插件

1. 打开 IntelliJ IDEA
2. 进入 `Settings` > `Tools` > `PandaCoder AI`
3. 配置服务信息：
   - **服务类型**：选择 `Ollama` 或 `OpenAI 兼容`
   - **服务地址**：`http://localhost:11434`（Ollama 默认地址）
   - **模型名称**：`codellama`、`qwen-coder` 或 `deepseek-coder`
4. 点击"测试连接"验证配置
5. 勾选"启用 AI 智能助手"

#### 3. 开始使用

1. 打开 `PandaCoder AI` 工具窗口（右侧边栏）
2. 选择 Chat 或 Agent 模式
3. 输入问题或需求，按 Enter 发送
4. 使用 `@ClassName` 或 `@FilePath` 绑定上下文

### 📖 使用示例

#### Chat 模式 - 代码解释

```
请解释一下 @UserService 这个类的作用
```

#### Agent 模式 - 代码生成

```
为 @UserController 添加一个分页查询用户的接口
```

#### 上下文绑定

```
@com.example.service.UserService
@src/main/java/com/example/model/User.java

请帮我优化这两个文件的代码
```

### 🎯 推荐模型

| 模型 | 特点 | 适用场景 |
|------|------|----------|
| **CodeLlama** | Meta 开源，专为代码优化 | 代码生成、补全 |
| **Qwen-Coder** | 阿里通义千问代码模型 | 中文代码注释、文档 |
| **DeepSeek-Coder** | 深度求索代码模型 | 复杂逻辑推理 |

### 🔧 高级配置

#### 使用 OpenAI 兼容 API

如果你使用 DeepSeek、Qwen 等云服务：

```
服务类型：OpenAI 兼容
服务地址：https://api.deepseek.com
API Key：your-api-key
模型名称：deepseek-coder
```

#### 内网部署

PandaCoder AI 完全支持内网环境，只需确保：
1. 本地或内网有 LLM 服务运行
2. 配置正确的服务地址
3. 网络可达即可

### 🛡️ 安全保障

- ✅ 所有代码请求在本地处理
- ✅ 不依赖外部云服务
- ✅ 支持完全离线环境
- ✅ 数据不会被上传或存储
- ✅ 符合企业安全合规要求

### 📝 系统要求

- IntelliJ IDEA 2023.2 或更高版本
- Java 17 或更高版本
- 本地 LLM 服务（如 Ollama）

### 🤝 支持与反馈

- 官网：[https://www.poeticcoder.com](https://www.poeticcoder.com)
- 问题反馈：[GitHub Issues](https://github.com/poeticcoder/pandacoder-ai/issues)

---

## 🇬🇧 English

### PandaCoder AI — Your On-Prem AI Coding Companion

**Code smarter, without compromising security.**

PandaCoder AI is a JetBrains IDE plugin designed for developers who demand both AI-powered coding and full data control. It seamlessly integrates with your local or on-premises LLMs—such as CodeLlama, Qwen-Coder, or DeepSeek—enabling intelligent code generation, completion, and explanation entirely within your private network.

**No cloud dependency. No data leakage. Just pure, responsive AI assistance where your code lives.**

Whether you're in finance, government, enterprise, or simply privacy-conscious, PandaCoder AI puts you in control: all requests stay on your machine, and your code never leaves your environment.

**AI that respects your boundaries. Code that flows with confidence.**

### ✨ Key Features

- 🔒 **Data Security**: All code requests processed locally, never transmitted
- 🚀 **Local Deployment**: Support Ollama, CodeLlama, Qwen-Coder, DeepSeek and more
- 💬 **Chat Mode**: Intelligent Q&A, code explanation, technical consulting
- 🤖 **Agent Mode**: Code generation, auto-apply to editor
- 📎 **Context Aware**: Support @ClassName, @FilePath to bind project context
- 🎯 **Precise Location**: Auto-recognize code elements, quick navigation
- 🔄 **Multi-Session**: Support multiple independent conversation sessions
- ⚡ **Fast Response**: Local models, no network latency

### 🚀 Quick Start

#### 1. Install Local LLM Service

Recommended: [Ollama](https://ollama.ai/)

```bash
# macOS / Linux
curl -fsSL https://ollama.ai/install.sh | sh

# Download recommended models
ollama pull codellama
ollama pull qwen-coder
ollama pull deepseek-coder
```

#### 2. Configure Plugin

1. Open IntelliJ IDEA
2. Go to `Settings` > `Tools` > `PandaCoder AI`
3. Configure service:
   - **Service Type**: Select `Ollama` or `OpenAI Compatible`
   - **Service URL**: `http://localhost:11434` (Ollama default)
   - **Model Name**: `codellama`, `qwen-coder`, or `deepseek-coder`
4. Click "Test Connection" to verify
5. Enable "Enable AI Assistant"

#### 3. Start Using

1. Open `PandaCoder AI` tool window (right sidebar)
2. Choose Chat or Agent mode
3. Type your question or requirement, press Enter
4. Use `@ClassName` or `@FilePath` to bind context

### 📖 Usage Examples

#### Chat Mode - Code Explanation

```
Please explain the purpose of @UserService class
```

#### Agent Mode - Code Generation

```
Add a paginated user query endpoint to @UserController
```

#### Context Binding

```
@com.example.service.UserService
@src/main/java/com/example/model/User.java

Please help optimize these two files
```

### 🎯 Recommended Models

| Model | Features | Use Cases |
|-------|----------|-----------|
| **CodeLlama** | Meta open-source, optimized for code | Code generation, completion |
| **Qwen-Coder** | Alibaba Qwen code model | Chinese comments, documentation |
| **DeepSeek-Coder** | DeepSeek code model | Complex logic reasoning |

### 🔧 Advanced Configuration

#### Using OpenAI Compatible API

For cloud services like DeepSeek, Qwen:

```
Service Type: OpenAI Compatible
Service URL: https://api.deepseek.com
API Key: your-api-key
Model Name: deepseek-coder
```

#### On-Premises Deployment

PandaCoder AI fully supports on-premises environments:
1. Run LLM service locally or on internal network
2. Configure correct service URL
3. Ensure network accessibility

### 🛡️ Security Guarantees

- ✅ All code requests processed locally
- ✅ No external cloud service dependency
- ✅ Support fully offline environment
- ✅ Data never uploaded or stored
- ✅ Compliant with enterprise security requirements

### 📝 System Requirements

- IntelliJ IDEA 2023.2 or higher
- Java 17 or higher
- Local LLM service (e.g., Ollama)

### 🤝 Support & Feedback

- Website: [https://www.poeticcoder.com](https://www.poeticcoder.com)
- Issues: [GitHub Issues](https://github.com/poeticcoder/pandacoder-ai/issues)

---

## 📄 License

MIT License - see [LICENSE](LICENSE) file for details

---

<div align="center">

**Made with ❤️ by Poetic Coder**

[Website](https://www.poeticcoder.com) • [Documentation](https://docs.poeticcoder.com) • [Community](https://community.poeticcoder.com)

</div>
