@echo off
echo ========================================
echo ALLURE REPORT GENERATOR AND VIEWER
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/3] Generating Allure report...
call mvn allure:report

if %ERRORLEVEL% EQU 0 (
    echo ✅ Allure report generated successfully
    
    echo [2/3] Starting Allure server...
    echo This will open the report in your browser automatically
    echo Press Ctrl+C to stop the server when done viewing
    echo.
    
    call mvn allure:serve
) else (
    echo ❌ Failed to generate Allure report
    echo Trying to serve existing results...
    call mvn allure:serve
)

echo.
echo [3/3] Server stopped.
pause