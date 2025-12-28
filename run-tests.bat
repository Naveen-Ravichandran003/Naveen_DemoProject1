@echo off
echo Starting Test Execution...

echo.
echo ========================================
echo Running Cucumber Tests
echo ========================================
mvn clean test

echo.
echo ========================================
echo Generating Allure Report
echo ========================================
mvn allure:report

echo.
echo ========================================
echo Test Execution Complete
echo ========================================
echo.
echo Reports Generated:
echo - Cucumber HTML Report: target\cucumber-reports\index.html
echo - Allure Report: target\site\allure-maven-plugin\index.html
echo - Screenshots: test-screenshots\
echo.
echo To view Allure report, run: mvn allure:serve
echo.
pause