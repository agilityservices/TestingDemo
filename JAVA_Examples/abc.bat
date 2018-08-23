set projectLocation=C:\Geetha(selenium)\eclipse-workspace\JAVA_Examples
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;
java org.testng.TestNG %projectLocation%\TestSuite.xml
pause