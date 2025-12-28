@echo off
echo ========================================
echo ALLURE SERVE - LIVE REPORT SERVER
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Starting Allure live server...
echo This will automatically open the report in your browser
echo.
echo Note: Press Ctrl+C to stop the server when done viewing
echo.

mvn allure:serve

echo.
echo Server stopped.
pause