@echo off
echo ================================
echo  Mahjong Game Build and Run
echo ================================

set arg1=%1

if "%arg1%" == "" (
    echo Usage: run.bat [option]
    echo Options:
    echo   help      - Show this help message
    echo   clean     - Clean previous compilation
    echo   debug     - Compile Java files with debug information
    echo   run       - Run the Mahjong game
    echo ================================
    exit /b 0
) else if "%arg1%" == "help" (
    echo Usage: run.bat [option]
    echo Options:
    echo   help      - Show this help message
    echo   clean     - Clean previous compilation
    echo   debug     - Compile Java files with debug information
    echo   run       - Run the Mahjong game
    echo ================================
    exit /b 0
) else if "%arg1%" == "clean" (
    echo Cleaning previous compilation...
    if exist "bin\*" del /Q "bin\*"
    echo Cleaned successfully.
    echo ================================
    exit /b 0
) else if "%arg1%" == "debug" (
    set debug_flag=debug=true
    echo Compiling with debug information...
) else if "%arg1%" == "run" (
    echo Running the Mahjong game...
    set debug_flag=debug=false
) else (
    echo Invalid option: %arg1%
    echo ================================
    exit /b 1
)

REM Create bin directory if it doesn't exist
if not exist "bin" mkdir bin

REM Clean previous compilation
echo Cleaning previous compilation...
if exist "bin\*" del /Q "bin\*"

REM Compile all Java files
echo Compiling Java files...

REM First, try to compile all files that exist
javac -encoding UTF-8 -d bin -cp src\main\java src\main\java\mahjong\Main.java 2>compile_errors.txt

REM Check if compilation was successful
if %errorlevel% neq 0 (
    echo.
    echo Compilation failed! See errors below:
    type compile_errors.txt
    del compile_errors.txt 2>nul
    echo.
    pause
    exit /b 1
) else (
    echo Main.java compiled successfully!
    del compile_errors.txt 2>nul
)

REM Try to compile other packages if they exist
echo Compiling additional packages (if any)...
for /d %%d in (src\main\java\mahjong\*) do (
    if exist "%%d\*.java" (
        echo Compiling %%d...
        javac -encoding UTF-8 -d bin -cp "bin;src\main\java" %%d\*.java 2>nul
    )
)

REM Run the program
echo.
echo Compilation complete!
echo Launching Mahjong Game in new window...
echo ================================

if defined debug_flag (
    start "Mahjong Game" cmd /c "chcp 65001 >nul && java -Dfile.encoding=UTF-8 -cp bin mahjong.Main %debug_flag% && echo. && echo Game finished. && pause && exit /b 0"
) else (
    start "Mahjong Game" cmd /c "chcp 65001 >nul && java -Dfile.encoding=UTF-8 -cp bin mahjong.Main && echo. && echo Game finished. && pause && exit /b 0"
)

echo Game launched in new window!
echo You can close this compilation window now.
echo ================================

