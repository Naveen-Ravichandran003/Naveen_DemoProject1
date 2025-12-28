# Maven Not Found - Alternative Execution Methods

## ❌ **Issue:** Maven not in PATH
The error indicates Maven is not installed or not added to system PATH.

## ✅ **Immediate Solutions:**

### **Option 1: Use IntelliJ IDEA (Recommended)**
1. Open IntelliJ IDEA
2. Navigate to `src/test/java/com/acme/runners/TestRunner.java`
3. **Right-click** → **Run 'TestRunner'**
4. Tests will execute and reports will open automatically

### **Option 2: Use Maven Setup Script**
```bash
run-with-maven-setup.bat
```
This script will:
- 🔍 Find Maven in common installation locations
- ⚙️ Set up PATH automatically
- 🚀 Run tests and generate reports

### **Option 3: Install Maven**
1. Download from: https://maven.apache.org/download.cgi
2. Extract to `C:\Program Files\Apache\maven`
3. Add `C:\Program Files\Apache\maven\bin` to PATH
4. Restart command prompt
5. Run: `mvn clean test`

### **Option 4: Use IntelliJ Terminal**
1. Open IntelliJ IDEA
2. Open **Terminal** (bottom panel)
3. Run: `mvn clean test`
   (IntelliJ automatically configures Maven PATH)

## 📊 **Current Available Reports:**
- 🌐 **Cucumber Report**: `target/cucumber-html-reports/report.html`
- 📸 **Screenshots**: `test-screenshots/`
- 📊 **JSON Report**: `target/cucumber-json-reports/Cucumber.json`

## 🎯 **Recommended Action:**
**Use IntelliJ IDEA** - Right-click `TestRunner.java` → Run
This bypasses the Maven PATH issue and executes tests directly.