@echo off
echo ========================================
echo ALLURE REPORT TROUBLESHOOTING & GENERATION
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Step 1: Checking Allure results...
if exist "target\allure-results" (
    echo ✅ Allure results found in target\allure-results
    dir target\allure-results\*.json /b | find /c ".json" > temp_count.txt
    set /p file_count=<temp_count.txt
    del temp_count.txt
    echo    Found test result files
) else (
    echo ❌ No Allure results found. Please run tests first: mvn clean test
    pause
    exit /b 1
)

echo.
echo Step 2: Generating Allure HTML report...
echo Running: mvn allure:report
call mvn allure:report

if %ERRORLEVEL% EQU 0 (
    echo ✅ Allure report generation completed
) else (
    echo ❌ Allure report generation failed
    echo.
    echo Troubleshooting options:
    echo 1. Try: mvn clean allure:report
    echo 2. Try: mvn allure:serve (starts live server)
    echo 3. Check if Allure plugin is properly configured in pom.xml
    pause
    exit /b 1
)

echo.
echo Step 3: Checking generated report...
if exist "target\site\allure-maven-plugin\index.html" (
    echo ✅ Allure HTML report found
    echo.
    echo Step 4: Opening Allure report...
    start target\site\allure-maven-plugin\index.html
    echo 📈 Allure report opened in default browser
    echo 📍 Location: target\site\allure-maven-plugin\index.html
) else (
    echo ❌ Allure HTML report not generated
    echo.
    echo Alternative solutions:
    echo.
    echo Option 1 - Use Allure Serve (Recommended):
    echo   mvn allure:serve
    echo   This starts a local server and opens the report automatically
    echo.
    echo Option 2 - Manual Allure CLI (if installed):
    echo   allure generate target\allure-results -o target\allure-report
    echo   start target\allure-report\index.html
    echo.
    echo Option 3 - View Cucumber Report instead:
    start target\cucumber-html-reports\report.html
    echo 🌐 Opened Cucumber HTML report as alternative
)

echo.
echo ========================================
echo REPORT LOCATIONS:
echo ========================================
echo 📈 Allure Report: target\site\allure-maven-plugin\index.html
echo 🌐 Cucumber Report: target\cucumber-html-reports\report.html
echo 📸 Screenshots: test-screenshots\
echo 📊 JSON Report: target\cucumber-json-reports\Cucumber.json
echo ========================================

pause