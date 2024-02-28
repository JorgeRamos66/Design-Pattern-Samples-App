@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Script de inicio de Gradle para Windows
@rem
@rem ##########################################################################

@rem Establecer el alcance local para las variables con el shell de Windows NT
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Agregue aquí las opciones predeterminadas de JVM. También puedes usar JAVA_OPTS y GRADLE_OPTS para pasar opciones de JVM a este script.
set DEFAULT_JVM_OPTS=

@rem Encuentra java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Obtenga argumentos de línea de comandos, manejando variantes de Windows

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Sorbe los argumentos de la línea de comando.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Configurar la línea de comando

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

@rem Ejecutar Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

:end
@rem Finalizar el alcance local para las variables con el shell de Windows NT
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Establezca la variable GRADLE_EXIT_CONSOLE si necesita el código de retorno _script_ en lugar de 
rem el código de retorno _cmd.exe /c_!
if  not "" == "%GRADLE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
