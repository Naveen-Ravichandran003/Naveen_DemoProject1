@echo off
echo ========================================
echo EXECUTING ACME SELENIUM TESTS NOW
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo [1/3] Compiling project...
call mvn compile test-compile

echo.
echo [2/3] Running Cucumber tests...
call mvn test

echo.
echo [3/3] Generating reports...
call mvn allure:report

echo.
echo ========================================
echo TEST EXECUTION COMPLETED
echo ========================================
echo.
echo Reports will open automatically...
echo - Cucumber HTML: target\cucumber-html-reports\report.html
echo - Screenshots: test-screenshots\
echo - Allure: target\site\allure-maven-plugin\index.html
echo.

REM Open reports automatically
if exist "target\cucumber-html-reports\report.html" (
    start target\cucumber-html-reports\report.html
    echo Cucumber report opened
)

if exist "test-screenshots" (
    start explorer test-screenshots
    echo Screenshots folder opened
)

if exist "target\site\allure-maven-plugin\index.html" (
    start target\site\allure-maven-plugin\index.html
    echo Allure report opened
)

pause