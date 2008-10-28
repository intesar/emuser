Readme:
 
How to setup this project
 
Install SVN Client on windows if not present, install it from this link (http://svn1clicksetup.tigris.org/files/documents/3106/33794/Svn1ClickSetup-1.3.3.exe) 
 RightClick wherever you want to import this project from SVN Repository (eg c:/dev/) and select "SVN Checkout" and copy this link in url field (https://emuser.googlecode.com/svn/trunk/ProAccounting) it will ask for your user/pass to find your username password visit this link (http://code.google.com/p/emuser/source/checkout)

Install Maven: download maven from this link (http://www.trieuvan.com/apache/maven/binaries/apache-maven-2.0.9-bin.zip), unzip to any directory for eg C:\maven\ so now your directory will look something like this (C:\maven\maven\apache-maven-2.0.9-bin\
Create Environment Variables: JAVA_HOME points to C:\Program Files\Java\Java6 etc and  M2_HOME points the above maven directory

test Maven: open CMD prompt and enter mvn if your cmd recognizes this command then maven is installed properly

Build Project : on CMD navigate to your project directory C:\dev\ProAccouting and type (mvn -U install) this will download all the jar files then it should say build is successfull

Run Project : type (mvn jetty:run) and navigate to (http://localhost:8080/ProAccounting)

Open Project using Eclipse (please follow eclipse guide on internet)

Open Project in netbeans, open tools, options, plugins, and install maven then you will be able to open the project in netbeans
 
  