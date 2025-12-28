@echo off
echo ========================================
echo COMPLETE TEST EXECUTION AND REPORTING
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/4] Cleaning and running tests...
call mvn clean test

if %ERRORLEVEL% EQU 0 (
    echo ✅ Tests completed successfully
) else (
    echo ⚠️ Tests completed with some failures (expected for negative tests)
)

echo.
echo [2/4] Generating Allure report...
call mvn allure:report

echo.
echo [3/4] Opening reports...

REM Open Cucumber report
if exist "target\cucumber-html-reports\report.html" (
    start target\cucumber-html-reports\report.html
    echo 🌐 Cucumber report opened
)

REM Open Allure report
if exist "target\site\allure-maven-plugin\index.html" (
    timeout /t 2 /nobreak >nul
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure report opened
) else (
    echo ⚠️ Allure report not found, trying allure:serve...
    start cmd /c "mvn allure:serve"
)

REM Open screenshots folder
if exist "test-screenshots" (
    timeout /t 1 /nobreak >nul
    start explorer test-screenshots
    echo 📸 Screenshots folder opened
)

echo.
echo [4/4] Execution completed!
echo ========================================
echo REPORTS AVAILABLE:
echo 🌐 Cucumber: target\cucumber-html-reports\report.html
echo 📈 Allure: target\site\allure-maven-plugin\index.html
echo 📸 Screenshots: test-screenshots\
echo 📊 JSON: target\cucumber-json-reports\Cucumber.json
echo ========================================

pause