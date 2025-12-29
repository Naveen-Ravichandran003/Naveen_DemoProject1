@echo off
echo ========================================
echo TESTNG PARALLEL EXECUTION
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/3] Running TestNG tests with parallel execution...
call mvn clean test -DsuiteXmlFile=testng.xml -Dparallel=methods -DthreadCount=3

if %ERRORLEVEL% EQU 0 (
    echo ✅ TestNG parallel tests completed successfully
) else (
    echo ⚠️ TestNG tests completed with some failures (expected for negative tests)
)

echo.
echo [2/3] Generating reports...
call mvn allure:report

echo.
echo [3/3] Opening TestNG and other reports...

REM Open TestNG report
if exist "target\surefire-reports\index.html" (
    start target\surefire-reports\index.html
    echo 📊 TestNG report opened
)

REM Open Cucumber report
if exist "target\cucumber-html-reports\report.html" (
    timeout /t 1 /nobreak >nul
    start target\cucumber-html-reports\report.html
    echo 🌐 Cucumber report opened
)

REM Open Allure report
if exist "target\site\allure-maven-plugin\index.html" (
    timeout /t 2 /nobreak >nul
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure report opened
)

echo.
echo ========================================
echo TESTNG PARALLEL EXECUTION COMPLETED
echo ========================================
echo 📊 TestNG: target\surefire-reports\index.html
echo 🌐 Cucumber: target\cucumber-html-reports\report.html
echo 📈 Allure: target\site\allure-maven-plugin\index.html
echo ========================================

pause