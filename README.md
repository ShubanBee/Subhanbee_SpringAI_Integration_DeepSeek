# Subhanbee_SpringAI_Integration_DeepSeek
# Spring AI DeepSeek Chat Application

A web-based AI chat application built with Spring Boot and Spring AI, integrated with Ollama for running DeepSeek AI models locally.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Troubleshooting](#troubleshooting)
- [Future Enhancements](#future-enhancements)

## 🚀 Overview

This application provides a user-friendly interface to interact with DeepSeek AI models running locally via Ollama. It demonstrates the integration of Spring Boot with Spring AI's Ollama module, offering both synchronous and streaming responses.

## ✨ Features

- **Interactive Web Interface**: Clean, responsive chat UI with background image
- **Real-time AI Responses**: Get instant answers from DeepSeek AI
- **Streaming Support**: Optional streaming responses for better UX
- **Toggle Response Display**: Click to show/hide AI responses
- **Spring AI Integration**: Leverages Spring AI's Ollama starter
- **RESTful API**: Easy-to-use API endpoints for AI interactions

## 🛠 Technology Stack

| Technology | Version |
|------------|---------|
| Spring Boot | 4.0.5 |
| Spring AI | 2.0.0-M4 |
| Java | 25 |
| Thymeleaf | (Spring Boot Starter) |
| Ollama | Latest |
| DeepSeek Model | (via Ollama) |
| Maven | 4.0.0 |

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

1. **Java 25** or later
   ```bash
   java --version

2.Maven (or use Maven Wrapper)
  ```bash
  mvn --version

3.Ollama
Linux/Mac:
  ``` bash
curl -fsSL https://ollama.com/install.sh | sh
Windows: Download from ollama.com
Verify installation:
  ```bash
ollama --version

4.DeepSeek Model in Ollama
  ```bash
# Pull the DeepSeek model (choose one)
ollama pull deepseek-r1:7b  # Recommended for most systems
# OR
ollama pull deepseek-coder:6.7b  # For coding-specific tasks


🔧 Installation & Setup
1. Clone the Repository (if applicable)
  ```bash
  git clone <your-repository-url>
  cd spring-ai-deepseek01

2. Verify Project Configuration
Ensure your pom.xml has the correct dependencies (already configured):
Spring Boot Web MVC
Spring AI Ollama Starter
Thymeleaf template engine

3. Configure Ollama Connection
Create an application.properties or application.yml file in src/main/resources/:
application.properties:
properties
# Server Configuration
server.port=8080
# Ollama Configuration
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.options.model=deepseek-r1:7b
spring.ai.ollama.chat.options.temperature=0.7
# Optional: Increase timeout for long responses
spring.ai.ollama.chat.options.timeout=120s
Or application.yml:

yaml
server:
  port: 8080

spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        options:
          model: deepseek-r1:7b
          temperature: 0.7
          timeout: 120s

  thymeleaf:
    cache: false
    prefix: classpath:/templates/
    suffix: .html


🏃 Running the Application
Method 1: Using Maven
bash
# Clean and compile
mvn clean compile

# Run the application
mvn spring-boot:run
Method 2: Using JAR file
bash
# Package the application
mvn clean package

# Run the JAR
java -jar target/spring-ai-deepseek01-0.0.1-SNAPSHOT.jar
Method 3: From IDE
Simply run the SpringAiDeepseek01Application main class in your IDE.


💻 Usage
Web Interface
Open your browser and navigate to:

text
http://localhost:8080
Enter your question in the input field
Example: "Explain quantum computing in simple terms"
Example: "Write a Python function to reverse a string"
Click "Send" or press Enter
View the response: Click on the checkmark ✔ to toggle the response display
API Endpoints

1. Synchronous Prompt
bash
GET http://localhost:8080/api/ai/prompt?question=What is Spring Boot?
Response: Plain text response from AI

text
Spring Boot is a Java-based framework used to create microservices...
cURL example:

```bash
curl "http://localhost:8080/api/ai/prompt?question=What%20is%20artificial%20intelligence"
2. Streaming Prompt
bash
GET http://localhost:8080/api/ai/prompt/stream?question=Tell me a joke
Response: Server-Sent Events (SSE) stream

text
data: Why
data:  don't
data:  scientists
data:  trust
data:  atoms?
data:  Because
data:  they
data:  make
data:  up
data:  everything!


📁 Project Structure
text
spring-ai-deepseek01/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ollama-deepseek/
│   │   │           └── spring-ai-deepseek01/
│   │   │               ├── SpringAiDeepseek01Application.java
│   │   │               ├── controller/
│   │   │               │   ├── HomeController.java
│   │   │               │   └── ChatAIController.java
│   │   │               └── service/
│   │   │                   └── ChatAIService.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html
│   │       └── application.properties
│   └── test/
│       └── java/
└── pom.xml


🔍 Troubleshooting
Common Issues and Solutions
1. Ollama Connection Refused
text
Error: Connection refused: localhost/127.0.0.1:11434
Solution: Start Ollama service
```bash
# Linux/Mac
ollama serve

# Windows (Run as Administrator)
ollama serve
2. Model Not Found
text
Error: model "deepseek-r1:7b" not found
Solution: Pull the model first

```bash
ollama pull deepseek-r1:7b
3. Port 8080 Already in Use
text
Web server failed to start. Port 8080 was already in use.
Solution: Change port in application.properties

properties
server.port=8081
4. Java Version Incompatibility
text
Unsupported class file major version
Solution: Install Java 25 or update your JAVA_HOME

bash
# Check Java version
java -version

# If needed, install Java 25
# Windows: Download from Oracle
# Ubuntu: sudo apt install openjdk-25-jdk
5. Slow Responses
Solution: Adjust model parameters in application.properties

properties
# Reduce response length or adjust temperature
spring.ai.ollama.chat.options.num-predict=256
spring.ai.ollama.chat.options.temperature=0.5
🎯 Future Enhancements
Add conversation memory/history
Implement user authentication
Add markdown rendering for responses
Support multiple AI models
Add voice input capability
Implement chat export functionality
Add response rating system
Docker containerization
Add WebSocket for real-time bidirectional communication
Implement rate limiting and API keys
