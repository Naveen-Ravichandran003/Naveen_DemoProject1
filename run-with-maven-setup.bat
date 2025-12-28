@echo off
echo ========================================
echo MAVEN SETUP AND TEST EXECUTION
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/5] Locating Maven installation...

REM Check common Maven installation paths
set MAVEN_FOUND=0

REM Check if mvn is already in PATH
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    echo ✅ Maven found in PATH
    set MAVEN_FOUND=1
    goto :run_tests
)

REM Check IntelliJ bundled Maven
if exist "C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\plugins\maven\lib\maven3\bin\mvn.cmd" (
    echo ✅ Found IntelliJ bundled Maven
    set "PATH=C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\plugins\maven\lib\maven3\bin;%PATH%"
    set MAVEN_FOUND=1
    goto :run_tests
)

REM Check Program Files
if exist "C:\Program Files\Apache\maven\bin\mvn.cmd" (
    echo ✅ Found Maven in Program Files
    set "PATH=C:\Program Files\Apache\maven\bin;%PATH%"
    set MAVEN_FOUND=1
    goto :run_tests
)

REM Check Program Files (x86)
if exist "C:\Program Files (x86)\Apache\maven\bin\mvn.cmd" (
    echo ✅ Found Maven in Program Files (x86)
    set "PATH=C:\Program Files (x86)\Apache\maven\bin;%PATH%"
    set MAVEN_FOUND=1
    goto :run_tests
)

REM Check user directory
if exist "%USERPROFILE%\apache-maven\bin\mvn.cmd" (
    echo ✅ Found Maven in user directory
    set "PATH=%USERPROFILE%\apache-maven\bin;%PATH%"
    set MAVEN_FOUND=1
    goto :run_tests
)

if %MAVEN_FOUND% EQU 0 (
    echo ❌ Maven not found in common locations
    echo.
    echo Please install Maven or use IntelliJ IDEA to run tests:
    echo 1. Right-click TestRunner.java → Run 'TestRunner'
    echo 2. Or install Maven from: https://maven.apache.org/download.cgi
    echo.
    echo Alternative: Open existing reports
    if exist "target\cucumber-html-reports\report.html" (
        start target\cucumber-html-reports\report.html
        echo 🌐 Opened existing Cucumber report
    )
    pause
    exit /b 1
)

:run_tests
echo.
echo [2/5] Verifying Maven...
mvn -version

echo.
echo [3/5] Running tests...
call mvn clean test

echo.
echo [4/5] Generating Allure report...
call mvn allure:report

echo.
echo [5/5] Opening reports...
if exist "target\cucumber-html-reports\report.html" (
    start target\cucumber-html-reports\report.html
    echo 🌐 Cucumber report opened
)

if exist "target\site\allure-maven-plugin\index.html" (
    timeout /t 2 /nobreak >nul
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure report opened
)

if exist "test-screenshots" (
    timeout /t 1 /nobreak >nul
    start explorer test-screenshots
    echo 📸 Screenshots folder opened
)

echo.
echo ========================================
echo EXECUTION COMPLETED
echo ========================================
pause