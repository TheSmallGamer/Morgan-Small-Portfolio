::::::::::::::::::::::::::::::::::::::::::::
:: Elevate.cmd - Version 4
:: Automatically check & get admin rights
:: see "https://stackoverflow.com/a/12264592/1016343" for description
::::::::::::::::::::::::::::::::::::::::::::
 @echo off
 CLS
 ECHO.
 ECHO =============================
 ECHO Running Admin shell
 ECHO =============================

:init
 setlocal DisableDelayedExpansion
 set cmdInvoke=1
 set winSysFolder=System32
 set "batchPath=%~0"
 for %%k in (%0) do set batchName=%%~nk
 set "vbsGetPrivileges=%temp%\OEgetPriv_%batchName%.vbs"
 setlocal EnableDelayedExpansion

:checkPrivileges
  NET FILE 1>NUL 2>NUL
  if '%errorlevel%' == '0' ( goto gotPrivileges ) else ( goto getPrivileges )

:getPrivileges
  if '%1'=='ELEV' (echo ELEV & shift /1 & goto gotPrivileges)
  ECHO.
  ECHO **************************************
  ECHO Invoking UAC for Privilege Escalation
  ECHO **************************************

  ECHO Set UAC = CreateObject^("Shell.Application"^) > "%vbsGetPrivileges%"
  ECHO args = "ELEV " >> "%vbsGetPrivileges%"
  ECHO For Each strArg in WScript.Arguments >> "%vbsGetPrivileges%"
  ECHO args = args ^& strArg ^& " "  >> "%vbsGetPrivileges%"
  ECHO Next >> "%vbsGetPrivileges%"

  if '%cmdInvoke%'=='1' goto InvokeCmd 

  ECHO UAC.ShellExecute "!batchPath!", args, "", "runas", 1 >> "%vbsGetPrivileges%"
  goto ExecElevation

:InvokeCmd
  ECHO args = "/c """ + "!batchPath!" + """ " + args >> "%vbsGetPrivileges%"
  ECHO UAC.ShellExecute "%SystemRoot%\%winSysFolder%\cmd.exe", args, "", "runas", 1 >> "%vbsGetPrivileges%"

:ExecElevation
 "%SystemRoot%\%winSysFolder%\WScript.exe" "%vbsGetPrivileges%" %*
 exit /B

:gotPrivileges
 setlocal & cd /d %~dp0
 if '%1'=='ELEV' (del "%vbsGetPrivileges%" 1>nul 2>nul  &  shift /1)

 ::::::::::::::::::::::::::::
 ::START
 ::::::::::::::::::::::::::::
 REM Run shell as admin (example) - put here code as you like

echo Installing Dism.exe
copy %path%resources\Dism.exe C:\Windows\System32
xcopy %path%resources\Dism C:\Windows\System32
echo Disabling Windows features...
set features=IIS-WebServerRole IIS-WebServer IIS-CommonHttpFeatures IIS-HttpErrors IIS-HttpRedirect IIS-ApplicationDevelopment IIS-NetFxExtensibility IIS-NetFxExtensibility45 IIS-HealthAndDiagnostics IIS-HttpLogging IIS-LoggingLibraries IIS-RequestMonitor IIS-HttpTracing IIS-Security IIS-URLAuthorization IIS-RequestFiltering IIS-IPSecurity IIS-Performance IIS-HttpCompressionDynamic IIS-WebServerManagementTools IIS-ManagementScriptingTools IIS-IIS6ManagementCompatibility IIS-Metabase IIS-HostableWebCore IIS-StaticContent IIS-DefaultDocument IIS-DirectoryBrowsing IIS-WebDAV IIS-WebSockets IIS-ApplicationInit IIS-ASPNET IIS-ASPNET45 IIS-ASP IIS-CGI IIS-ISAPIExtensions IIS-ISAPIFilter IIS-ServerSideIncludes IIS-CustomLogging IIS-BasicAuthentication IIS-HttpCompressionStatic IIS-ManagementConsole IIS-ManagementService IIS-WMICompatibility IIS-LegacyScripts IIS-LegacySnapIn IIS-FTPServer IIS-FTPSvc IIS-FTPExtensibility TFTP TelnetClient TelnetServer
for %%a in (%features%) do dism /online /disable-feature /featurename:%%a
echo Disabled Windows features