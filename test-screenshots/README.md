# Test Screenshots Directory

This directory contains screenshots captured during test execution:

## Screenshot Types:
- **Positive Test Screenshots**: Successful test execution evidence
- **Negative Test Screenshots**: Failed test scenarios for debugging
- **Error Screenshots**: Captured when tests encounter unexpected issues

## Naming Convention:
- `test_scenario_YYYYMMDD_HHMMSS.png` - Regular test screenshots
- `failed_[TEST_NAME]_YYYYMMDD_HHMMSS.png` - Failed test screenshots
- `negative_test_error_YYYYMMDD_HHMMSS.png` - Negative test screenshots

## Usage:
Screenshots are automatically captured by the ScreenshotUtils class during test execution and can be viewed through the test reports or by opening this folder directly.

**Note**: Screenshot files (*.png) are excluded from git tracking to keep repository size manageable, but this folder structure is maintained for reference.