@echo off
echo ========================================
echo VIEW CI/CD ALLURE REPORTS
echo ========================================

echo This script helps you view Allure reports from CI/CD artifacts
echo.

echo Step 1: Download CI/CD Artifacts
echo 1. Go to: https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1/actions
echo 2. Click on latest workflow run
echo 3. Download "test-results" artifact
echo 4. Extract the zip file
echo.

echo Step 2: Navigate to extracted folder
echo Look for one of these folders in the extracted artifact:
echo   - target/site/allure-maven-plugin/
echo   - target/allure-html-report/
echo.

echo Step 3: View the report
echo Option A: Open index.html directly in browser
echo Option B: Use this script after extracting
echo.

set /p "extracted_path=Enter path to extracted artifact folder (or press Enter to skip): "

if "%extracted_path%"=="" (
    echo.
    echo Manual steps:
    echo 1. Navigate to extracted folder
    echo 2. Go to target/site/allure-maven-plugin/
    echo 3. Open index.html in browser
    echo.
    pause
    exit /b
)

if exist "%extracted_path%\target\site\allure-maven-plugin\index.html" (
    echo ✅ Found Allure Maven report
    start "%extracted_path%\target\site\allure-maven-plugin\index.html"
) else if exist "%extracted_path%\target\allure-html-report\index.html" (
    echo ✅ Found Allure HTML report
    start "%extracted_path%\target\allure-html-report\index.html"
) else (
    echo ❌ Allure report not found in specified path
    echo Please check the path and try again
)

pause