@echo off
echo ========================================
echo GENERATE AND OPEN ALL TEST REPORTS
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/3] Generating Allure HTML report...
call mvn allure:report

echo.
echo [2/3] Opening all reports...

REM Open Cucumber HTML report
if exist "target\cucumber-html-reports\report.html" (
    start target\cucumber-html-reports\report.html
    echo 🌐 Cucumber HTML report opened
) else (
    echo ⚠️ Cucumber HTML report not found
)

REM Wait and open Allure report
timeout /t 2 /nobreak >nul
if exist "target\site\allure-maven-plugin\index.html" (
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure HTML report opened
) else (
    echo ⚠️ Allure HTML report not found, trying allure:serve...
    start cmd /c "mvn allure:serve"
)

REM Open screenshots folder
timeout /t 1 /nobreak >nul
if exist "test-screenshots" (
    start explorer test-screenshots
    echo 📸 Screenshots folder opened
)

echo.
echo [3/3] Report generation completed!
echo ========================================
echo AVAILABLE REPORTS:
echo 🌐 Cucumber HTML: target\cucumber-html-reports\report.html
echo 📈 Allure HTML: target\site\allure-maven-plugin\index.html
echo 📊 Cucumber JSON: target\cucumber-json-reports\Cucumber.json
echo 📄 Cucumber XML: target\cucumber-xml-reports\Cucumber.xml
echo 📸 Screenshots: test-screenshots\
echo ========================================

pause