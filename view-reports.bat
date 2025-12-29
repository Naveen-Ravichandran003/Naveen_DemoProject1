@echo off
echo ========================================
echo VIEW EXISTING TEST REPORTS
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Checking for existing reports...
echo.

REM Check and open Cucumber HTML report
if exist "target\cucumber-html-reports\report.html" (
    echo ✅ Found Cucumber HTML report
    start target\cucumber-html-reports\report.html
    echo 🌐 Cucumber report opened
) else (
    echo ❌ Cucumber HTML report not found
)

echo.

REM Check and open Allure report
if exist "target\site\allure-maven-plugin\index.html" (
    echo ✅ Found Allure HTML report
    timeout /t 2 /nobreak >nul
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure report opened
) else (
    echo ❌ Allure HTML report not found
    echo 🔄 Generating Allure report now...
    call mvn allure:report
    if exist "target\site\allure-maven-plugin\index.html" (
        start target\site\allure-maven-plugin\index.html
        echo 📈 Allure report generated and opened
    ) else (
        echo ⚠️ Could not generate Allure report, trying live server...
        start cmd /c "mvn allure:serve"
    )
)

echo.

REM Check other report formats
if exist "target\cucumber-json-reports\Cucumber.json" (
    echo ✅ Found Cucumber JSON report
) else (
    echo ❌ Cucumber JSON report not found
)

if exist "target\cucumber-xml-reports\Cucumber.xml" (
    echo ✅ Found Cucumber XML report
) else (
    echo ❌ Cucumber XML report not found
)

REM Open screenshots folder
if exist "test-screenshots" (
    echo ✅ Found screenshots folder
    timeout /t 1 /nobreak >nul
    start explorer test-screenshots
    echo 📸 Screenshots folder opened
) else (
    echo ❌ Screenshots folder not found
)

echo.
echo ========================================
echo REPORT LOCATIONS:
echo 🌐 Cucumber HTML: target\cucumber-html-reports\report.html
echo 📈 Allure HTML: target\site\allure-maven-plugin\index.html
echo 📊 JSON Reports: target\cucumber-json-reports\
echo 📄 XML Reports: target\cucumber-xml-reports\
echo 📸 Screenshots: test-screenshots\
echo ========================================

pause