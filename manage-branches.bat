@echo off
echo ========================================
echo BRANCH MANAGEMENT OPTIONS
echo ========================================

cd /d "C:\Users\KANNAN\IdeaProjects\DemoProject-Amazon Q"

echo Current situation:
echo - main branch: Original empty repository
echo - Naveen_Demo branch: Complete automation framework
echo - Branches have different commit histories (no common ancestor)
echo.

echo Available options:
echo.
echo [1] Keep Naveen_Demo as main development branch (Recommended)
echo     - Continue development on Naveen_Demo
echo     - Set Naveen_Demo as default branch on GitHub
echo.
echo [2] Replace main branch content with Naveen_Demo
echo     - Merge with allow-unrelated-histories
echo     - This will combine both histories
echo.
echo [3] Create Pull Request on GitHub
echo     - Go to GitHub repository
echo     - Create PR from Naveen_Demo to main
echo     - Choose merge strategy on GitHub
echo.

set /p choice="Enter your choice (1, 2, or 3): "

if "%choice%"=="1" (
    echo.
    echo ✅ Recommended: Keep using Naveen_Demo branch
    echo.
    echo Next steps:
    echo 1. Go to GitHub repository settings
    echo 2. Change default branch from 'main' to 'Naveen_Demo'
    echo 3. Continue development on Naveen_Demo branch
    echo.
    echo Your automation framework is ready on Naveen_Demo branch!
    
) else if "%choice%"=="2" (
    echo.
    echo Merging Naveen_Demo into main with unrelated histories...
    git checkout main
    git merge Naveen_Demo --allow-unrelated-histories -m "Merge automation framework from Naveen_Demo branch"
    
    if %ERRORLEVEL% EQU 0 (
        echo ✅ Successfully merged Naveen_Demo into main
        git push origin main
        echo ✅ Pushed updated main branch to remote
    ) else (
        echo ❌ Merge failed - manual resolution may be needed
    )
    
) else if "%choice%"=="3" (
    echo.
    echo ✅ Create Pull Request on GitHub:
    echo.
    echo 1. Go to: https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1
    echo 2. Click "Compare & pull request" for Naveen_Demo branch
    echo 3. Choose merge strategy (Create merge commit, Squash and merge, or Rebase)
    echo 4. Complete the pull request
    echo.
    start https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1/compare/main...Naveen_Demo
    
) else (
    echo Invalid choice. Please run the script again.
)

echo.
pause