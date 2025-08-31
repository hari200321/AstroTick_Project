# BDD Automation Framework with Selenium & Cucumber

A modular, scalable BDD test automation framework built using Java, Selenium WebDriver, TestNG, and Cucumber. Designed for maintainability, reusability, and seamless integration with CI/CD pipelines.

## 🔧 Features
- Modular step definitions and glue path configuration
- Shared WebDriver instance across scenarios
- Tag-based test execution
- Scenario context management
- Clear reporting with TestNG and ExtentReports
- Jenkins integration for CI/CD

## 📁 Project Structure
- `Essential_Tools.feature/` – Gherkin feature files
- `StepDefenition/` – Step definition classes
- `RunTest` – TestNG runner classes

- ## 🛠️ Setup
1. Clone the repo
2. Install dependencies (Java, Maven, TestNG, etc.)
3. Run tests using TestNG or via Jenkins

   ## 🧪 Running Tests
- Run all scenarios: `@CucumberOptions(features= {"src/test/java/features/Essential_Tools.feature"},
                       glue= {"steps"}`

- Run tagged scenarios: `@CucumberOptions(features= {"src/test/java/features/Essential_Tools.feature"},
                       glue= {"steps"},tags="@tagname"`
