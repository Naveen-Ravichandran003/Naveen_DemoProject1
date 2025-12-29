@echo off
echo ========================================
echo ALLURE REPORT - QUICK VIEW
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Checking for Allure installation...
where allure >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ⚠️ Allure CLI not found. Using Maven instead...
    goto maven_method
)

echo [1/2] Generating Allure report with CLI...
allure generate target/allure-results --clean -o target/allure-report

if %ERRORLEVEL% EQU 0 (
    echo ✅ Report generated successfully
    echo [2/2] Opening Allure report...
    allure open target/allure-report
    goto end
)

:maven_method
echo [1/2] Generating report with Maven...
call mvn allure:report

echo [2/2] Starting Allure server...
echo Browser will open automatically
echo Press Ctrl+C to stop server
call mvn allure:serve

:end
echo.
echo Report session ended.
pause