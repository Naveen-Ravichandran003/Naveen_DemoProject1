@echo off
echo ========================================
echo GENERATING AND OPENING ALLURE REPORT
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Step 1: Generating Allure report from test results...
mvn allure:report

if %ERRORLEVEL% EQU 0 (
    echo ✅ Allure report generated successfully
    
    echo.
    echo Step 2: Opening Allure report...
    
    if exist "target\site\allure-maven-plugin\index.html" (
        start target\site\allure-maven-plugin\index.html
        echo 📈 Allure report opened in browser
    ) else (
        echo ❌ Allure report file not found
    )
) else (
    echo ❌ Failed to generate Allure report
    echo Please ensure tests have been run first: mvn clean test
)

echo.
echo Alternative: Run 'mvn allure:serve' for live server
pause