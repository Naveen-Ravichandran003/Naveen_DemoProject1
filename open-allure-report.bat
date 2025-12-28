@echo off
echo ========================================
echo OPENING ALLURE REPORT
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/2] Generating Allure report...
call mvn allure:report

echo.
echo [2/2] Opening Allure report...

REM Check if Allure report exists and open it
if exist "target\site\allure-maven-plugin\index.html" (
    start target\site\allure-maven-plugin\index.html
    echo ✅ Allure report opened: target\site\allure-maven-plugin\index.html
) else (
    echo ❌ Allure report not found. Please run tests first.
    echo Run: mvn clean test
)

echo.
echo Alternative: Use mvn allure:serve for live server
echo.
pause